package week01.day4;

/**
 * [정답 + 해설 5] Week 01 Day 4
 */
public class Answer5 {
    public static void main(String[] args) {
        double d1 = 3.14;
        String s = String.valueOf(d1);
        System.out.println("문자열 변환: " + s);
        double d2 = Double.parseDouble(s);
        System.out.println("숫자 복원: " + d2);
    }
}
/*
 [해설]
 String.valueOf()는 무엇이든 문자열로, Double.parseDouble()은 문자열을 실수로 바꿉니다.
*/
