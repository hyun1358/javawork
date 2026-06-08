package week12.day2;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * [학습 예제 2] Week 12 Day 2 — HTTP 통신 완전 정복
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 2] 응답 코드 확인
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - response.statusCode(): HTTP 상태 코드 (200, 404 등)
 *  - response.body(): 응답 본문 문자열
 *
 * [문제별 학습 목표]
 * - 문제 2: 응답 코드 확인 — statusCode() == 200 이면 본문 출력
 */
public class Example2 {
    static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    public static void main(String[] args) throws Exception {
        System.out.println("\n=== Lab 2: 응답 코드 조건 분기 ===");
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest req2 = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/posts/1"))
                .GET()
                .build();
        HttpResponse<String> res2 = client.send(req2, HttpResponse.BodyHandlers.ofString());

        if (res2.statusCode() == 200) {
            System.out.println("200 OK — 본문 출력:");
            System.out.println("  " + res2.body().substring(0, Math.min(80, res2.body().length())));
        } else {
            System.out.println("오류 발생! 코드: " + res2.statusCode());
        }
    }
}
