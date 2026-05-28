package week11.day3;

public class Answer2 {
    public static void main(String[] args) {
        String sql = new SqlBuilder().select("*").from("users").where("id=1").build();
        System.out.println(sql);
    }

    static class SqlBuilder {
        StringBuilder sb = new StringBuilder();

        public SqlBuilder select(String s) {
            sb.append("SELECT ").append(s).append(" ");
            return this;
        }

        public SqlBuilder from(String t) {
            sb.append("FROM ").append(t).append(" ");
            return this;
        }

        public SqlBuilder where(String c) {
            sb.append("WHERE ").append(c);
            return this;
        }

        public String build() {
            return sb.toString();
        }
    }
}
