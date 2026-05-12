package week04.day1;

/**
 * [학습 예제] Week 04 Day 1 — 메서드 기초
 * Lab1~Lab5를 통해 메서드의 선언과 호출을 익힙니다.
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Week 04 Day 1 학습 예제 ===\n");

        System.out.println("--- Lab1: 기본 메서드 선언과 호출 ---");
        Lab1.run();
        System.out.println("\n[해설] 메서드는 '반환타입 메서드명(매개변수) { 코드 }' 형식으로 선언합니다.\n");

        System.out.println("--- Lab2: 매개변수 활용 ---");
        Lab2.run();
        System.out.println("\n[해설] 매개변수를 통해 메서드 외부의 데이터를 메서드 내부로 전달할 수 있습니다.\n");

        System.out.println("--- Lab3: 반환값(return) 이해 ---");
        Lab3.run();
        System.out.println("\n[해설] return 키워드는 결과를 반환하고 메서드 실행을 종료합니다.\n");

        System.out.println("--- Lab4: 메서드 중첩 호출 ---");
        Lab4.run();
        System.out.println("\n[해설] 한 메서드 내에서 다른 메서드를 호출하여 기능을 조합할 수 있습니다.\n");

        System.out.println("--- Lab5: 메서드와 지역 변수 ---");
        Lab5.run();
        System.out.println("\n[해설] 메서드 내부에서 선언된 변수는 해당 메서드 내에서만 유효합니다.\n");
    }

    static class Lab1 {
        static void run() {
            printMessage(); // 메서드 호출
        }

        static void printMessage() {
            System.out.println("메서드가 실행되었습니다!");
        }
    }

    static class Lab2 {
        static void run() {
            showInfo("홍길동", 20);
        }

        static void showInfo(String name, int age) {
            System.out.println("이름: " + name + ", 나이: " + age);
        }
    }

    static class Lab3 {
        static void run() {
            int result = square(5);
            System.out.println("5의 제곱: " + result);
        }

        static int square(int n) {
            return n * n;
        }
    }

    static class Lab4 {
        static void run() {
            double circleArea = calculateCircleArea(5);
            System.out.println("반지름 5인 원의 넓이: " + circleArea);
        }

        static double calculateCircleArea(int r) {
            return 3.14 * square(r); // 다른 메서드 호출 활용
        }

        static int square(int n) {
            return n * n;
        }
    }

    static class Lab5 {
        static void run() {
            int x = 10;
            updateValue(x);
            System.out.println("main의 x 값: " + x); // x는 여전히 10
        }

        static void updateValue(int x) {
            x = 20; // 이 x는 지역 변수이므로 main의 x에 영향을 주지 않음
            System.out.println("메서드 내의 x 값: " + x);
        }
    }
}
