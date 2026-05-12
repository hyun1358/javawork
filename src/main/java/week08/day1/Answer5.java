package week08.day1;

import java.util.ArrayList;
import java.util.Arrays;

public class Answer5 {
    public static void main(String[] args) {
        String[] arr = {"A", "B", "C"};
        ArrayList<String> list = new ArrayList<>(Arrays.asList(arr));

        String[] newArr = list.toArray(new String[0]);
        System.out.println("배열 복원: " + Arrays.toString(newArr));
    }
}
