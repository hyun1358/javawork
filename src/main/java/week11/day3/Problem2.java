package week11.day3;

/**
 * [연습 문제 2] SQL 쿼리 빌더
 * 문제: "SELECT", "FROM", "WHERE"를 조합하여 쿼리 문자열을 생성하는 SqlBuilder를 만드세요.
 */
public class Problem2 {
    public static void main(String[] args)
    {
        // TODO
        String sql = new SqlBuilder()
                .select("id, age, email")
                .from("user")
                .where("age > 20")
                .build();
        System.out.println(sql);
    }

    static class SqlBuilder
    {
        private StringBuilder sb = new StringBuilder();

        public SqlBuilder select(String cols) {  sb.append("select ").append(cols).append(" "); return this; }
        public SqlBuilder from(String table) {  sb.append("from ").append(table).append(" "); return this; }
        public SqlBuilder where(String cond) {  sb.append("where ").append(cond).append(" "); return this; }

        public String build() { return sb.toString().trim(); }
    }
}
