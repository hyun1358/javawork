package week08.day1;

import java.util.ArrayList;
import java.util.Arrays;

public class Answer4 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        list.removeIf(n -> n % 2 != 0); // 홀수 삭제
        System.out.println(list);
    }
}
