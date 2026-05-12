package week07.day1;

public class Answer5 {
    public static void main(String[] args) {
        try {
            int[] arr = new int[2];
            // arr[3] = 5; // 이 주석을 풀면 두 번째 catch가 실행됩니다.
            int a = 5 / 0;
        } catch (ArithmeticException e) {
            System.out.println("0나누기 에러");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("인덱스 에러");
        }
    }
}
