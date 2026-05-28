package week05.day5;

/**
 * [학습 예제] Week 05 Day 5 — final 키워드와 불변 설계 (원주율 상수, 불변 객체 ImmutableBook, 설정 클래스 AppConfig, final 매개변수 제약, 종합 User 설계)
 * 
 * [학습 핵심 이론: final 제약 조건을 활용한 안전성 극대화]
 * 1. final 키워드의 용도:
 *    - 변수(필드, 지역 변수, 매개변수)에 사용되면 '초기화 이후 값 재할당(Reassignment) 금지'를 의미합니다. (상수화)
 * 
 * 2. static final (클래스 상수):
 *    - 클래스 차원에서 하나만 존재하고 절대 바뀌지 않는 공유 데이터입니다. 대문자와 언더바(`_`) 스네이크 케이스로 명명합니다. (Problem 1 연계)
 * 
 * 3. 인스턴스 final 필드 (객체 상수):
 *    - 각 인스턴스(객체)마다 서로 다른 상수 값을 가질 수 있으며, 반드시 생성자 실행 종료 시점까지 초기화가 완료되어야 합니다.
 * 
 * 4. 불변 객체 (Immutable Object):
 *    - 객체 생성 후 내부 상태가 절대 변하지 않는 객체입니다. 모든 필드를 `final`로 선언하고 setter를 제공하지 않아 동시성 환경에서 최고의 안전성을 가집니다. (Problem 2, 5 연계)
 * 
 * 5. final 매개변수:
 *    - 메서드 내부에서 인자로 넘어온 변수 값을 임의로 덮어씌워 유실하거나 오염시키는 실수를 컴파일 타임에 철저히 방지합니다. (Problem 4 연계)
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Week 05 Day 5 학습 예제 ===\n");

        System.out.println("--- Lab1: static final 상수를 활용한 원의 넓이 계산 (Problem 1 연계) ---");
        Lab1.run();

        System.out.println("\n--- Lab2: 불변 객체(Immutable Object) 클래스 설계 및 테스트 (Problem 2 연계) ---");
        Lab2.run();

        System.out.println("\n--- Lab3: 전역 설정을 상수로 모아 관리하는 AppConfig 클래스 (Problem 3 연계) ---");
        Lab3.run();

        System.out.println("\n--- Lab4: final 매개변수 재할당 제약 및 컴파일 에러 원인 (Problem 4 연계) ---");
        Lab4.run();

        System.out.println("\n--- Lab5: private + final + static을 총망라한 완벽한 User 클래스 설계 (Problem 5 연계) ---");
        Lab5.run();
    }

    // Problem 1: 원주율 상수
    public static final double PI = 3.141592653589793;

    // Problem 2: 불변 책 클래스
    static class ImmutableBook {
        private final String title; // 불변 인스턴스 필드
        private final String author;

        public ImmutableBook(String title, String author) {
            this.title = title;
            this.author = author;
        }

        public String getTitle() { return title; }
        public String getAuthor() { return author; }
        // setter는 작성하지 않음 -> 상태 변경 불가능(Immutable) 보장
    }

    // Problem 3: 설정 상수 클래스
    static class AppConfig {
        public static final int MAX_USERS = 1000;
        public static final String VERSION = "1.0.0";
        public static final String OS_ENV = "Linux";

        // 인스턴스화 방지를 위해 기본 생성자를 private으로 잠금
        private AppConfig() {
            throw new AssertionError("상수 전용 클래스이므로 객체를 생성할 수 없습니다.");
        }
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

        // final 필드는 오직 Getter만 제공
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

    static class Lab1 {
        static void run() {
            int radius = 5;
            double area = radius * radius * PI; // static final PI 활용
            System.out.printf("반지름 %d인 원의 넓이: %.2f\n", radius, area);
        }
    }

    static class Lab2 {
        static void run() {
            ImmutableBook book = new ImmutableBook("자바의 정석", "남궁성");
            System.out.println("생성 완료된 불변 도서 제목: " + book.getTitle());
            System.out.println("생성 완료된 불변 도서 저자: " + book.getAuthor());
            // book.title = "수정 시도"; // [컴파일 에러!] final 필드이므로 직접 변경 불가
        }
    }

    static class Lab3 {
        static void run() {
            System.out.println("AppConfig 최댓값 설정: " + AppConfig.MAX_USERS);
            System.out.println("AppConfig 버전 정보: " + AppConfig.VERSION);
            // AppConfig config = new AppConfig(); // [컴파일 에러!] private 생성자이므로 인스턴스화 완전 차단
        }
    }

    static class Lab4 {
        static void run() {
            System.out.println("[매개변수 final 제약 설명]");
            printAge(25);
        }

        static void printAge(final int age) {
            // age = 30; // [컴파일 에러!] final 매개변수 age는 메서드 바디 내부에서 다시 대입(Reassign)될 수 없습니다.
            System.out.println("전달받은 안전한 나이 값: " + age);
        }
    }

    static class Lab5 {
        static void run() {
            User user = new User("user_777", "홍길동", 20, "hong@example.com");
            user.showUserInfo();

            // ID는 변경 불가, 이름은 개명 가능
            user.setName("홍길동2");
            // user.id = "user_999"; // [컴파일 에러!] final 필드 id는 재할당 불가
            System.out.println("이름 변경 완료 후 ID 검증: " + user.getId() + " (이름: " + user.getName() + ")");
        }
    }
}
