package week12.day3;

/**
 * [학습 예제] Week 12 Day 3 — 정규식으로 JSON 특정 값 추출
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Lab: 정규식을 이용한 간단 파싱 ===");
        String json = "{\"userId\": 101, \"title\": \"Java 학습\"}";

        // title 값만 뽑아내기
        int titleIndex = json.indexOf("title");
        int startIndex = json.indexOf(":", titleIndex) + 2;
        int endIndex = json.indexOf("}", startIndex) - 1;

        String title = json.substring(startIndex, endIndex).replace("\"", "");
        System.out.println("추출된 제목: " + title);
    }
}
