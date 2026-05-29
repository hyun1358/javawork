package week07.day2;

/**
 * 중첩된 try-catch 블록의 사용법을 보여주는 예제입니다.
 */
public class Answer5 {
    public static void main(String[] args) {
        try {
            // 중첩된 try-catch 블록의 예제입니다. 내부 try 블록에서 산술 예외를 처리합니다.
            try {
                int a = 1 / 0;
            } catch (ArithmeticException e) {
                System.out.println("내부 catch: " + e.getMessage());
            }
            
            // 내부 예외가 처리된 후 실행이 계속되며, 배열 인덱스 초과 예외를 발생시킵니다.
            int[] arr = new int[2];
            arr[3] = 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            // 외부 try 블록에서 발생한 예외를 처리합니다.
            System.out.println("외부 catch: " + e.getMessage());
        }
    }
}
