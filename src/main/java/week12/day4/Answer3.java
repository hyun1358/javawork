package week12.day4;

// SQL Injection(SQL 삽입 공격)을 방지하기 위한 PreparedStatement의 필요성을 설명하는 예제입니다.
public class Answer3 {
    // 메인 메서드
    public static void main(String[] args) {
        /*
         * [SQL Injection 방어를 위한 PreparedStatement 사용]
         * 
         * Statement를 사용하여 문자열 더하기로 SQL을 조립하면 악의적인 특수문자 입력에 취약합니다.
         * PreparedStatement를 사용해야 합니다.
         * 외부에서 입력받는 파라미터를 '?' 로 처리하여 동적으로 바인딩하면,
         * 어떤 특수문자가 들어와도 SQL 구문이 아닌 단순 문자열(데이터)로 취급하게 만듭니다.
         */
    }
}
