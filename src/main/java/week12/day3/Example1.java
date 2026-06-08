package week12.day3;

/**
 * [학습 예제 1] Week 12 Day 3 — JSON 완전 정복 (외부 라이브러리 없이)
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 1] JSON 형식
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  JSON(JavaScript Object Notation): 키-값 쌍의 경량 데이터 교환 형식
 *  객체: { "key": value, "key2": value2 }
 *
 * [문제별 학습 목표]
 * - 문제 1: JSON 기초 형태 — 이름/전화번호 JSON 문자열 작성
 */
public class Example1 {
    public static void main(String[] args) {
        System.out.println("=== Lab 1: JSON 기초 형태 ===");
        // 이름과 전화번호를 포함하는 JSON 형식 문자열
        String json1 = "{\n" +
                       "  \"name\": \"홍길동\",\n" +
                       "  \"phone\": \"010-1234-5678\"\n" +
                       "}";
        System.out.println(json1);
    }
}
