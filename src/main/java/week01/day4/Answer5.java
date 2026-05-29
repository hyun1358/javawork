package week01.day4;

/**
 * [정답 + 해설 5] Week 01 Day 4
 */
public class Answer5 {
    public static void main(String[] args) {
        // String.valueOf()는 정수, 실수 등 다양한 기본 자료형을 문자열(String)로 변환해 줍니다.
        // 반대로 Double.parseDouble()은 문자열을 파싱하여 실수(double)로 변환해 주며, 계산 가능한 상태로 만듭니다.
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
