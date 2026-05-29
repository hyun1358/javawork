package week04.day4;

public class Answer2 {
    // 메인 메서드: 문자열 뒤집기 재귀 함수 호출 테스트
    public static void main(String[] args) {
        // "Hello"를 인자로 전달하여 반환된 뒤집힌 문자열 출력
        System.out.println(reverse("Hello"));
    }

    // reverse 메서드: 재귀를 이용하여 문자열을 역순으로 만드는 로직
    public static String reverse(String s) {
        // [기저 조건(Base Case)] 문자열이 비어있으면 더 이상 쪼갤 수 없으므로 그대로 반환
        if (s.isEmpty()) return s;
        // 첫 번째 글자(s.charAt(0))를 맨 뒤로 보내고, 
        // 나머지 문자열(s.substring(1))에 대해 재귀 호출하여 역순으로 만든 뒤 결합
        return reverse(s.substring(1)) + s.charAt(0);
    }
}
