package week01.day2;

/**
 * [정답 + 해설 5] Week 01 Day 2
 */
public class Answer5 {
    public static void main(String[] args) {
        // 실수를 다루는 타입에는 float과 double이 있습니다.
        // float은 끝에 f를 붙여야 하며, double은 기본형이므로 생략 가능합니다.
        // 콘솔 출력 결과를 보면 double이 float보다 더 많은 소수점 이하 자리까지 정밀하게 표현함을 알 수 있습니다.
        float f = 3.141592653589793f;
        double d = 3.141592653589793;
        System.out.println("float : " + f);
        System.out.println("double: " + d);
    }
}
/*
 [해설]
 double이 float보다 약 2배 더 정밀한 소수점 표현이 가능합니다.
*/
