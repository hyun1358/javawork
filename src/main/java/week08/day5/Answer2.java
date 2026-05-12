package week08.day5;

import java.util.Arrays;

public class Answer2 {
    public static void main(String[] args) {
        String[] arr = {"A", "B", "C"};
        swap(arr, 0, 2);
        System.out.println(Arrays.toString(arr));
    }

    public static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
