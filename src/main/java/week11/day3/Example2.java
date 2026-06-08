package week11.day3;

/**
 * [학습 예제 2] Week 11 Day 3 — 빌더/데코레이터/커맨드 패턴 완전 정복
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 2] 빌더 패턴 (Builder Pattern)
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - 생성자 인자가 많을 때, 메서드 체이닝으로 가독성 좋게 객체를 조립
 *
 * [문제별 학습 목표]
 * - 문제 2: 빌더 패턴 — SqlBuilder (SELECT / FROM / WHERE)
 */
public class Example2 {
    public static void main(String[] args) {
        // ─────────────────────────────────────────────
        // Lab 2: 빌더 패턴 — SqlBuilder (→ 문제 2 참고)
        // ─────────────────────────────────────────────
        System.out.println("\n=== Lab 2: 빌더 패턴 — SqlBuilder ===");
        String query1 = new SqlBuilder()
                .select("id, name, email")
                .from("users")
                .where("age > 20")
                .build();
        System.out.println("SQL: " + query1);

        String query2 = new SqlBuilder()
                .select("*")
                .from("orders")
                .build(); // WHERE 없이도 가능
        System.out.println("SQL: " + query2);
    }

    // ─── 빌더 패턴: SqlBuilder ────────────────────────────
    static class SqlBuilder {
        private StringBuilder sb = new StringBuilder();

        public SqlBuilder select(String cols)  { sb.append("SELECT ").append(cols).append(" "); return this; }
        public SqlBuilder from(String table)   { sb.append("FROM ").append(table).append(" ");  return this; }
        public SqlBuilder where(String cond)   { sb.append("WHERE ").append(cond).append(" ");  return this; }

        public String build() { return sb.toString().trim(); }
    }
}
