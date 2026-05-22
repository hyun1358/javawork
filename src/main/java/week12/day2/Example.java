package week12.day2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * [학습 예제] Week 12 Day 2 — HttpURLConnection 및 java.nio.file (Files / Paths) API
 */
public class Example {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Lab 1: GET 요청 보내기 ===");
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

        System.out.println("\n=== Lab 2: java.nio.file.Files와 Paths를 이용한 파일 저장 ===");
        runNioWriteFile();
    }

    public static void runNioWriteFile() throws Exception {
        String data = "HTML Response data simulator";
        // Files.writeString과 Paths.get을 이용하여 한 줄로 손쉽게 파일을 생성 및 저장합니다.
        Files.writeString(Paths.get("download.txt"), data);
        System.out.println("NIO API를 사용하여 download.txt를 생성하고 텍스트를 기록했습니다.");
    }
}
