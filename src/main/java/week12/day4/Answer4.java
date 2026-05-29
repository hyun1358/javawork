package week12.day4;

// JDBC의 ResultSet을 이용하여 조회된 데이터(행)를 반복해서 읽어오는 패턴 예제입니다.
public class Answer4 {
    // 메인 메서드
    public static void main(String[] args) {
        /*
         * [ResultSet 데이터 순회 방식]
         * 
         * rs.next()는 다음 행(Row)이 존재하면 커서를 이동시키고 true를 반환하며, 없으면 false를 반환합니다.
         * while (rs.next()) {
         *     // 현재 커서가 가리키는 행에서 열의 데이터 타입에 맞게 값을 읽어옵니다.
         *     int id = rs.getInt("id");          // "id" 컬럼의 값을 정수로 가져옴
         *     String name = rs.getString("name"); // "name" 컬럼의 값을 문자열로 가져옴
         * }
         */
    }
}
