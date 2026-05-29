package week12.day2;

import java.net.URI;
import java.net.http.*;

// 존재하지 않는 리소스를 요청하여 HTTP 404(Not Found) 에러 코드를 확인하는 예제입니다.
public class Answer4 {
    // 메인 메서드
    public static void main(String[] args) throws Exception {
        // 일부러 존재하지 않는 유저(9999) 정보를 요청합니다.
        HttpResponse<String> res = HttpClient.newHttpClient().send(
                HttpRequest.newBuilder().uri(URI.create("https://jsonplaceholder.typicode.com/users/9999")).build(),
                HttpResponse.BodyHandlers.ofString()
        );
        // 정상 응답이 아닌 경우의 상태 코드(404 등)를 출력합니다.
        System.out.println("응답: " + res.statusCode()); // 404 출력
    }
}
