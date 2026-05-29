package week04.day5;

public class Answer3 {
    // 메인 메서드: 두 개의 메서드를 중첩(체인)하여 호출하는 로직 테스트
    public static void main(String[] args) {
        // add(5, 10)의 결과인 15가 multiply의 첫 번째 인자가 되어 multiply(15, 2) 호출
        int result = multiply(add(5, 10), 2);
        // 최종 계산된 결과(30) 출력
        System.out.println("결과: " + result);
    }

    // add 메서드: 두 수를 더하여 결과를 반환
    public static int add(int n, int plus) {
        return n + plus;
    }

    // multiply 메서드: 두 수를 곱하여 결과를 반환
    public static int multiply(int n, int mul) {
        return n * mul;
    }
}
