package week04.day1;

/*
 * [정답 + 해설 1] Week 04 Day 1
 * 문제: "안녕하세요!"를 출력하는 메서드 printHello 만들기
 */
public class Answer1 {
    public static void main(String[] args) {
        // 정의한 메서드를 호출합니다.
        printHello();
    }

    // void는 반환값이 없다는 뜻입니다.
    public static void printHello() {
        System.out.println("안녕하세요!");
    }
}
/*
 * [해설]
 * - 메서드는 코드의 재사용성을 높여줍니다.
 * - printHello()를 호출할 때마다 "안녕하세요!"가 출력됩니다.
 * - public static void main도 하나의 메서드입니다. 자바 프로그램의 시작점입니다.
 */
