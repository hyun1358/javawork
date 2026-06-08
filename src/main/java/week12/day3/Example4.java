package week12.day3;

/**
 * [학습 예제 4] Week 12 Day 3 — JSON 완전 정복 (외부 라이브러리 없이)
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 4] 수동 JSON 파싱 (외부 라이브러리 없이)
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - indexOf(), substring() 으로 문자열에서 값 추출
 *  - 한계: 중첩 구조 파싱 어려움 → 실무에서는 Gson/Jackson 사용
 *
 * [문제별 학습 목표]
 * - 문제 4: JSON 파싱 — "{\"id\":5}" 에서 숫자 5 뽑아내기
 */
public class Example4 {
    public static void main(String[] args) {
        System.out.println("\n=== Lab 4: JSON 파싱 (값 추출) ===");

        // 1. 단순 방법: indexOf + substring 으로 값 추출
        String raw = "{\"id\":5}";
        int colonIdx = raw.indexOf(":");
        int endIdx   = raw.indexOf("}");
        String extracted = raw.substring(colonIdx + 1, endIdx).trim();
        int idValue = Integer.parseInt(extracted);
        System.out.println("파싱된 id 값: " + idValue);

        // 2. 좀 더 복잡한 파싱 예시: 문자열 값 추출
        String json4 = "{\"name\":\"Alice\",\"age\":22}";
        int nameStart = json4.indexOf("\"name\"");
        int colonPos  = json4.indexOf(":", nameStart);
        int firstQuote = json4.indexOf("\"", colonPos) + 1;
        int lastQuote  = json4.indexOf("\"", firstQuote);
        String name = json4.substring(firstQuote, lastQuote);
        System.out.println("파싱된 name: " + name);
    }
}
