package week12.day2;

import java.io.*;
import java.net.*;
import java.net.http.*;
import java.nio.file.*;

/**
 * [학습 예제] Week 12 Day 2 — HTTP 통신 완전 정복
 *
 * ★ 이 파일은 오늘 풀어야 할 연습 문제 5개의 핵심 기술을 모두 담고 있습니다.
 *
 * [문제별 학습 목표]
 * - 문제 1: HttpClient GET — https://jsonplaceholder.typicode.com/users/1 요청
 * - 문제 2: 응답 코드 확인 — statusCode() == 200 이면 본문 출력
 * - 문제 3: HttpURLConnection — 구버전 API로 동일 GET 요청
 * - 문제 4: 404 확인 — /users/9999 로 요청 → 404 응답 코드 확인
 * - 문제 5: 결과 파일 저장 — 응답 본문을 "api_result.txt"로 저장
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 1 & 2] Java 11+ HttpClient (최신 방법)
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - HttpClient: Java 11부터 제공하는 현대적 HTTP 클라이언트
 *  - HttpRequest.newBuilder().uri(URI).GET().build(): 요청 빌더 패턴
 *  - client.send(request, BodyHandlers.ofString()): 동기 방식 전송
 *  - response.statusCode(): HTTP 상태 코드 (200, 404 등)
 *  - response.body(): 응답 본문 문자열
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 3] HttpURLConnection (구버전)
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - Java 1.1부터 있던 레거시 HTTP API
 *  - URL → openConnection() → setRequestMethod("GET") → getResponseCode()
 *  - 응답 읽기: getInputStream() → InputStreamReader → BufferedReader
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 5] HTTP 응답 결과 파일 저장
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - Files.writeString(path, content): 한 줄로 파일 저장
 */
public class Example {
    static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    public static void main(String[] args) throws Exception {

        // ─────────────────────────────────────────────
        // Lab 1: HttpClient GET 요청 (→ 문제 1 참고)
        // ─────────────────────────────────────────────
        System.out.println("=== Lab 1: HttpClient GET 요청 ===");
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/users/1"))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        System.out.println("응답 코드: " + response.statusCode());
        System.out.println("응답 본문 (첫 100자): "
                + response.body().substring(0, Math.min(100, response.body().length())) + "...");

        // ─────────────────────────────────────────────
        // Lab 2: 응답 코드 200일 때만 본문 출력 (→ 문제 2 참고)
        // ─────────────────────────────────────────────
        System.out.println("\n=== Lab 2: 응답 코드 조건 분기 ===");
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

        // ─────────────────────────────────────────────
        // Lab 3: HttpURLConnection (구버전) (→ 문제 3 참고)
        // ─────────────────────────────────────────────
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

        // ─────────────────────────────────────────────
        // Lab 4: 404 응답 확인 (→ 문제 4 참고)
        // ─────────────────────────────────────────────
        System.out.println("\n=== Lab 4: 404 응답 확인 ===");
        HttpRequest req404 = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/users/9999")) // 존재하지 않는 리소스
                .GET()
                .build();
        HttpResponse<String> res404 = client.send(req404, HttpResponse.BodyHandlers.ofString());

        System.out.println("응답 코드: " + res404.statusCode()); // 404 예상
        if (res404.statusCode() == 404) {
            System.out.println("404 Not Found — 리소스가 존재하지 않습니다.");
        }

        // ─────────────────────────────────────────────
        // Lab 5: 응답 본문을 파일로 저장 (→ 문제 5 참고)
        // ─────────────────────────────────────────────
        System.out.println("\n=== Lab 5: API 결과 파일 저장 ===");
        if (response.statusCode() == 200) {
            Path outputPath = Paths.get("api_result.txt");
            Files.writeString(outputPath, response.body());
            System.out.println("api_result.txt 저장 완료!");
            System.out.println("저장 경로: " + outputPath.toAbsolutePath());

            // 저장 확인 (파일 첫 줄 읽기)
            String firstLine = Files.readAllLines(outputPath).get(0);
            System.out.println("저장된 첫 줄: " + firstLine);

            // 뒷정리
            Files.deleteIfExists(outputPath);
        }
    }
}
