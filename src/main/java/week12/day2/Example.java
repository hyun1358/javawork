package week12.day2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * [학습 예제] Week 12 Day 2 — HttpURLConnection 및 Files API 활용
 * 
 * [학습 핵심 이론: 구식 API와 현대 NIO의 만남]
 * 1. HttpURLConnection 활용법:
 *    - 비록 구식이지만 레거시 프로젝트나 가벼운 모듈에서 여전히 사용되는 기본 Connection 객체의 응답 코드 검증(200 OK 등)과 입력 바이트 처리 구조를 다룹니다.
 * 
 * 2. 가져온 데이터를 파일로 보관:
 *    - HTTP 통신으로 네트워크 너머에서 가져온 소중한 문자열 웹 데이터를 `java.nio.file.Files` 유틸을 활용해 내 하드디스크의 텍스트 파일로 영구 안전 보존하는 종합 실습을 진행합니다.
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
