package week02.day2;

/**
 * [학습 예제] Week 02 Day 2 — switch 문
 * Lab1~Lab5를 순서대로 실행하며 각 개념을 익히세요.
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Week 02 Day 2 학습 예제 ===\n");

        System.out.println("--- Lab1: 기본 switch-case-break ---");
        Lab1.run();
        System.out.println("\n[해설] switch 문은 변수의 값과 일치하는 case를 찾아 실행합니다. break가 필수입니다.\n");

        System.out.println("--- Lab2: default 처리 ---");
        Lab2.run();
        System.out.println("\n[해설] default는 어떤 case에도 해당하지 않을 때 실행됩니다. (if의 else 역할)\n");

        System.out.println("--- Lab3: break 생략(Fall-through) ---");
        Lab3.run();
        System.out.println("\n[해설] break를 생략하면 다음 case가 조건에 상관없이 계속 실행됩니다.\n");

        System.out.println("--- Lab4: 여러 case 묶기 ---");
        Lab4.run();
        System.out.println("\n[해설] 여러 case에 대해 같은 처리를 할 때 break 없이 나열하여 묶을 수 있습니다.\n");

        System.out.println("--- Lab5: Java 14+ switch 표현식 ---");
        Lab5.run();
        System.out.println("\n[해설] '->'를 사용하는 새로운 문법은 break가 필요 없고, 값을 바로 반환할 수 있어 편리합니다.\n");
    }

    static class Lab1 {
        static void run() {
            int num = 2;
            switch (num) {
                case 1:
                    System.out.println("1입니다.");
                    break;
                case 2:
                    System.out.println("2입니다.");
                    break;
                default:
                    System.out.println("기타");
            }
        }
    }

    static class Lab2 {
        static void run() {
            char grade = 'F';
            switch (grade) {
                case 'A':
                    System.out.println("우수");
                    break;
                case 'B':
                    System.out.println("보통");
                    break;
                default:
                    System.out.println("노력 필요");
            }
        }
    }

    static class Lab3 {
        static void run() {
            int month = 10;
            // 의도적으로 break를 안 쓴 경우
            switch (month) {
                case 9:
                case 10:
                case 11:
                    System.out.println("가을입니다.");
                    break;
            }
        }
    }

    static class Lab4 {
        static void run() {
            String position = "과장";
            switch (position) {
                case "부장":
                case "차장":
                    System.out.println("관리자");
                    break;
                case "과장":
                case "대리":
                case "사원":
                    System.out.println("실무자");
                    break;
            }
        }
    }

    static class Lab5 {
        static void run() {
            int day = 3; // 수요일
            String dayName = switch (day) {
                case 1 -> "월요일";
                case 2 -> "화요일";
                case 3 -> "수요일";
                case 4 -> "목요일";
                case 5 -> "금요일";
                default -> "주말";
            };
            System.out.println("오늘은 " + dayName);
        }
    }
}
