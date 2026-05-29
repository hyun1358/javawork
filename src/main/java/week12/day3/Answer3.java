package week12.day3;

// 배열(Array) 형태의 JSON 문자열을 작성하는 예제입니다.
public class Answer3 {
    // 메인 메서드
    public static void main(String[] args) {
        // JSON에서 배열은 대괄호([])로 묶으며, 배열 내부에는 여러 JSON 객체({})가 쉼표로 구분되어 들어갑니다.
        String jsonArr = "[{\"id\":1}, {\"id\":2}]";
        // 생성된 JSON 배열 문자열을 출력합니다.
        System.out.println(jsonArr);
    }
}
