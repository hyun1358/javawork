package week12.day3;

/**
 * [예습 파일] Week 12 Day 3 — JSON 파싱
 * 
 * [핵심 개념: 기종 간 데이터 교환의 표준 포맷]
 * 1. JSON (JavaScript Object Notation):
 *    - 서로 다른 언어(예: Java 서버와 JavaScript 브라우저) 간에 복잡한 객체 데이터 정보를 텍스트 형태로 변환하여 호환성 있게 전송하기 위해 탄생한 표준 데이터 교환 포맷입니다.
 *    - 자바의 객체 필드를 JSON 문자열로 인코딩하는 것을 '직렬화/마샬링', 반대로 JSON 문자열을 분석해 자바 객체 필드에 채워넣는 것을 '역직렬화/언마샬링'이라 합니다.
 * 
 * 2. Gson / Jackson 라이브러리:
 *    - 실무에서는 매번 문자열을 수동 파싱하지 않고, 구글의 Gson이나 스프링 표준인 Jackson 라이브러리를 임포트하여 `toJson()` 및 `fromJson()` 단 한 줄로 객체와 JSON을 자동 맵핑합니다.
 */
public class Preview {
    public static void main(String[] args) {
        String json = "{\"name\": \"홍길동\", \"age\": 20}";
        System.out.println("받아온 JSON 원본: " + json);

        // 원시적인 파싱 (라이브러리 없이)
        String[] parts = json.replace("{", "").replace("}", "").replace("\"", "").split(",");
        for (String p : parts) {
            String[] kv = p.split(":");
            System.out.println(kv[0].trim() + " 값은 " + kv[1].trim());
        }
    }
}
