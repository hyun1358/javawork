package week11.day1;

/**
 * [학습 예제 5] Week 11 Day 1 — 싱글톤 패턴 & 팩토리 패턴 완전 정복
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 5] 정적 팩토리 메서드 (Static Factory Method)
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - new User("admin", "1234") 대신 User.createAdmin("1234") 처럼
 *    목적을 이름으로 표현하는 메서드로 객체를 생성
 *  - 장점: 이름으로 의미 전달, 캐싱/조건부 생성 가능
 *
 * [문제별 학습 목표]
 * - 문제 5: 정적 팩토리 메서드 — User.createAdmin("1234") 방식 설계
 */
public class Example5 {
    public static void main(String[] args) {
        // ─────────────────────────────────────────────
        // Lab 5: 정적 팩토리 메서드 (→ 문제 5 참고)
        // ─────────────────────────────────────────────
        System.out.println("\n=== Lab 5: 정적 팩토리 메서드 (User) ===");
        // new User("admin", "1234") 대신 목적이 명확한 메서드명으로 생성
        ExUser admin = ExUser.createAdmin("admin123");
        ExUser guest = ExUser.createGuest();

        System.out.println("admin: " + admin.role + " / " + admin.name);
        System.out.println("guest: " + guest.role + " / " + guest.name);
    }

    // ─── Lab 5: 정적 팩토리 메서드 ───────────────────────
    static class ExUser {
        String name;
        String role;

        // private 생성자 → 직접 new 불가
        private ExUser(String name, String role) {
            this.name = name;
            this.role = role;
        }

        // 목적이 명확한 정적 팩토리 메서드들
        public static ExUser createAdmin(String name) {
            return new ExUser(name, "ADMIN");
        }

        public static ExUser createGuest() {
            return new ExUser("guest", "GUEST");
        }
    }
}
