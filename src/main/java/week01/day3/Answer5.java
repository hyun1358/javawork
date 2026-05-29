package week01.day3;

/**
 * [정답 + 해설 5] Week 01 Day 3
 */
public class Answer5 {
    public static void main(String[] args) {
        // 증감 연산자(++, --)는 변수의 값을 1씩 증가시키거나 감소시킵니다.
        // 후위형(x++)은 변수의 현재 값을 먼저 반환한 '후'에 값을 1 증가시키고,
        // 전위형(++x)은 변수의 값을 먼저 1 증가시킨 '후'에 그 값을 반환합니다.
        int x = 10;
        System.out.println("x++ : " + (x++)); // 10 출력 후 11이 됨
        System.out.println("++x : " + (++x)); // 11에서 1증가한 12 출력
    }
}
/*
 [해설]
 후위 연산(x++)은 현재 값을 사용한 '후'에 증가하고,
 전위 연산(++x)은 증가시킨 '후'에 값을 사용합니다.
*/
