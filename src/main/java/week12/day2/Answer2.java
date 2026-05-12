package week12.day2;

import java.net.URI;
import java.net.http.*;

public class Answer2 {
    public static void main(String[] args) throws Exception {
        HttpResponse<String> res = HttpClient.newHttpClient().send(
                HttpRequest.newBuilder().uri(URI.create("https://jsonplaceholder.typicode.com/users/1")).build(),
                HttpResponse.BodyHandlers.ofString()
        );
        if (res.statusCode() == 200) System.out.println("성공: " + res.body());
        else System.out.println("실패: " + res.statusCode());
    }
}
