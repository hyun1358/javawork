package week12.day2;

import java.nio.file.*;
import java.net.URI;
import java.net.http.*;

// API로 얻어온 데이터를 파일 시스템(텍스트 파일)에 직접 저장하는 예제입니다.
public class Answer5 {
    // 메인 메서드
    public static void main(String[] args) throws Exception {
        // HttpClient를 사용하여 API를 호출하고 결과 본문(body)만 String 형태로 가져옵니다.
        String body = HttpClient.newHttpClient().send(
                HttpRequest.newBuilder().uri(URI.create("https://jsonplaceholder.typicode.com/users/1")).build(),
                HttpResponse.BodyHandlers.ofString()
        ).body();
        
        // Files.writeString() 유틸리티 메서드를 사용하여 문자열 데이터를 "api_result.txt" 파일에 저장합니다.
        Files.writeString(Paths.get("api_result.txt"), body);
        // 저장이 완료되었음을 사용자에게 알립니다.
        System.out.println("파일 저장 완료");
    }
}
