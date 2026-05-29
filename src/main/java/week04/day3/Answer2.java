package week04.day3;

public class Answer2 {
    // 메인 메서드: 매개변수의 개수와 타입이 다른 multiply 메서드 오버로딩 테스트
    public static void main(String[] args) {
        // 정수 2개를 인자로 전달 (int, int) -> 첫 번째 메서드 호출됨
        System.out.println(multiply(2, 3));
        // 정수 3개를 인자로 전달 (int, int, int) -> 두 번째 메서드 호출됨
        System.out.println(multiply(2, 3, 4));
        // 실수 2개를 인자로 전달 (double, double) -> 세 번째 메서드 호출됨
        System.out.println(multiply(1.5, 2.0));
    }

    // multiply 메서드 오버로딩 1: 매개변수가 int 2개인 경우
    public static int multiply(int a, int b) {
        return a * b; // 두 정수의 곱 반환
    }

    // multiply 메서드 오버로딩 2: 매개변수가 int 3개인 경우
    public static int multiply(int a, int b, int c) {
        return a * b * c; // 세 정수의 곱 반환
    }

    // multiply 메서드 오버로딩 3: 매개변수가 double 2개인 경우
    public static double multiply(double a, double b) {
        return a * b; // 두 실수의 곱 반환
    }
}
