package week12.day2;

import java.net.URI;
import java.net.http.*;

public class Answer4 {
    public static void main(String[] args) throws Exception {
        HttpResponse<String> res = HttpClient.newHttpClient().send(
                HttpRequest.newBuilder().uri(URI.create("https://jsonplaceholder.typicode.com/users/9999")).build(),
                HttpResponse.BodyHandlers.ofString()
        );
        System.out.println("응답: " + res.statusCode()); // 404 출력
    }
}
