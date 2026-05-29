package week07.day1;

/**
 * 배열의 인덱스 범위를 벗어나는 예외(ArrayIndexOutOfBoundsException)를 처리하는 예제입니다.
 */
public class Answer2 {
    public static void main(String[] args) {
        try {
            // 크기가 2인 배열을 생성합니다. (인덱스는 0, 1만 유효합니다)
            int[] arr = new int[2];
            // 유효하지 않은 인덱스인 2에 접근하려고 하여 예외가 발생합니다.
            arr[2] = 10;
        } catch (ArrayIndexOutOfBoundsException e) {
            // 배열 인덱스 초과 오류 발생 시 이를 잡아내어 경고 메시지를 출력합니다.
            System.out.println("배열 범위 초과");
        }
    }
}
