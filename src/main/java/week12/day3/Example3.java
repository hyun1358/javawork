package week12.day3;

/**
 * [학습 예제 3] Week 12 Day 3 — JSON 완전 정복 (외부 라이브러리 없이)
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 3] JSON 배열
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  배열: [ { ... }, { ... } ]
 *    - 여러 객체를 대괄호로 감쌈
 *
 * [문제별 학습 목표]
 * - 문제 3: JSON 배열 형태 — 두 명의 User가 있는 JSON 배열
 */
public class Example3 {
    public static void main(String[] args) {
        System.out.println("\n=== Lab 3: JSON 배열 형태 ===");
        // 두 명의 User 객체를 JSON 배열로 표현
        UserData u1 = new UserData(1, "kim", "kim@test.com", 25);
        UserData u2 = new UserData(2, "lee", "lee@test.com", 30);

        String jsonArray = String.format("[%s, %s]", u1.toJson(), u2.toJson());
        System.out.println("JSON 배열:\n" + jsonArray);
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

        public String toJson() {
            return String.format("{\"id\": %d, \"name\": \"%s\", \"email\": \"%s\", \"age\": %d}",
                    id, name, email, age);
        }
    }
}
