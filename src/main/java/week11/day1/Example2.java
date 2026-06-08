package week11.day1;

/**
 * [학습 예제 2] Week 11 Day 1 — 싱글톤 패턴 & 팩토리 패턴 완전 정복
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 2] Lazy(게으른) 초기화 싱글톤
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - getInstance()가 처음 호출될 때만 객체를 만드는 방식
 *  - 멀티스레드 환경에서 안전하려면 synchronized 필요
 *  - 장점: 처음부터 메모리를 차지하지 않음 (필요할 때만 생성)
 *
 * [문제별 학습 목표]
 * - 문제 2: Lazy Initialization 싱글톤 — getInstance() 첫 호출 시 객체 생성
 */
public class Example2 {
    public static void main(String[] args) {
        // ─────────────────────────────────────────────
        // Lab 2: Lazy 싱글톤 (→ 문제 2 참고)
        // ─────────────────────────────────────────────
        System.out.println("\n=== Lab 2: Lazy 싱글톤 ===");
        LazySingleton lazy1 = LazySingleton.getInstance();
        LazySingleton lazy2 = LazySingleton.getInstance();
        System.out.println("lazy1 == lazy2 ? " + (lazy1 == lazy2)); // true
        System.out.println("처음 호출 시에만 '인스턴스 생성' 메시지가 출력됐어야 함");
    }

    // ─── Lab 2: Lazy 싱글톤 ───────────────────────────────
    static class LazySingleton {
        private static LazySingleton instance; // 처음엔 null

        private LazySingleton() {
            System.out.println("LazySingleton 인스턴스 생성 (최초 1회)");
        }

        // synchronized: 멀티스레드 환경에서 동시 생성 방지
        public static synchronized LazySingleton getInstance() {
            if (instance == null) {
                instance = new LazySingleton();
            }
            return instance;
        }
    }
}
