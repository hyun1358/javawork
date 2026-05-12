package week04.day4;

public class Answer4 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(sum(arr, arr.length - 1));
    }

    public static int sum(int[] arr, int n) {
        if (n == 0) return arr[0];
        return arr[n] + sum(arr, n - 1);
    }
}
