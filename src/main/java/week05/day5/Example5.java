package week05.day5;

/**
 * [학습 예제 5] Week 05 Day 5 — final 키워드와 불변 설계
 * 
 * [문제별 학습 목표]
 * - Lab5: private + final + static을 총망라한 완벽한 User 클래스 설계 (Problem 5 연계)
 */
public class Example5 {
    public static void main(String[] args) {
        User user = new User("user_777", "홍길동", 20, "hong@example.com");
        user.showUserInfo();

        // ID는 변경 불가, 이름은 개명 가능
        user.setName("홍길동2");
        System.out.println("이름 변경 완료 후 ID 검증: " + user.getId() + " (이름: " + user.getName() + ")");
    }

    // Problem 5: static + private + final 설계의 완성형 User 클래스
    static class User {
        public static final String COMPANY_NAME = "Antigravity Inc."; // 모든 유저가 속한 공유 상수
        
        private final String id; // 객체 생성 시 부여되면 절대 바꿀 수 없는 회원 고유 ID
        private String name;     // 개명 가능하므로 final 미적용
        private int age;
        private String email;

        public User(String id, String name, int age, String email) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.email = email;
        }

        public String getId() { return id; }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public int getAge() { return age; }
        public void setAge(int age) { this.age = age; }
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }

        public void showUserInfo() {
            System.out.println("[" + COMPANY_NAME + " 회원 정보]");
            System.out.printf("ID: %s | 이름: %s | 나이: %d | 이메일: %s\n", id, name, age, email);
        }
    }
}
