package week04.day5;

/**
 * [학습 예제] Week 04 Day 5 — 메서드 설계와 문서화 (리팩토링, 로그인 검증, 메서드 중첩, Javadoc 표준, 문자열 유틸)
 * 
 * [학습 핵심 이론: 클린 코드와 메서드 문서화 표준]
 * 1. 단일 책임 원칙 (Single Responsibility Principle):
 *    - 하나의 메서드는 오직 '한 가지 역할'만 수행해야 하며, 코드 중복이 발생하면 즉시 전용 메서드로 분리(Extract Method)해 리팩토링합니다. (Problem 1 연계)
 * 
 * 2. 입력값 검증 (Validation):
 *    - 메서드 초입부에 잘못된 인수 값이 오는지 사전에 체크하여 차단(Guard Clauses)하는 구조로 결함을 방지합니다. (Problem 2 연계)
 * 
 * 3. 메서드 중첩 호출 (Nesting / Chaining):
 *    - 한 메서드의 반환(return)값을 다른 메서드의 매개변수로 직접 전달하여 임시 변수 선언을 줄이고 직관적인 흐름을 연출합니다. (Problem 3 연계)
 * 
 * 4. Javadoc 문서화 표준 태그:
 *    - `@param`: 매개변수의 역할과 자료형 설명
 *    - `@return`: 반환되는 값의 의미와 범위 설명
 *    - `@throws`/`@exception`: 발생 가능한 예외 명시 (Problem 4 연계)
 * 
 * 5. String 가공 유틸리티:
 *    - `.trim()`은 앞뒤 공백을 자르고, `.toUpperCase()`는 알파벳을 소문자에서 대문자로 통일해 데이터 정형화를 돕습니다. (Problem 5 연계)
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Week 04 Day 5 학습 예제 ===\n");

        System.out.println("--- Lab1: 공통 출력 코드를 분리하는 메서드 리팩토링 (Problem 1 연계) ---");
        printStudentCard("홍길동");

        System.out.println("\n--- Lab2: 로그인 데이터 길이 유효성 검증 (Problem 2 연계) ---");
        boolean success = isValidLogin("java_user", "pass12345");
        boolean fail = isValidLogin("abc", "123");
        System.out.println("정상 ID/PW 검증 결과: " + success);
        System.out.println("비정상 ID/PW 검증 결과: " + fail);

        System.out.println("\n--- Lab3: 메서드 중첩 호출 (합산 후 곱하기) (Problem 3 연계) ---");
        int nestedResult = multiply(add(5, 10), 2);
        System.out.println("multiply(add(5, 10), 2) 결과: " + nestedResult);

        System.out.println("\n--- Lab4: Javadoc 표준 문서화 주석 적용 원의 넓이 계산 (Problem 4 연계) ---");
        double circleArea = getCircleArea(5.0);
        System.out.printf("반지름 5.0 원의 넓이: %.2f\n", circleArea);

        System.out.println("\n--- Lab5: 문자열 앞뒤 공백 제거 및 대문자 정규화 유틸리티 (Problem 5 연계) ---");
        String formatted = cleanString("  java  ");
        System.out.println("정규화 전: \"  java  \" -> 정규화 후: \"" + formatted + "\"");
    }

    // Problem 1: 공통 레이아웃 출력 메서드 분리 리팩토링
    public static void printHeader(String title) {
        System.out.println("---------");
        System.out.println(title);
        System.out.println("---------");
    }

    public static void printData(String label, String value) {
        System.out.println(label + ": " + value);
    }

    public static void printFooter() {
        System.out.println("---------");
    }

    public static void printStudentCard(String studentName) {
        printHeader("학생 정보");
        printData("이름", studentName);
        printFooter();
    }

    // Problem 2: 로그인 유효성 검증 (ID 4자 이상, PW 8자 이상)
    public static boolean isValidLogin(String id, String pw) {
        if (id == null || pw == null) {
            return false;
        }
        return id.length() >= 4 && pw.length() >= 8;
    }

    // Problem 3: 중첩 호출을 위한 연산 메서드들
    public static int add(int a, int b) {
        return a + b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    // Problem 4: Javadoc 표준 태그를 적용한 원의 넓이 메서드
    /**
     * 지정한 반지름 값을 기준으로 원의 넓이를 계산하여 반환합니다.
     *
     * @param radius 원의 반지름 값 (0보다 커야 함)
     * @return 원의 계산된 넓이 값 (PI * radius * radius)
     */
    public static double getCircleArea(double radius) {
        if (radius <= 0) {
            return 0.0;
        }
        return Math.PI * radius * radius;
    }

    // Problem 5: 공백을 제거하고 대문자로 변환해주는 문자열 유틸리티
    public static String cleanString(String s) {
        if (s == null) {
            return "";
        }
        // trim()으로 앞뒤 공백을 자르고, toUpperCase()로 대문자 치환
        return s.trim().toUpperCase();
    }
}
