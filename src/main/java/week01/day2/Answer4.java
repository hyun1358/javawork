package week01.day2;

/**
 * [정답 + 해설 4] Week 01 Day 2
 */
public class Answer4 {
    public static void main(String[] args) {
        // char 타입은 단일 문자를 저장하며, 작은따옴표(' ')를 사용합니다.
        // 자바는 문자를 유니코드 값(숫자)으로 다루므로, 'A'와 그에 해당하는 65는 동일하게 취급되어
        // 문자를 출력할 수 있습니다.
        char ch = 'A';
        System.out.println("문자 'A': " + ch);
        ch = 65;
        System.out.println("숫자 65 대입 시: " + ch);
    }
}
/*
 [해설]
 자바는 내부적으로 문자를 유니코드(숫자)로 처리하기 때문에 가능합니다.
*/
