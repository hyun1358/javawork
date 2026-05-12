package week01.day3;

/**
 * [예습 파일] Week 01 Day 3 — 연산자
 * <p>
 * 연산자(Operator)는 데이터를 계산하거나 비교할 때 사용합니다.
 * 다양한 연산자의 종류를 미리 구경해봅시다.
 */
public class Preview {
    public static void main(String[] args) {
        int a = 10;
        int b = 3;

        // 1. 산술 연산
        System.out.println("a + b = " + (a + b));
        System.out.println("a / b = " + (a / b)); // 정수 나눗셈
        System.out.println("a % b = " + (a % b)); // 나머지

        // 2. 비교 연산
        System.out.println("a > b : " + (a > b));
        System.out.println("a == b : " + (a == b));

        // 3. 논리 연산
        System.out.println("(a > 5) && (b < 5) : " + ((a > 5) && (b < 5)));

        // 4. 증감 연산
        int c = 5;
        System.out.println("c++ : " + (c++));
        System.out.println("현재 c : " + c);
    }
}
