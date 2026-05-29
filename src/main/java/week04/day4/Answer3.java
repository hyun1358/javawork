package week04.day4;

public class Answer3 {
    // 메인 메서드: 거듭제곱을 계산하는 재귀 함수 호출 테스트
    public static void main(String[] args) {
        // 밑(base) 2, 지수(exp) 10을 인자로 전달하여 2의 10승 계산 (1024)
        System.out.println(power(2, 10));
    }

    // power 메서드: 밑과 지수를 매개변수로 받아 거듭제곱을 재귀적으로 계산
    public static int power(int base, int exp) {
        // [기저 조건(Base Case)] 지수가 0이면 어떤 수의 0승이든 1을 반환
        if (exp == 0) return 1;
        // 지수가 0이 될 때까지 base를 반복해서 곱함
        return base * power(base, exp - 1);
    }
}
