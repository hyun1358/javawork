package week12.day2;

import java.nio.file.*;
import java.net.URI;
import java.net.http.*;

public class Answer5 {
    public static void main(String[] args) throws Exception {
        String body = HttpClient.newHttpClient().send(
                HttpRequest.newBuilder().uri(URI.create("https://jsonplaceholder.typicode.com/users/1")).build(),
                HttpResponse.BodyHandlers.ofString()
        ).body();
        Files.writeString(Paths.get("api_result.txt"), body);
        System.out.println("파일 저장 완료");
    }
}
