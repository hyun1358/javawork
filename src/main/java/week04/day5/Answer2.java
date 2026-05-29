package week04.day5;

public class Answer2 {
    // 메인 메서드: 아이디와 비밀번호의 유효성 검사 메서드 호출 테스트
    public static void main(String[] args) {
        // 아이디 "java"와 비밀번호 "12345678"이 조건에 맞는지 확인 후 결과 출력 (true 예상)
        System.out.println(isValidLogin("java", "12345678"));
    }

    // isValidLogin 메서드: 전달받은 아이디(id)와 비밀번호(pw)의 길이를 검사하여 불리언 값 반환
    public static boolean isValidLogin(String id, String pw) {
        // 아이디 길이가 4 이상이고(AND), 비밀번호 길이가 8 이상인지 확인하여 결과 반환
        return id.length() >= 4 && pw.length() >= 8;
    }
}
