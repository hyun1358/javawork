package week01.day3;

/**
 * [정답 + 해설 1] Week 01 Day 3
 */
public class Answer1 {
    public static void main(String[] args) {
        int n1 = 15;
        int n2 = 4;
        System.out.println("합: " + (n1 + n2));
        System.out.println("차: " + (n1 - n2));
        System.out.println("곱: " + (n1 * n2));
        System.out.println("몫: " + (n1 / n2));
        System.out.println("나머지: " + (n1 % n2));
    }
}
/*
 [해설]
 산술 연산자를 각각 사용하여 계산합니다. 
 나눗셈(/)은 소수점이 버려진 몫만 나옴에 주의하세요.
*/
