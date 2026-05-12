package week12.day2;

import java.net.URI;
import java.net.http.*;

public class Answer1 {
    public static void main(String[] args) throws Exception {
        HttpClient c = HttpClient.newHttpClient();
        HttpRequest r = HttpRequest.newBuilder().uri(URI.create("https://jsonplaceholder.typicode.com/users/1")).build();
        System.out.println(c.send(r, HttpResponse.BodyHandlers.ofString()).body());
    }
}
