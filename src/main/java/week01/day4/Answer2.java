package week01.day4;

/**
 * [정답 + 해설 2] Week 01 Day 4
 */
public class Answer2 {
    public static void main(String[] args) {
        // 정수끼리의 나눗셈은 결과도 정수(몫)로 나옵니다. 
        // 소수점까지 정확한 결과를 얻으려면 피연산자 중 하나 이상을 (double)로 명시적 형변환하여 실수 연산을 유도해야 합니다.
        int a = 7;
        int b = 2;
        double result = (double) a / b;
        System.out.println("결과: " + result);
    }
}
/*
 [해설]
 계산 시 한쪽을 double로 형변환하면 전체 연산 결과가 double이 됩니다.
*/
