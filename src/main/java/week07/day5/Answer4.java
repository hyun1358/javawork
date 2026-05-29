package week07.day5;

/**
 * StringBuilder를 사용하여 문자열을 효율적으로 결합하는 예제입니다.
 */
public class Answer4 {
    public static void main(String[] args) {
        // String 연산(+)은 성능이 떨어지므로, 가변 문자열 처리에 유리한 StringBuilder를 사용합니다.
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 10; i++) {
            // append 메서드로 숫자와 공백을 추가합니다.
            sb.append(i).append(" ");
        }
        // 완성된 StringBuilder 객체를 String으로 변환하여 출력합니다.
        System.out.println(sb.toString());
    }
}
