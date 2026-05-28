package week12.day3;

/**
 * [학습 예제] Week 12 Day 3 — JSON 완전 정복 (외부 라이브러리 없이)
 *
 * ★ 이 파일은 오늘 풀어야 할 연습 문제 5개의 핵심 기술을 모두 담고 있습니다.
 *
 * [문제별 학습 목표]
 * - 문제 1: JSON 기초 형태 — 이름/전화번호 JSON 문자열 작성
 * - 문제 2: 객체 → JSON 변환 — User(id, name)를 JSON 문자열로 직접 만들기
 * - 문제 3: JSON 배열 형태 — 두 명의 User가 있는 JSON 배열
 * - 문제 4: JSON 파싱 — "{\"id\":5}" 에서 숫자 5 뽑아내기
 * - 문제 5: Gson / Jackson 설명 — 역할과 차이점 주석 정리
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 1 & 2 & 3] JSON 형식
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  JSON(JavaScript Object Notation): 키-값 쌍의 경량 데이터 교환 형식
 *
 *  객체: { "key": value, "key2": value2 }
 *    - 문자열 값: 따옴표로 감쌈  → "name": "kim"
 *    - 숫자 값:  따옴표 없음     → "age": 25
 *    - 불리언 값: true / false  → "active": true
 *
 *  배열: [ { ... }, { ... } ]
 *    - 여러 객체를 대괄호로 감쌈
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 4] 수동 JSON 파싱 (외부 라이브러리 없이)
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - indexOf(), substring() 으로 문자열에서 값 추출
 *  - 한계: 중첩 구조 파싱 어려움 → 실무에서는 Gson/Jackson 사용
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 5] Gson vs Jackson
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  Gson (Google):
 *    - new Gson().toJson(object): 객체 → JSON 문자열
 *    - new Gson().fromJson(json, Class): JSON → 객체
 *    - 간편하고 의존성 없음 (경량)
 *
 *  Jackson (FasterXML):
 *    - ObjectMapper().writeValueAsString(object): 객체 → JSON
 *    - ObjectMapper().readValue(json, Class): JSON → 객체
 *    - Spring Boot 기본 내장 라이브러리 (실무 표준)
 */
public class Example {
    public static void main(String[] args) {

        // ─────────────────────────────────────────────
        // Lab 1: JSON 기초 형태 (→ 문제 1 참고)
        // ─────────────────────────────────────────────
        System.out.println("=== Lab 1: JSON 기초 형태 ===");
        // 이름과 전화번호를 포함하는 JSON 형식 문자열
        String json1 = "{\n" +
                       "  \"name\": \"홍길동\",\n" +
                       "  \"phone\": \"010-1234-5678\"\n" +
                       "}";
        System.out.println(json1);

        // ─────────────────────────────────────────────
        // Lab 2: 객체 → JSON 문자열 변환 (→ 문제 2 참고)
        // ─────────────────────────────────────────────
        System.out.println("\n=== Lab 2: 객체 → JSON 문자열 ===");
        // User 객체의 데이터를 JSON 형식 문자열로 직접 조립
        int userId = 1;
        String userName = "kim";
        String userJson = String.format(
                "{\"id\": %d, \"name\": \"%s\"}", userId, userName);
        System.out.println("User JSON: " + userJson);

        // 여러 필드가 있는 복잡한 예시
        UserData user = new UserData(2, "lee", "lee@test.com", 28);
        System.out.println("UserData JSON: " + user.toJson());

        // ─────────────────────────────────────────────
        // Lab 3: JSON 배열 형태 (→ 문제 3 참고)
        // ─────────────────────────────────────────────
        System.out.println("\n=== Lab 3: JSON 배열 형태 ===");
        // 두 명의 User 객체를 JSON 배열로 표현
        UserData u1 = new UserData(1, "kim", "kim@test.com", 25);
        UserData u2 = new UserData(2, "lee", "lee@test.com", 30);

        String jsonArray = String.format("[%s, %s]", u1.toJson(), u2.toJson());
        System.out.println("JSON 배열:\n" + jsonArray);

        // ─────────────────────────────────────────────
        // Lab 4: JSON 파싱 — 값 추출 (→ 문제 4 참고)
        // ─────────────────────────────────────────────
        System.out.println("\n=== Lab 4: JSON 파싱 (값 추출) ===");

        // 1. 단순 방법: indexOf + substring 으로 값 추출
        String raw = "{\"id\":5}";
        int colonIdx = raw.indexOf(":");
        int endIdx   = raw.indexOf("}");
        String extracted = raw.substring(colonIdx + 1, endIdx).trim();
        int idValue = Integer.parseInt(extracted);
        System.out.println("파싱된 id 값: " + idValue + " (타입: " + ((Object)idValue).getClass().getSimpleName() + ")");

        // 2. 좀 더 복잡한 파싱 예시: 문자열 값 추출
        String json4 = "{\"name\":\"Alice\",\"age\":22}";
        int nameStart = json4.indexOf("\"name\"");
        int colonPos  = json4.indexOf(":", nameStart);
        int firstQuote = json4.indexOf("\"", colonPos) + 1;
        int lastQuote  = json4.indexOf("\"", firstQuote);
        String name = json4.substring(firstQuote, lastQuote);
        System.out.println("파싱된 name: " + name);

        System.out.println("※ 복잡한 JSON은 Gson/Jackson 라이브러리 사용 권장 (→ 문제 5 참고)");

        // ─────────────────────────────────────────────
        // Lab 5: Gson / Jackson 설명 (→ 문제 5 참고)
        // ─────────────────────────────────────────────
        System.out.println("\n=== Lab 5: Gson / Jackson 라이브러리 ===");
        /*
         * [Gson — Google 제공]
         *  - 의존성 추가: implementation 'com.google.code.gson:gson:2.10.1'
         *  - 직렬화(객체 → JSON):
         *    Gson gson = new Gson();
         *    String json = gson.toJson(userObject);
         *    // 결과: {"id":1,"name":"kim"}
         *
         *  - 역직렬화(JSON → 객체):
         *    User user = gson.fromJson(jsonStr, User.class);
         *
         * [Jackson — FasterXML 제공, Spring Boot 기본 탑재]
         *  - 의존성 추가: implementation 'com.fasterxml.jackson.core:jackson-databind:2.15'
         *  - 직렬화(객체 → JSON):
         *    ObjectMapper mapper = new ObjectMapper();
         *    String json = mapper.writeValueAsString(userObject);
         *
         *  - 역직렬화(JSON → 객체):
         *    User user = mapper.readValue(jsonStr, User.class);
         *
         * [비교]
         *  Gson:    간단, 외부 의존성 적음, 소규모 프로젝트에 적합
         *  Jackson: 빠름, 커스텀 설정 풍부, Spring 생태계 표준
         */
        System.out.println("Gson:    new Gson().toJson(obj)  /  gson.fromJson(json, Class)");
        System.out.println("Jackson: mapper.writeValueAsString(obj)  /  mapper.readValue(json, Class)");
        System.out.println("Spring Boot는 Jackson을 기본 내장하여 자동으로 JSON 변환에 사용함");
    }
}

// ─── UserData 클래스 ──────────────────────────────────
class UserData {
    int id;
    String name;
    String email;
    int age;

    UserData(int id, String name, String email, int age) {
        this.id    = id;
        this.name  = name;
        this.email = email;
        this.age   = age;
    }

    // 객체를 JSON 문자열로 직접 변환 (라이브러리 없이)
    public String toJson() {
        return String.format("{\"id\": %d, \"name\": \"%s\", \"email\": \"%s\", \"age\": %d}",
                id, name, email, age);
    }
}
