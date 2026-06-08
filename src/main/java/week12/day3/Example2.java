package week12.day3;

/**
 * [학습 예제 2] Week 12 Day 3 — JSON 완전 정복 (외부 라이브러리 없이)
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 2] JSON 객체 구조
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *    - 문자열 값: 따옴표로 감쌈  → "name": "kim"
 *    - 숫자 값:  따옴표 없음     → "age": 25
 *    - 불리언 값: true / false  → "active": true
 *
 * [문제별 학습 목표]
 * - 문제 2: 객체 → JSON 변환 — User(id, name)를 JSON 문자열로 직접 만들기
 */
public class Example2 {
    public static void main(String[] args) {
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
    }

    // ─── UserData 클래스 ──────────────────────────────────
    static class UserData {
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
}
