package week12.day2;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * [학습 예제 5] Week 12 Day 2 — HTTP 통신 완전 정복
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 5] HTTP 응답 결과 파일 저장
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - Files.writeString(path, content): 한 줄로 파일 저장
 *
 * [문제별 학습 목표]
 * - 문제 5: 결과 파일 저장 — 응답 본문을 "api_result.txt"로 저장
 */
public class Example5 {
    static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    public static void main(String[] args) throws Exception {
        System.out.println("\n=== Lab 5: API 결과 파일 저장 ===");
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/users/1"))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            Path outputPath = Paths.get("api_result.txt");
            Files.writeString(outputPath, response.body());
            System.out.println("api_result.txt 저장 완료!");

            // 저장 확인 (파일 첫 줄 읽기)
            String firstLine = Files.readAllLines(outputPath).get(0);
            System.out.println("저장된 첫 줄: " + firstLine);

            // 뒷정리
            Files.deleteIfExists(outputPath);
        }
    }
}
