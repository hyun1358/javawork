package week12.day2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * [학습 예제 3] Week 12 Day 2 — HTTP 통신 완전 정복
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 3] HttpURLConnection (구버전)
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - Java 1.1부터 있던 레거시 HTTP API
 *  - URL → openConnection() → setRequestMethod("GET") → getResponseCode()
 *  - 응답 읽기: getInputStream() → InputStreamReader → BufferedReader
 *
 * [문제별 학습 목표]
 * - 문제 3: HttpURLConnection — 구버전 API로 동일 GET 요청
 */
public class Example3 {
    static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    public static void main(String[] args) {
        System.out.println("\n=== Lab 3: HttpURLConnection (구버전 API) ===");
        try {
            URL url = new URL(BASE_URL + "/users/1");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            int code = conn.getResponseCode();
            System.out.println("응답 코드: " + code);

            if (code == 200) {
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(conn.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) sb.append(line);
                System.out.println("본문 (첫 80자): " + sb.substring(0, Math.min(80, sb.length())));
            }
            conn.disconnect();
        } catch (Exception e) {
            System.out.println("HttpURLConnection 오류: " + e.getMessage());
        }
    }
}
