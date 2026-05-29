package week07.day1;

/**
 * 다중 catch 블록을 사용하여 여러 종류의 예외를 각각 다르게 처리하는 예제입니다.
 */
public class Answer5 {
    public static void main(String[] args) {
        try {
            // 크기가 2인 배열을 생성합니다.
            int[] arr = new int[2];
            // arr[3] = 5; // 이 주석을 풀면 배열 인덱스 초과 예외가 먼저 발생하여 두 번째 catch가 실행됩니다.
            
            // 0으로 나누기를 시도하여 산술 연산 예외를 발생시킵니다.
            int a = 5 / 0;
        } catch (ArithmeticException e) {
            // ArithmeticException이 발생했을 때 실행되는 블록입니다.
            System.out.println("0나누기 에러");
        } catch (ArrayIndexOutOfBoundsException e) {
            // ArrayIndexOutOfBoundsException이 발생했을 때 실행되는 블록입니다.
            System.out.println("인덱스 에러");
        }
    }
}
