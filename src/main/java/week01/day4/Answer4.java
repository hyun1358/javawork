package week01.day4;

/**
 * [정답 + 해설 4] Week 01 Day 4
 */
public class Answer4 {
    public static void main(String[] args) {
        // "100"과 같이 숫자로 이루어진 문자열은 덧셈을 하면 문자열 결합이 일어납니다.
        // 실제 수학적 연산을 하려면 Integer.parseInt() 메서드를 사용해 문자열을 int 정수형으로 변환해야 합니다.
        String s1 = "100";
        String s2 = "200";
        int n1 = Integer.parseInt(s1);
        int n2 = Integer.parseInt(s2);
        System.out.println("합계: " + (n1 + n2));
    }
}
/*
 [해설]
 Integer.parseInt()는 문자열 안의 숫자를 실제 int 정수로 바꿔줍니다.
*/
