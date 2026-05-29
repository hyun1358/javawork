package week12.day2;

import java.net.URI;
import java.net.http.*;

// HttpClient를 사용하여 API 요청을 보내고, HTTP 상태 코드를 확인하여 성공/실패를 분기하는 예제입니다.
public class Answer2 {
    // 메인 메서드
    public static void main(String[] args) throws Exception {
        // HTTP 요청을 보내고 응답을 HttpResponse<String> 형태로 받습니다.
        HttpResponse<String> res = HttpClient.newHttpClient().send(
                HttpRequest.newBuilder().uri(URI.create("https://jsonplaceholder.typicode.com/users/1")).build(),
                HttpResponse.BodyHandlers.ofString()
        );
        
        // HTTP 응답 상태 코드(statusCode)가 200(OK)이면 성공으로 간주하고 본문을 출력합니다.
        if (res.statusCode() == 200) {
            System.out.println("성공: " + res.body());
        } else {
            // 그 외의 코드는 실패로 간주하고 상태 코드를 출력합니다.
            System.out.println("실패: " + res.statusCode());
        }
    }
}
