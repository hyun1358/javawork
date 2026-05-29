package week12.day4;

// JDBC 자원(Connection, PreparedStatement, ResultSet)을 안전하게 해제하기 위한 try-with-resources 구문 예제입니다.
public class Answer5 {
    // 메인 메서드
    public static void main(String[] args) {
        /*
         * [JDBC 자원 해제 가이드]
         * 
         * try (Connection conn = ...; PreparedStatement pstmt = ...; ResultSet rs = ...) {
         *     // DB 조회 및 처리 로직
         * }
         * 이처럼 try-with-resources 구문을 사용하면, 블록이 정상적으로 끝나든 예외가 발생하든 상관없이
         * 선언된 순서의 역순(rs -> pstmt -> conn)으로 안전하게 자동 종료(close)됩니다.
         * 자원 누수(Resource Leak)를 방지하는 가장 좋은 패턴입니다.
         */
    }
}
