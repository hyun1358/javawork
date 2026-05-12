package week01.day4;

/**
 * [정답 + 해설 1] Week 01 Day 4
 */
public class Answer1 {
    public static void main(String[] args) {
        double d = 3.99;
        int i = (int) d;
        System.out.println("원본 double: " + d);
        System.out.println("변환된 int: " + i);
    }
}
/*
 [해설]
 double을 int로 변환하면 소수점 아래 자리가 모두 버려집니다. (반올림 아님)
*/
