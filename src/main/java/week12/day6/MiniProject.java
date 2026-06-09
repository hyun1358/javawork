package week12.day6;

import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// =========================================================================
// [1] Domain 및 간단한 JSON 직렬화/역직렬화 Helper (Day 3 대응)
// =========================================================================
class Score {
    private String name;
    private int score;

    public Score(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() { return name; }
    public int getScore() { return score; }

    // 객체 -> JSON 문자열 직렬화
    public String toJson() {
        return String.format("{\"name\":\"%s\",\"score\":%d}", name, score);
    }

    // JSON 문자열 -> 객체 역직렬화 Helper
    public static Score fromJson(String json) {
        try {
            // 정밀한 JSON 파서 라이브러리 대신, 단순 문자열 가공으로 파싱을 흉내 냅니다.
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
            return new Score(name, score);
        } catch (Exception e) {
            throw new IllegalArgumentException("올바르지 않은 JSON 형식입니다: " + json, e);
        }
    }

    @Override
    public String toString() {
        return "Score{name='" + name + "', score=" + score + "}";
    }
}

// =========================================================================
// [2] Repository Layer (데이터베이스 연동 계층 - Day 4 대응)
// =========================================================================
interface ScoreRepository {
    void save(Score score);
    List<Score> findAll();
}

class JdbcScoreRepository implements ScoreRepository {
    private static final String DB_URL = "jdbc:h2:mem:scoredb;DB_CLOSE_DELAY=-1";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "";
    
    private List<Score> fallbackList = new ArrayList<>();
    private boolean useFallback = false;

    public JdbcScoreRepository() {
        // H2 DB 드라이버 로드 실패 시, 메모리 저장소로 폴백하도록 설계
        try {
            Class.forName("org.h2.Driver");
            initTable();
        } catch (ClassNotFoundException e) {
            System.err.println("[WARN] H2 드라이버가 클래스 패스에 없어 메모리 폴백 모드로 동작합니다.");
            useFallback = true;
        }
    }

    private void initTable() {
        // TODO: Connection을 생성하여 "CREATE TABLE IF NOT EXISTS scores (name VARCHAR(50), score INT)" 테이블 생성 쿼리를 실행해 보세요.
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute("CREATE TABLE IF NOT EXISTS scores (name VARCHAR(50), score INT)");
        } catch (SQLException e) {
            System.err.println("테이블 초기화 실패: " + e.getMessage());
            useFallback = true;
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    @Override
    public void save(Score score) {
        if (useFallback) {
            fallbackList.add(score);
            return;
        }

        // TODO: Connection과 PreparedStatement를 획득하여 "INSERT INTO scores (name, score) VALUES (?, ?)" 쿼리를 작성하고 실행해 보세요.
        
    }

    @Override
    public List<Score> findAll() {
        if (useFallback) {
            return fallbackList;
        }

        List<Score> list = new ArrayList<>();
        // TODO: Connection과 PreparedStatement를 획득하여 "SELECT name, score FROM scores" 쿼리를 작성하고 ResultSet을 순회하며 리스트를 반환하세요.
        
        return list;
    }
}

// =========================================================================
// [3] Service Layer (비즈니스 로직 계층 - Day 2 & Day 5 대응)
// =========================================================================
class ScoreService {
    private final ScoreRepository repository;

    public ScoreService(ScoreRepository repository) {
        this.repository = repository;
    }

    public void registerScore(Score score) {
        // 비즈니스 룰 검증
        if (score.getScore() < 0 || score.getScore() > 100) {
            throw new IllegalArgumentException("점수는 0점에서 100점 사이여야 합니다.");
        }
        repository.save(score);
    }

    public List<Score> getScoreList() {
        return repository.findAll();
    }

    public double calculateAverage() {
        List<Score> list = repository.findAll();
        if (list.isEmpty()) return 0.0;
        int sum = 0;
        for (Score s : list) {
            sum += s.getScore();
        }
        return (double) sum / list.size();
    }

    /**
     * 외부 HTTP API를 요청하여 오늘의 랜덤 격언(영어조언)을 파싱하여 가져옵니다.
     */
    public String getInspiringAdvice() {
        // TODO: HttpClient 또는 HttpURLConnection을 활용하여 "https://api.adviceslip.com/advice"에 GET 요청을 보내고 격언을 가져와 보세요.
        // (팁: 네트워크 지연 방지를 위해 타임아웃을 적용하고, 실패 시 로컬 기본 격언 "Keep coding, keep growing!"을 반환하도록 예외 처리를 튼튼히 하세요.)
        
        return "Keep coding, keep growing! (Local fallback)";
    }
}

// =========================================================================
// [4] Presentation Layer (소켓 서버 Presentation 계층 - Day 1 & Day 5 대응)
// =========================================================================
class SocketServer {
    private final ScoreService service;
    private final int port;
    private boolean running = true;

    public SocketServer(ScoreService service, int port) {
        this.service = service;
        this.port = port;
    }

    public void start() {
        new Thread(() -> {
            try (ServerSocket serverSocket = new ServerSocket(port)) {
                System.out.println("[SERVER] 포트 " + port + "에서 네트워크 성적 관리 서버 실행 중...");
                while (running) {
                    Socket socket = serverSocket.accept();
                    // 요청 처리를 위해 핸들러 실행
                    handleClient(socket);
                }
            } catch (IOException e) {
                System.err.println("서버 소켓 에러: " + e.getMessage());
            }
        }).start();
    }

    private void handleClient(Socket socket) {
        try (
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
        ) {
            String request = in.readLine();
            if (request == null) return;

            // TODO: 클라이언트의 요청이 "LIST"인 경우 서비스의 getScoreList() 결과와 평균 점수, 
            //       그리고 getInspiringAdvice() 격언을 조립하여 클라이언트에 출력해 보세요.
            //       요청이 "ADD:[JSON문자열]"인 경우 Score.fromJson을 통해 객체 역직렬화 후 registerScore()를 호출하여 추가하세요.
            
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
    }
}

// =========================================================================
// [5] 메인 실행 및 테스트 클라이언트 클래스
// =========================================================================
public class MiniProject {
    public static void main(String[] args) throws Exception {
        // 1. 의존성 조립 및 3계층 아키텍처 결합
        ScoreRepository repository = new JdbcScoreRepository();
        ScoreService service = new ScoreService(repository);
        SocketServer server = new SocketServer(service, 8080);

        // 2. 서버 실행
        server.start();
        Thread.sleep(1000); // 서버가 구동될 시간을 잠시 대기합니다.

        // 3. 테스트 클라이언트 시뮬레이션 실행 (서버 소켓 포트 8080에 접속하여 쿼리 전송)
        System.out.println("--- 클라이언트 데이터 전송 시작 ---");
        
        // 데이터 1 추가
        sendRequest("ADD:{\"name\":\"홍길동\",\"score\":95}");
        // 데이터 2 추가
        sendRequest("ADD:{\"name\":\"이순신\",\"score\":88}");
        
        // 전체 목록 및 격언 조회
        System.out.println("\n--- 전체 목록 및 분석 요청 ---");
        sendRequest("LIST");

        // 4. 안전한 서버 종료
        server.stop();
        System.exit(0);
    }

    private static void sendRequest(String command) {
        try (
            Socket socket = new Socket("localhost", 8080);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            // 명령 전송
            out.println(command);
            // 응답 출력
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println("[CLIENT 수신] " + line);
            }
        } catch (Exception e) {
            System.err.println("클라이언트 요청 전송 실패: " + e.getMessage());
        }
    }
}
