package week12.day1;

import java.net.ServerSocket;

// ServerSocket을 사용하여 서버 측 소켓을 생성하고 포트를 여는 예제입니다.
public class Answer1 {
    // 메인 메서드
    public static void main(String[] args) {
        // try-with-resources 구문을 사용하여 ServerSocket을 생성합니다. 9000번 포트를 바인딩(연결)합니다.
        // 실행이 끝나거나 예외가 발생하면 자동으로 close()가 호출되어 자원을 반납합니다.
        try (ServerSocket server = new ServerSocket(9000)) {
            System.out.println("9000번 포트 서버 실행 중");
        } catch (Exception e) {
            // 포트가 이미 사용 중이거나 다른 네트워크 예외가 발생한 경우 예외를 무시하거나 처리할 수 있습니다.
        }
    }
}
