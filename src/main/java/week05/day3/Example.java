package week05.day3;

/**
 * [학습 예제] Week 05 Day 3 — 접근 제어자와 캡슐화
 * Lab1~Lab5를 순서대로 실행하며 각 개념을 익히세요.
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Week 05 Day 3 학습 예제 ===\n");

        System.out.println("--- Lab1: public vs private ---");
        Lab1.run();
        System.out.println("\n[해설] public은 어디서나, private은 해당 클래스 내부에서만 접근 가능합니다.\n");

        System.out.println("--- Lab2: Getter와 Setter ---");
        Lab2.run();
        System.out.println("\n[해설] private 필드에 접근하기 위해 public 메서드를 통로로 사용합니다.\n");

        System.out.println("--- Lab3: 캡슐화의 필요성 ---");
        Lab3.run();
        System.out.println("\n[해설] 필드를 직접 노출하면 의도치 않게 값이 오염될 수 있습니다.\n");

        System.out.println("--- Lab4: Setter에서 유효성 검사 ---");
        Lab4.run();
        System.out.println("\n[해설] 메서드 내부에서 조건문을 사용해 잘못된 데이터 입력을 차단합니다.\n");

        System.out.println("--- Lab5: 기타 접근 제어자 ---");
        Lab5.run();
        System.out.println("\n[해설] protected는 상속 관계, default는 같은 패키지 내에서만 접근을 허용합니다.\n");
    }

    static class Data {
        public String publicData = "누구나 봐요";
        private String privateData = "나만 봐요";

        private int age;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            if (age < 0) {
                System.out.println("나이는 음수가 될 수 없습니다.");
            } else {
                this.age = age;
            }
        }
    }

    static class Lab1 {
        static void run() {
            Data d = new Data();
            System.out.println("Public 데이터 접근: " + d.publicData);
            // System.out.println(d.privateData); // 컴파일 에러!
        }
    }

    static class Lab2 {
        static void run() {
            Data d = new Data();
            d.setAge(20);
            System.out.println("Getter로 읽은 나이: " + d.getAge());
        }
    }

    static class Lab3 {
        static void run() {
            System.out.println("데이터를 캡슐화(감싸기)하여 외부의 직접적인 간섭으로부터 보호합니다.");
        }
    }

    static class Lab4 {
        static void run() {
            Data d = new Data();
            d.setAge(-5); // 잘못된 값 입력 시도
            System.out.println("현재 저장된 나이: " + d.getAge());
        }
    }

    static class Lab5 {
        static void run() {
            System.out.println("접근 범위: public > protected > default > private 순입니다.");
        }
    }
}
