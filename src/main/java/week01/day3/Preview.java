package week01.day3;

/**
 * [예습 파일] Week 01 Day 3 — 연산자 (Operator)
 * 
 * 연산자는 데이터를 계산(더하기, 빼기)하거나 비교(크다, 작다)할 때 사용하는 기호입니다.
 * 
 * [핵심 연산자]
 * 1. 산술 연산자: +, -, *, / (몫), % (나머지)
 * 2. 비교 연산자: == (같다), != (다르다), >, <, >=, <=
 * 3. 논리 연산자: && (둘 다 참일 때 참 - AND), || (하나라도 참이면 참 - OR)
 * 4. 증감 연산자: ++ (1씩 증가), -- (1씩 감소)
 */
public class Preview {
    public static void main(String[] args) {
        int a = 10;
        int b = 3;

        // 1. 산술 연산
        System.out.println("a + b = " + (a + b));
        System.out.println("a / b = " + (a / b)); // 정수끼리 나누면 결과도 정수(몫만 나옴)
        System.out.println("a % b = " + (a % b)); // 나눈 뒤 남은 '나머지' 값

        // 2. 비교 연산 (결과는 항상 true 또는 false)
        System.out.println("a가 b보다 큰가? : " + (a > b));
        System.out.println("a와 b가 같은가? : " + (a == b));

        // 3. 논리 연산
        // (a가 5보다 크고) 그리고 (b가 5보다 작은가?)
        System.out.println("두 조건 모두 참인가? : " + ((a > 5) && (b < 5)));

        // 4. 증감 연산
        int c = 5;
        System.out.println("c++의 결과 : " + (c++)); // 이번 줄에선 5로 보이고, 다음 줄부터 6이 됨
        System.out.println("현재 c의 값 : " + c);
    }
}
