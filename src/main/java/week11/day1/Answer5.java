package week11.day1;

// 정적 팩토리 메서드(Static Factory Method) 패턴을 설명하는 예제입니다.
public class Answer5 {
    // 메인 메서드
    public static void main(String[] args) {
        // 생성자 대신 의미가 명확한 이름의 정적 팩토리 메서드를 호출하여 관리자 계정을 생성합니다.
        User admin = User.createAdmin("admin1234");
        // 생성된 관리자 객체의 역할(Role)을 출력합니다.
        System.out.println(admin.getRole());
    }

    // 사용자 정보를 관리하는 엔티티 클래스
    static class User {
        private String id;
        private String pw;
        private String role; // 사용자의 권한

        // 외부에서 기본 생성자를 통한 임의 객체 생성을 막기 위해 private으로 선언합니다.
        private User(String id, String pw, String role) {
            this.id = id;
            this.pw = pw;
            this.role = role;
        }

        // 특정 목적(관리자 생성)을 위해 의미있는 이름을 가진 정적 팩토리 메서드입니다.
        // id는 "admin", role은 "ADMIN_ROLE"로 고정하고 비밀번호만 매개변수로 받습니다.
        public static User createAdmin(String pw) {
            return new User("admin", pw, "ADMIN_ROLE");
        }

        // 사용자의 역할을 반환하는 Getter 메서드
        public String getRole() {
            return role;
        }
    }
}
