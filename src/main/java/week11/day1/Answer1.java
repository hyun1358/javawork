package week11.day1;

public class Answer1 {
    // 메인 메서드: 프로그램 실행의 진입점입니다.
    public static void main(String[] args) {
        // 동일한 싱글톤 인스턴스를 두 번 호출합니다.
        DBConnection db1 = DBConnection.getInstance();
        DBConnection db2 = DBConnection.getInstance();
        // 동일한 인스턴스인지(메모리 주소가 같은지)를 비교하여 출력합니다. (true 반환 예상)
        System.out.println(db1 == db2);
    }

    // Eager Initialization 방식의 싱글톤 패턴 클래스
    static class DBConnection {
        // 클래스가 메모리에 로드될 때 미리 단 하나의 인스턴스를 생성해 둡니다.
        private static final DBConnection instance = new DBConnection();
        // 외부에서 객체를 임의로 생성할 수 없도록 생성자를 private으로 선언합니다.
        private DBConnection() {}
        // 외부에서 단일 인스턴스에 접근할 수 있도록 해주는 정적 메서드입니다.
        public static DBConnection getInstance() {
            return instance;
        }
    }
}
