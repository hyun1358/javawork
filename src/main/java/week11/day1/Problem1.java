package week11.day1;

/**
 * [연습 문제 1] 싱글톤 구현
 * 문제: DBConnection 이라는 클래스를 싱글톤으로 구현하세요.
 */
public class Problem1 {
    public static void main(String[] args)
    {
        // TODO: 객체를 두 번 받아와 같은지 비교하세요.
        DBConnection db1 = DBConnection.Instance;
        DBConnection db2 = DBConnection.Instance;
        System.out.println(db1==db2);
    }

    static class DBConnection
    {
        private static final DBConnection Instance = new DBConnection();;

        private DBConnection() {
            System.out.println("최조 1번 실행됨");
        };

        public DBConnection dbIntance() {
            return Instance;
        }
    }
}
