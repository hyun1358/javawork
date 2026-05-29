package week01.day2;

/**
 * [정답 + 해설 2] Week 01 Day 2
 */
public class Answer2 {
    public static void main(String[] args) {
        // int형이 표현할 수 있는 최대값은 2,147,483,647 입니다.
        // 이 최대값에 1을 더하면 표현 범위를 초과하는 '오버플로우(Overflow)'가 발생하여
        // 가장 작은 값(최소값)인 -2,147,483,648 로 돌아갑니다.
        int max = 2147483647;
        System.out.println("최대값: " + max);
        System.out.println("최대값 + 1: " + (max + 1));
    }
}
/*
 [해설]
 int 범위를 넘어가면 '오버플로우(Overflow)'가 발생하여 가장 작은 값으로 돌아갑니다.
*/
