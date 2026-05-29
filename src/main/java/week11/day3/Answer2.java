package week11.day3;

// 빌더 패턴의 원리를 응용하여 SQL 쿼리 문자열을 동적으로 생성하는 예제입니다.
public class Answer2 {
    // 메인 메서드
    public static void main(String[] args) {
        // SqlBuilder를 사용하여 SELECT, FROM, WHERE 절을 메서드 체이닝으로 연결하여 SQL 문을 만듭니다.
        String sql = new SqlBuilder().select("*").from("users").where("id=1").build();
        // 완성된 SQL 문을 출력합니다.
        System.out.println(sql);
    }

    // SQL 쿼리를 조립하는 빌더 클래스
    static class SqlBuilder {
        StringBuilder sb = new StringBuilder(); // 문자열 조합을 효율적으로 하기 위해 StringBuilder를 사용합니다.

        // SELECT 절을 추가하는 메서드
        public SqlBuilder select(String s) {
            sb.append("SELECT ").append(s).append(" ");
            return this; // 연속적인 호출을 위해 자기 자신을 반환합니다.
        }

        // FROM 절을 추가하는 메서드
        public SqlBuilder from(String t) {
            sb.append("FROM ").append(t).append(" ");
            return this;
        }

        // WHERE 절을 추가하는 메서드
        public SqlBuilder where(String c) {
            sb.append("WHERE ").append(c);
            return this;
        }

        // 최종적으로 완성된 SQL 문자열을 반환하는 메서드
        public String build() {
            return sb.toString();
        }
    }
}
