package week12.day4;

// 기본적인 SQL SELECT 쿼리 문자열을 정의하는 예제입니다.
public class Answer2 {
    // 메인 메서드
    public static void main(String[] args) {
        // 데이터베이스의 'users' 테이블에서 모든 열(*)의 데이터를 조회하는 SQL 쿼리문입니다.
        String sql = "SELECT * FROM users";
        // 실행할 쿼리문을 콘솔에 출력합니다.
        System.out.println("실행할 쿼리: " + sql);
    }
}
