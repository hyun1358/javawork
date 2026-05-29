package week12.day3;

// String.format()을 사용하여 자바 변수 값을 동적으로 JSON 문자열에 채워 넣는 예제입니다.
public class Answer2 {
    // 메인 메서드
    public static void main(String[] args) {
        // toJson 메서드에 정수와 문자열을 전달하여 JSON 문자열을 생성하고 출력합니다.
        System.out.println(toJson(1, "kim"));
    }

    // 매개변수를 받아 JSON 형식의 문자열로 만들어 반환하는 메서드
    public static String toJson(int id, String name) {
        // %d 자리에 숫자(id)를, %s 자리에 문자열(name)을 포맷팅하여 넣습니다.
        return String.format("{\"id\":%d, \"name\":\"%s\"}", id, name);
    }
}
