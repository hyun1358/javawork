package week12.day2;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * [예습 파일] Week 12 Day 2 — HTTP 통신 (Java 11 HttpClient)
 */
public class Preview {
    public static void main(String[] args) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://jsonplaceholder.typicode.com/todos/1"))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("상태 코드: " + response.statusCode());
            System.out.println("본문: " + response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
