package week12.day6;

import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// =========================================================================
// [1] Domain 및 간단한 JSON 직렬화/역직렬화 Helper (Day 3 대응)
// =========================================================================
class AnswerScore {
    private String name;
    private int score;

    public AnswerScore(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() { return name; }
    public int getScore() { return score; }

    public String toJson() {
        return String.format("{\"name\":\"%s\",\"score\":%d}", name, score);
    }

    public static AnswerScore fromJson(String json) {
        try {
            // 표준 API와 String 가공으로 JSON 파싱 구현
            String clean = json.trim().replace("{", "").replace("}", "").replace("\"", "");
            String[] parts = clean.split(",");
            String name = "";
            int score = 0;
            for (String part : parts) {
                String[] pair = part.split(":");
                String key = pair[0].trim();
                String value = pair[1].trim();
                if (key.equalsIgnoreCase("name")) {
                    name = value;
                } else if (key.equalsIgnoreCase("score")) {
                    score = Integer.parseInt(value);
                }
            }
            return new AnswerScore(name, score);
        } catch (Exception e) {
            throw new IllegalArgumentException("올바르지 않은 JSON 형식입니다: " + json, e);
        }
    }

    @Override
    public String toString() {
        return "AnswerScore{name='" + name + "', score=" + score + "}";
    }
}

// =========================================================================
// [2] Repository Layer (데이터베이스 연동 계층 - Day 4 대응)
// =========================================================================
interface AnswerScoreRepository {
    void save(AnswerScore score);
    List<AnswerScore> findAll();
}

class AnswerJdbcScoreRepository implements AnswerScoreRepository {
    private static final String DB_URL = "jdbc:h2:mem:scoredb_ans;DB_CLOSE_DELAY=-1";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "";
    
    private List<AnswerScore> fallbackList = new ArrayList<>();
    private boolean useFallback = false;

    public AnswerJdbcScoreRepository() {
        try {
            Class.forName("org.h2.Driver");
            initTable();
        } catch (ClassNotFoundException e) {
            System.err.println("[WARN] H2 드라이버가 클래스 패스에 없어 메모리 폴백 모드로 동작합니다.");
            useFallback = true;
        }
    }

    private void initTable() {
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute("CREATE TABLE IF NOT EXISTS scores_ans (name VARCHAR(50), score INT)");
        } catch (SQLException e) {
            System.err.println("테이블 초기화 실패: " + e.getMessage());
            useFallback = true;
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    @Override
    public void save(AnswerScore score) {
        if (useFallback) {
            fallbackList.add(score);
            return;
        }

        String sql = "INSERT INTO scores_ans (name, score) VALUES (?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, score.getName());
            pstmt.setInt(2, score.getScore());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("성적 저장 실패 (DB): " + e.getMessage());
            fallbackList.add(score); // 에러 발생 시 메모리 보관으로 안정적 폴백
        }
    }

    @Override
    public List<AnswerScore> findAll() {
        if (useFallback) {
            return fallbackList;
        }

        List<AnswerScore> list = new ArrayList<>();
        String sql = "SELECT name, score FROM scores_ans";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                list.add(new AnswerScore(rs.getString("name"), rs.getInt("score")));
            }
        } catch (SQLException e) {
            System.err.println("성적 조회 실패 (DB): " + e.getMessage());
            return fallbackList;
        }
        return list;
    }
}

// =========================================================================
// [3] Service Layer (비즈니스 로직 계층 - Day 2 & Day 5 대응)
// =========================================================================
class AnswerScoreService {
    private final AnswerScoreRepository repository;

    public AnswerScoreService(AnswerScoreRepository repository) {
        this.repository = repository;
    }

    public void registerScore(AnswerScore score) {
        if (score.getScore() < 0 || score.getScore() > 100) {
            throw new IllegalArgumentException("점수는 0점에서 100점 사이여야 합니다.");
        }
        repository.save(score);
    }

    public List<AnswerScore> getScoreList() {
        return repository.findAll();
    }

    public double calculateAverage() {
        List<AnswerScore> list = repository.findAll();
        if (list.isEmpty()) return 0.0;
        int sum = 0;
        for (AnswerScore s : list) {
            sum += s.getScore();
        }
        return (double) sum / list.size();
    }

    /**
     * 외부 HTTP API를 요청하여 오늘의 랜덤 격언(영어조언)을 수집하여 파싱합니다.
     */
    public String getInspiringAdvice() {
        try {
            URL url = new URI("https://api.adviceslip.com/advice").toURL();
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(2000); // 2초 제한
            conn.setReadTimeout(2000);
            
            if (conn.getResponseCode() == 200) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"))) {
                    StringBuilder sb = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        sb.append(line);
                    }
                    String response = sb.toString();
                    
                    // JSON 가공 파싱 ("advice":"..." 추출)
                    int index = response.indexOf("\"advice\":");
                    if (index != -1) {
                        int start = response.indexOf("\"", index + 9) + 1;
                        int end = response.indexOf("\"", start);
                        return response.substring(start, end);
                    }
                }
            }
        } catch (Exception e) {
            // 네트워크 연결 실패 시 로컬 기본 격언으로 조용히 대체
        }
        return "Keep coding, keep growing! (Local fallback)";
    }
}

// =========================================================================
// [4] Presentation Layer (소켓 서버 Presentation 계층 - Day 1 & Day 5 대응)
// =========================================================================
class AnswerSocketServer {
    private final AnswerScoreService service;
    private final int port;
    private ServerSocket serverSocket;
    private boolean running = true;

    public AnswerSocketServer(AnswerScoreService service, int port) {
        this.service = service;
        this.port = port;
    }

    public void start() {
        new Thread(() -> {
            try {
                serverSocket = new ServerSocket(port);
                System.out.println("[SERVER] 포트 " + port + "에서 네트워크 성적 관리 서버 실행 중...");
                while (running) {
                    try {
                        Socket socket = serverSocket.accept();
                        handleClient(socket);
                    } catch (SocketException e) {
                        if (!running) break; // 서버가 안전하게 종료되었을 때 break
                    }
                }
            } catch (IOException e) {
                System.err.println("서버 소켓 에러: " + e.getMessage());
            }
        }).start();
    }

    private void handleClient(Socket socket) {
        try (
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true)
        ) {
            String request = in.readLine();
            if (request == null) return;

            if (request.startsWith("ADD:")) {
                String json = request.substring(4);
                AnswerScore score = AnswerScore.fromJson(json);
                service.registerScore(score);
                out.println("SUCCESS: 성적이 추가되었습니다.");
            } else if (request.equals("LIST")) {
                List<AnswerScore> list = service.getScoreList();
                out.println("=== 학생 성적 목록 ===");
                for (AnswerScore s : list) {
                    out.println("- " + s.getName() + " : " + s.getScore() + "점");
                }
                out.println("평균 점수: " + String.format("%.2f", service.calculateAverage()) + "점");
                out.println("오늘의 조언: \"" + service.getInspiringAdvice() + "\"");
            } else {
                out.println("ERROR: 알 수 없는 명령입니다.");
            }
        } catch (Exception e) {
            System.err.println("클라이언트 요청 처리 중 에러: " + e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException ignored) {}
        }
    }

    public void stop() {
        this.running = false;
        try {
            if (serverSocket != null && !serverSocket.isClosed()) {
                serverSocket.close();
            }
        } catch (IOException e) {
            System.err.println("서버 닫기 중 오류: " + e.getMessage());
        }
    }
}

// =========================================================================
// [5] 메인 실행 및 테스트 클라이언트 클래스
// =========================================================================
public class MiniProjectAnswer {
    public static void main(String[] args) throws Exception {
        // 1. 의존성 조립 및 3계층 아키텍처 결합
        AnswerScoreRepository repository = new AnswerJdbcScoreRepository();
        AnswerScoreService service = new AnswerScoreService(repository);
        AnswerSocketServer server = new AnswerSocketServer(service, 8081); // 메인 실습 포트(8080)와의 충돌 방지를 위해 8081 지정

        // 2. 서버 실행
        server.start();
        Thread.sleep(1000); // 서버 시작 시간 잠시 대기

        // 3. 테스트 클라이언트 시뮬레이션 실행 (성적 데이터 추가 및 리스트 조회)
        System.out.println("--- 클라이언트 데이터 전송 시작 ---");
        sendRequest("ADD:{\"name\":\"홍길동\",\"score\":95}");
        sendRequest("ADD:{\"name\":\"이순신\",\"score\":88}");
        
        System.out.println("\n--- 전체 목록 및 분석 요청 ---");
        sendRequest("LIST");

        // 4. 안전하게 서버 중지
        server.stop();
        System.exit(0);
    }

    private static void sendRequest(String command) {
        try (
            Socket socket = new Socket("localhost", 8081);
            PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"))
        ) {
            out.println(command);
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println("[CLIENT 수신] " + line);
            }
        } catch (Exception e) {
            System.err.println("클라이언트 요청 전송 실패: " + e.getMessage());
        }
    }
}
