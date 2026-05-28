package week05.day3;

/**
 * [학습 예제] Week 05 Day 3 — 접근 제어자와 캡슐화 (Dog getter/setter, Person 나이 유효성 검사, BankAccount 입출금 제어, Product 문자열 보호, 정보 은닉 가치)
 * 
 * [학습 핵심 이론: 객체의 자율성과 정보 은닉]
 * 1. 정보 은닉 (Information Hiding):
 *    - 외부에서 객체의 내부 핵심 데이터(필드)에 직접 마음대로 접근하여 예기치 않은 조작이나 무효한 상태값을 주입하는 것을 철저히 차단합니다.
 * 
 * 2. 접근 제어자 4단계 (Access Modifiers):
 *    - private: 동일 클래스 내부에서만 독점 사용 가능 (필드는 대부분 private 권장).
 *    - default (package-private): 동일 패키지 내부의 클래스끼리 접근 가능 (명시적 키워드 없음).
 *    - protected: 동일 패키지 + 타 패키지의 상속 관계인 자식 클래스까지 접근을 허용.
 *    - public: 제약 없이 패키지 외부를 통틀어 어디서든 접근 가능.
 * 
 * 3. 캡슐화 (Encapsulation)와 Getter/Setter:
 *    - 데이터를 private 필드로 감추고, 안전하고 검증된 통로인 public Getter(조회)와 Setter(값 입력 시 유효성 체크 적용) 메서드를 통해서만 제어할 수 있도록 캡슐화합니다.
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Week 05 Day 3 학습 예제 ===\n");

        System.out.println("--- Lab1: Dog 클래스의 getter / setter (Problem 1 연계) ---");
        Lab1.run();

        System.out.println("\n--- Lab2: Person 클래스의 setter 나이 유효성 검증 (Problem 2 연계) ---");
        Lab2.run();

        System.out.println("\n--- Lab3: BankAccount 클래스 입출금 비즈니스 로직 보호 (Problem 3 연계) ---");
        Lab3.run();

        System.out.println("\n--- Lab4: Product 클래스의 문자열 null/공백 유효성 검증 (Problem 4 연계) ---");
        Lab4.run();

        System.out.println("\n--- Lab5: 왜 public 대신 private 필드를 쓰는가? (Problem 5 연계) ---");
        Lab5.run();
    }

    // Problem 1: Dog 클래스 캡슐화
    static class Dog {
        private String name;

        // getter
        public String getDogName() {
            return this.name;
        }

        // setter
        public void setDogName(String name) {
            this.name = name;
        }
    }

    // Problem 2: Person 클래스 유효성 검증
    static class Person {
        private int age;

        public int getAge() {
            return this.age;
        }

        public void setAge(int age) {
            if (age < 0) {
                System.out.println("경고: 잘못된 입력 (나이는 음수가 될 수 없습니다.)");
            } else {
                this.age = age;
            }
        }
    }

    // Problem 3: BankAccount 클래스 안전 입출금
    static class BankAccount {
        private int balance = 0; // 잔액은 외부 직접 수정 금지 (private)

        public int getBalance() {
            return this.balance;
        }

        public void deposit(int money) {
            if (money <= 0) {
                System.out.println("입금 오류: 입금액은 0보다 커야 합니다.");
                return;
            }
            this.balance += money;
            System.out.println(money + "원 입금 완료. (현재 잔액: " + this.balance + "원)");
        }

        public void withdraw(int money) {
            if (money <= 0) {
                System.out.println("출금 오류: 출금액은 0보다 커야 합니다.");
            } else if (this.balance < money) {
                System.out.println("출금 오류: 출금 금액이 보유 잔액보다 많습니다. (잔액 부족)");
            } else {
                this.balance -= money;
                System.out.println(money + "원 출금 완료. (현재 잔액: " + this.balance + "원)");
            }
        }
    }

    // Problem 4: Product 클래스 문자열 검증
    static class Product {
        private String name;

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            // null 체크 및 빈 문자열 ""을 동시 체크하여 "이름 없음" 기본값 처리
            if (name == null || name.trim().isEmpty()) {
                this.name = "이름 없음";
            } else {
                this.name = name;
            }
        }
    }

    static class Lab1 {
        static void run() {
            Dog dog = new Dog();
            dog.setDogName("복돌이");
            System.out.println("강아지 이름: " + dog.getDogName());
        }
    }

    static class Lab2 {
        static void run() {
            Person person = new Person();
            person.setAge(15);
            System.out.println("나이 설정(15세): " + person.getAge());
            
            person.setAge(-23); // 음수 설정 시도 -> 경고 출력
            System.out.println("음수 설정 시도 후 나이: " + person.getAge() + " [값이 오염되지 않고 유지됨]");
        }
    }

    static class Lab3 {
        static void run() {
            BankAccount account = new BankAccount();
            account.deposit(10000);
            account.withdraw(150000); // 잔액 부족 에러 발생
            account.withdraw(4000);   // 정상 출금
            System.out.println("최종 계좌 잔액: " + account.getBalance());
        }
    }

    static class Lab4 {
        static void run() {
            Product prod = new Product();
            prod.setName("노트북");
            System.out.println("정상 제품명: " + prod.getName());

            prod.setName(""); // 빈 문자열 입력 시도
            System.out.println("빈 문자열 입력 시도 후 제품명: " + prod.getName() + " [이름 없음으로 자동 변환]");
        }
    }

    static class Lab5 {
        static void run() {
            System.out.println("[캡슐화의 핵심 가치 요약]");
            System.out.println("1. 필드를 public으로 개방하면 외부의 의도치 않은 임의 수정에 의해 데이터가 심각히 오염될 수 있습니다.");
            System.out.println("2. 필드를 private으로 선언하고 오직 검증(Validation)이 통과된 데이터만 setter/메서드를 통해 반영되도록 유도합니다.");
            System.out.println("3. 이를 통해 객체의 무결성(Integrity)이 확실히 보장되고 유지보수가 훨씬 용이해집니다.");
        }
    }
}
