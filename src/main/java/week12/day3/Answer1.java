package week12.day3;

// 기본적인 JSON(JavaScript Object Notation) 형식의 문자열을 작성해 보는 예제입니다.
public class Answer1 {
    // 메인 메서드
    public static void main(String[] args) {
        // 이스케이프 문자(\)를 사용하여 큰따옴표(")를 포함한 JSON 문자열을 직접 생성합니다.
        // 키(name, phone)와 문자열 값은 반드시 큰따옴표로 감싸야 합니다.
        String json = "{\"name\":\"이순신\", \"phone\":\"010-1234-1234\"}";
        // 생성된 JSON 형태의 문자열을 콘솔에 출력합니다.
        System.out.println(json);
    }
}
