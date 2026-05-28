package week12.day3;

/**
 * [학습 예제] Week 12 Day 3 — 정규식으로 JSON 특정 값 추출
 * 
 * [학습 핵심 이론: 외부 라이브러리 없이 JSON 파싱해보기]
 * 1. 정규 표현식 (Regular Expression):
 *    - 특정 규칙을 가진 문자열 집합을 표현하는 정교한 텍스트 패턴 식입니다. (예: `"name"\s*:\s*"([^"]+)"`)
 * 
 * 2. Pattern과 Matcher의 작동 원리:
 *    - 자바의 `Pattern.compile()`을 통해 정규식을 고속 매칭 머신 객체로 기계 컴파일하고, `Matcher` 객체를 통해 JSON 문자열 내를 서치하여 원하는 Key의 Value(그룹 데이터)만 쏙 빼내는 고급 텍스트 분석 기법을 학습합니다.
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
