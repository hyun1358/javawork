package week11.day1;

/**
 * [학습 예제 3] Week 11 Day 1 — 싱글톤 패턴 & 팩토리 패턴 완전 정복
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 3] Enum 싱글톤 (가장 안전)
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - Enum 상수는 JVM이 하나만 생성하는 것을 보장
 *  - 직렬화, 리플렉션 공격에도 안전
 *  - Joshua Bloch가 권장하는 최선의 싱글톤 방법
 *
 * [문제별 학습 목표]
 * - 문제 3: Enum 싱글톤 — 가장 안전한 싱글톤 구현 방법
 */
public class Example3 {
    public static void main(String[] args) {
        // ─────────────────────────────────────────────
        // Lab 3: Enum 싱글톤 (→ 문제 3 참고)
        // ─────────────────────────────────────────────
        System.out.println("\n=== Lab 3: Enum 싱글톤 (Configuration) ===");
        Configuration cfg1 = Configuration.INSTANCE;
        Configuration cfg2 = Configuration.INSTANCE;
        System.out.println("cfg1 == cfg2 ? " + (cfg1 == cfg2)); // true (JVM 보장)
        cfg1.printVersion();
    }

    // ─── Lab 3: Enum 싱글톤 ───────────────────────────────
    enum Configuration {
        INSTANCE; // JVM이 이 상수를 딱 하나만 생성함을 보장

        private final String version = "v1.0.0";

        public void printVersion() {
            System.out.println("앱 버전: " + version);
        }
    }
}
