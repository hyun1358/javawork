package week01.day2;

/**
 * [정답 + 해설 3] Week 01 Day 2
 */
public class Answer3 {
    public static void main(String[] args) {
        // 자바에서 정수 리터럴은 기본적으로 int로 인식됩니다.
        // int 범위를 넘어서는 큰 숫자(예: 1조)를 long 타입에 저장할 때는
        // 숫자 끝에 L(또는 l)을 붙여 컴파일러에게 long 타입임을 명시해야 합니다.
        long bigNumber = 1000000000000L;
        System.out.println("1조: " + bigNumber);
    }
}
/*
 [해설]
 long 타입 리터럴 뒤에는 반드시 L을 붙여야 컴파일러가 long으로 인식합니다.
*/
