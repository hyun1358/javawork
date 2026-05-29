package week04.day4;

public class Answer5 {
    // 메인 메서드: 1부터 n까지의 합을 구하는 재귀 함수 테스트
    public static void main(String[] args) {
        // 1부터 10까지의 합(55)을 계산하는 재귀 메서드 호출
        System.out.println(sumTo(10));
    }

    // sumTo 메서드: 전달받은 수 n부터 1까지 감소시키며 재귀적으로 합산
    public static int sumTo(int n) {
        // [기저 조건(Base Case)] n이 1이 되면 1을 반환하며 재귀 호출 종료
        if (n == 1) return 1;
        // n과 (n-1까지의 합)을 더하는 과정을 반복
        return n + sumTo(n - 1);
    }
}
