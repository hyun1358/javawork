package week01.day3;

/**
 * [정답 + 해설 5] Week 01 Day 3
 */
public class Answer5 {
    public static void main(String[] args) {
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
