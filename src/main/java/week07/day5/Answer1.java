package week07.day5;

/**
 * StringBuilder를 이용하여 문자열을 뒤집고 회문(Palindrome) 여부를 검사하는 예제입니다.
 */
public class Answer1 {
    public static void main(String[] args) {
        String s = "level";
        // StringBuilder의 reverse() 메서드를 사용하여 문자열을 뒤집은 후 다시 String으로 변환합니다.
        String rev = new StringBuilder(s).reverse().toString();
        // 원본 문자열과 뒤집은 문자열이 동일한지 비교하여 회문인지 확인합니다.
        System.out.println("회문 여부: " + s.equals(rev));
    }
}
