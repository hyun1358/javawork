package week04.day5;

public class Answer5 {
    // 메인 메서드: 메서드 체이닝(Method Chaining)을 테스트하는 코드
    public static void main(String[] args) {
        // 공백이 포함되고 소문자로 작성된 문자열을 전달하여 호출
        System.out.println(cleanString("  java  "));
    }

    // cleanString 메서드: 전달받은 문자열의 앞뒤 공백을 제거하고 대문자로 변환
    public static String cleanString(String s) {
        // trim()으로 문자열 앞뒤의 불필요한 공백을 제거한 후,
        // 이어서 toUpperCase()를 호출하여 알파벳을 모두 대문자로 변경 (메서드 체이닝 기법)
        return s.trim().toUpperCase();
    }
}
