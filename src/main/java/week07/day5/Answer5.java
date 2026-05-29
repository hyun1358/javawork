package week07.day5;

/**
 * String.format을 사용하여 문자열을 일정한 형식에 맞게 출력하는 예제입니다.
 */
public class Answer5 {
    public static void main(String[] args) {
        // %-10s: 문자열을 10자리 공간에 왼쪽 정렬하여 출력합니다.
        // %5d: 정수를 5자리 공간에 오른쪽 정렬하여 출력합니다.
        System.out.println(String.format("%-10s | %5d", "홍길동", 100));
        System.out.println(String.format("%-10s | %5d", "이순신", 80));
    }
}
