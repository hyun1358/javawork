package week12.day3;

/**
 * [학습 예제 5] Week 12 Day 3 — JSON 완전 정복 (외부 라이브러리 없이)
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 5] Gson vs Jackson
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  Gson (Google):
 *    - new Gson().toJson(object): 객체 → JSON 문자열
 *    - new Gson().fromJson(json, Class): JSON → 객체
 *
 *  Jackson (FasterXML):
 *    - ObjectMapper().writeValueAsString(object): 객체 → JSON
 *    - ObjectMapper().readValue(json, Class): JSON → 객체
 *    - Spring Boot 기본 내장 라이브러리 (실무 표준)
 *
 * [문제별 학습 목표]
 * - 문제 5: Gson / Jackson 설명 — 역할과 차이점 주석 정리
 */
public class Example5 {
    public static void main(String[] args) {
        System.out.println("\n=== Lab 5: Gson / Jackson 라이브러리 ===");
        System.out.println("Gson:    new Gson().toJson(obj)  /  gson.fromJson(json, Class)");
        System.out.println("Jackson: mapper.writeValueAsString(obj)  /  mapper.readValue(json, Class)");
        System.out.println("Spring Boot는 Jackson을 기본 내장하여 자동으로 JSON 변환에 사용함");
    }
}
