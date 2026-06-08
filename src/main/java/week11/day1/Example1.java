package week11.day1;

/**
 * [학습 예제 1] Week 11 Day 1 — 싱글톤 패턴 & 팩토리 패턴 완전 정복
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 1] Eager(이른) 초기화 싱글톤
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - 클래스 로딩 시점에 인스턴스를 미리 만들어두는 방식
 *  - private static final 인스턴스 → 외부에서 new 불가
 *  - private 생성자 → 외부에서 new DBConnection() 불가
 *  - public static getInstance() → 외부가 접근하는 유일한 통로
 *
 * [문제별 학습 목표]
 * - 문제 1: 기본 Eager 싱글톤 — DBConnection 클래스, 두 참조가 같은지 확인
 */
public class Example1 {
    public static void main(String[] args) {
        // ─────────────────────────────────────────────
        // Lab 1: Eager 싱글톤 — DBConnection (→ 문제 1 참고)
        // ─────────────────────────────────────────────
        System.out.println("=== Lab 1: Eager 싱글톤 (DBConnection) ===");
        DBConnection db1 = DBConnection.getInstance();
        DBConnection db2 = DBConnection.getInstance();
        System.out.println("db1 == db2 ? " + (db1 == db2)); // 반드시 true
        db1.connect();
    }

    // ─── Lab 1: Eager 싱글톤 ───────────────────────────────
    static class DBConnection {
        // 클래스 로딩 시 즉시 생성 (Eager)
        private static final DBConnection instance = new DBConnection();

        // private 생성자 → 외부에서 new 불가
        private DBConnection() {}

        // 외부가 접근하는 유일한 통로
        public static DBConnection getInstance() {
            return instance;
        }

        public void connect() {
            System.out.println("DB 연결 완료 (객체 하나를 공유 중)");
        }
    }
}
