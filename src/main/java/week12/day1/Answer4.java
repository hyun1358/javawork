package week12.day1;

// 네트워크 소켓 통신에서 클라이언트가 보낸 데이터를 읽어오는 기본 패턴을 설명하는 예제입니다.
public class Answer4 {
    // 메인 메서드
    public static void main(String[] args) {
        /*
         * [소켓 데이터 읽기 과정]
         * 1. accept()를 통해 클라이언트와 연결된 Socket 객체를 얻습니다.
         *    Socket socket = server.accept();
         * 2. socket.getInputStream()으로 소켓의 바이트 입력 스트림을 가져오고, 
         *    InputStreamReader를 거쳐 문자 스트림으로 변환한 뒤, 
         *    BufferedReader로 감싸서 줄 단위(readLine) 읽기 기능을 사용합니다.
         *    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
         * 3. readLine()으로 클라이언트가 보낸 메시지 한 줄을 읽습니다. 
         *    (데이터가 올 때까지 블로킹됩니다.)
         *    String msg = in.readLine();
         */
    }
}
