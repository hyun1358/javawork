package week07.day5;

/**
 * split 메서드를 사용하여 특정 구분자를 기준으로 문자열을 분리하는 예제입니다.
 */
public class Answer3 {
    public static void main(String[] args) {
        // 구분자 '/'를 포함하는 데이터 문자열입니다.
        String data = "홍길동/20/남";
        // "/"를 기준으로 분리하여 문자열 배열로 반환합니다.
        String[] parts = data.split("/");
        // 향상된 for문을 통해 배열의 각 요소를 차례대로 출력합니다.
        for (String p : parts) System.out.println(p);
    }
}
