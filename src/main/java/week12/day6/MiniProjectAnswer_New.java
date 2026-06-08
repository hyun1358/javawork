package week12.day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * [종합 미니 프로젝트 정답 - 신규] Week 12 Day 6
 * 「 멀티스레드 TCP 채팅 서버 및 HTTP API 연동 챗봇 시스템 」
 */
public class MiniProjectAnswer_New {
    private static final int TCP_PORT = 5001;
    private static final int UDP_PORT = 5002;
    
    // 현재 접속된 클라이언트 출력 스트림 목록 (스레드 세이프 리스트)
    protected static List<PrintWriter> clientWriters = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) {
        // Day 1: 네트워크 기초 - 호스트 주소 및 IP 출력
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("=============================================");
            System.out.println("[서버 정보] 호스트 이름: " + localHost.getHostName());
            System.out.println("[서버 정보] 내부 IP 주소: " + localHost.getHostAddress());
            System.out.println("=============================================");
        } catch (IOException e) {
            System.out.println("호스트 정보 획득 실패: " + e.getMessage());
        }

        // Day 3: UDP 소켓을 통한 긴급 공지 수신 채널 별도 스레드 구동
        Thread udpListener = new Thread(MiniProjectAnswer_New::startUdpListener);
        udpListener.setDaemon(true); // 프로그램 종료 시 동시 종료
        udpListener.start();

        // Day 4: 멀티스레드 처리를 위한 스레드 풀 생성 (동시 처리용)
        ExecutorService pool = Executors.newFixedThreadPool(10);

        // Day 2: TCP ServerSocket 가동
        try (ServerSocket serverSocket = new ServerSocket(TCP_PORT)) {
            System.out.println("[TCP 서버] 포트 " + TCP_PORT + "에서 대기 중...");
            System.out.println("[참고] 채팅방 챗봇 명령어: '/fact'를 입력하면 고양이 상식 API 연동");
            System.out.println("[참고] UDP 공지사항 테스트: UDP 포트 " + UDP_PORT + "로 패킷 송신");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("[접속] 새로운 클라이언트 연결됨: " + socket.getRemoteSocketAddress());
                
                // 스레드 풀에 클라이언트 통신 핸들러 제출
                pool.execute(new ClientHandler(socket));
            }
        } catch (IOException e) {
            System.out.println("[서버 오류] 소켓 구동 실패: " + e.getMessage());
        } finally {
            pool.shutdown();
        }
    }

    // Day 3: UDP 수신 채널 구동 (브로드캐스트 공지사항용)
    private static void startUdpListener() {
        try (DatagramSocket udpSocket = new DatagramSocket(UDP_PORT)) {
            byte[] buffer = new byte[1024];
            System.out.println("[UDP 리스너] 포트 " + UDP_PORT + "에서 긴급 공지 수신 대기 시작.");

            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                udpSocket.receive(packet); // 대기

                String message = new String(packet.getData(), 0, packet.getLength()).trim();
                String announcement = "[★긴급 공지사항] " + message;
                System.out.println("[UDP 수신] 공지 내용 전파: " + message);

                // 모든 TCP 접속자에게 공지 브로드캐스트
                broadcast(announcement);
            }
        } catch (IOException e) {
            System.out.println("[UDP 에러] " + e.getMessage());
        }
    }

    // 접속한 모든 클라이언트에게 메시지 전송
    public static void broadcast(String message) {
        synchronized (clientWriters) {
            for (PrintWriter writer : clientWriters) {
                writer.println(message);
            }
        }
    }
}

// Day 4: 클라이언트별 실시간 송수신 처리를 담당하는 멀티스레드 핸들러
class ClientHandler implements Runnable {
    private Socket socket;
    private PrintWriter out;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)
        ) {
            this.out = writer;
            // 공유 출력 목록에 등록
            MiniProjectAnswer_New.clientWriters.add(out);
            out.println("★ 채팅방에 오신 것을 환영합니다! ★");
            out.println("도움말: '/fact'를 입력하면 챗봇이 무작위 상식을 수집하여 전송해 드립니다.");

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                String msg = inputLine.trim();
                
                // 챗봇 명령어 확인
                if (msg.equalsIgnoreCase("/fact")) {
                    out.println("[챗봇] 외부 API로부터 무작위 고양이 지식을 수집 중입니다...");
                    // Day 5: HTTP API 연동 호출
                    String fact = HttpApiHelper.fetchRandomFact();
                    out.println("[챗봇 결과] " + fact);
                } else {
                    // 일반 메시지는 모두에게 브로드캐스트
                    MiniProjectAnswer_New.broadcast("[User-" + socket.getPort() + "]: " + msg);
                }
            }
        } catch (IOException e) {
            System.out.println("[연결 종료] 클라이언트 통신 소실: " + socket.getRemoteSocketAddress());
        } finally {
            if (out != null) {
                MiniProjectAnswer_New.clientWriters.remove(out);
            }
            try {
                socket.close();
            } catch (IOException e) {
                // 무시
            }
        }
    }
}

// Day 5: HTTP 클라이언트를 구현한 외부 API 연동 챗봇 엔진
class HttpApiHelper {
    private static final String API_URL = "https://catfact.ninja/fact";
    
    // 오프라인/연결 실패 시 로컬 Fallback 응답용 셋
    private static final String[] MOCK_FACTS = {
        "고양이는 하루 평균 12~16시간을 잠을 자며 보냅니다.",
        "고양이의 뇌는 개보다 인간의 뇌와 생물학적으로 더 가깝습니다.",
        "고양이는 단맛을 느끼지 못하는 유전적 특징을 가지고 있습니다.",
        "고양이는 수염을 통해 주변의 공기 흐름과 공간을 감지합니다."
    };

    public static String fetchRandomFact() {
        HttpURLConnection conn = null;
        try {
            URL url = new URL(API_URL);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(3000); // 3초 타임아웃
            conn.setReadTimeout(3000);

            int status = conn.getResponseCode();
            if (status == 200) {
                // 성공적으로 데이터 로드
                try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = in.readLine()) != null) {
                        response.append(line);
                    }
                    
                    // JSON 파싱 기초 구현
                    // 수신 텍스트 예: {"fact":"Cats sleep 70% of their lives.","length":30}
                    String json = response.toString();
                    int factIndex = json.indexOf("\"fact\":\"");
                    if (factIndex != -1) {
                        int startIndex = factIndex + 8;
                        int endIndex = json.indexOf("\",\"", startIndex);
                        if (endIndex != -1) {
                            return json.substring(startIndex, endIndex);
                        }
                    }
                    return json; // 파싱 실패 시 원본 전송
                }
            }
        } catch (Exception e) {
            // 인터넷 연결 안 됨 또는 타임아웃 시 안전 장치로 Fallback 리턴
            System.out.println("[서버 경고] 외부 API 조회 불가 (오프라인 상태 등). 로컬 데이터를 대신 반환합니다.");
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }

        // 로컬 랜덤 지식 반환
        return MOCK_FACTS[new Random().nextInt(MOCK_FACTS.length)] + " (로컬 캐시 데이터)";
    }
}
