package week12.day2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * [학습 예제] Week 12 Day 2 — 구버전 HttpURLConnection
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Lab: GET 요청 보내기 ===");
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/posts/1");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            System.out.println("응답 코드: " + conn.getResponseCode());
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            System.out.println("내용: " + br.readLine());

            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
