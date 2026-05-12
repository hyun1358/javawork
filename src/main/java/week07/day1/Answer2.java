package week07.day1;

public class Answer2 {
    public static void main(String[] args) {
        try {
            int[] arr = new int[2];
            arr[2] = 10;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("배열 범위 초과");
        }
    }
}
