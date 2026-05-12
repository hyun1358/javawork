package week05.day5;

/**
 * [연습 문제 5] 종합 리팩토링
 * 문제: 지금까지 배운 private, final, static을 모두 활용하여
 * 가장 완벽한 형태의 User 클래스를 설계해보세요.
 */
public class Problem5 {
    public static void main(String[] args) {
        // TODO: 필드 보호, 상수 활용, 생성자 초기화 적용

        User user = new User("1234", "홍길동", 19, "asbc@naver.com");
        user.GetUserInfo();
    }

    static class User {
        private final String id;
        private String name;
        private int age;
        private String email;

        public User(String id, String name, int age, String email) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.email = email;
        }

        void GetUserInfo() {
            System.out.printf("id : %s, 이름 : %s, 나이: %d, 이메일 : %s", id, name, age, email);
        }

    }
}
