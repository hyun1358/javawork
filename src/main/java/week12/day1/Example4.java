package week12.day1;

/**
 * [학습 예제 4] Week 12 Day 1 — 소켓 통신(Socket Programming) 완전 정복
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 4] 소켓 입출력 스트림
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - socket.getOutputStream(): 데이터를 상대방에게 보내는 스트림
 *  - socket.getInputStream():  상대방이 보낸 데이터를 받는 스트림
 *  - PrintWriter(out, true): 자동 flush로 문자열 전송
 *  - BufferedReader.readLine(): 한 줄씩 수신
 *
 * [문제별 학습 목표]
 * - 문제 4: 에코 서버 뼈대 — InputStream/BufferedReader 로 메시지 읽기
 */
public class Example4 {
    public static void main(String[] args) {
        System.out.println("\n=== Lab 4: 에코 서버 구조 ===");
        /*
         * [에코 서버 동작 순서]
         *  1. ServerSocket serverSocket = new ServerSocket(9000);
         *     → 포트 9000 개방
         *  2. Socket clientSocket = serverSocket.accept();
         *     → 클라이언트가 접속할 때까지 블로킹 대기
         *  3. BufferedReader in = new BufferedReader(
         *         new InputStreamReader(clientSocket.getInputStream()));
         *     → 클라이언트로부터 오는 바이트 스트림을 문자(라인)로 변환
         *  4. String msg = in.readLine();
         *     → 클라이언트가 보낸 한 줄 메시지 수신
         *  5. PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
         *     out.println("[에코] " + msg);
         *     → 받은 메시지를 그대로 클라이언트에게 돌려보냄 (에코)
         *  6. clientSocket.close(); serverSocket.close();
         *     → 반드시 연결 종료 (리소스 반환)
         */
        System.out.println("에코 서버: 클라이언트 메시지를 받아 그대로 돌려보내는 구조");
    }
}
