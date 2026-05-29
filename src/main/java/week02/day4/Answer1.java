package week02.day4;

/*
 * [정답 + 해설 1] Week 02 Day 4
 * 문제: while 문으로 1~10 합계 구하기
 */
public class Answer1 {
    public static void main(String[] args) {
        // while 문은 조건식이 참(true)인 동안 계속해서 블록을 반복 실행합니다.
        // 반복 횟수가 불명확하거나 조건에 의존적일 때 많이 쓰이며, 반드시 루프 내부에 조건식을 false로 만들 수 있는 코드(증감식 등)가 포함되어야 합니다.
        int sum = 0;
        int i = 1;

        while (i <= 10) {
            sum += i;
            i++; // 증감식 필수! 안 쓰면 무한 루프에 빠집니다.
        }

        System.out.println("1~10 합계: " + sum);
    }
}
/*
 * [해설]
 * - while(i <= 10) 조건이 참인 동안 내부 코드가 실행됩니다.
 * - i++를 통해 매번 i의 값을 증가시켜야 언젠가 i가 11이 되어 반복이 종료됩니다.
 */
