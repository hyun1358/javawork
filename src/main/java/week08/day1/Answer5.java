package week08.day1;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 일반 배열과 ArrayList 간의 변환을 수행하는 예제입니다.
 */
public class Answer5 {
    public static void main(String[] args) {
        String[] arr = {"A", "B", "C"};
        // 1. 배열을 ArrayList로 변환합니다. (Arrays.asList 사용)
        ArrayList<String> list = new ArrayList<>(Arrays.asList(arr));

        // 2. ArrayList를 다시 일반 배열로 변환합니다. (toArray 메서드 사용)
        // new String[0]을 인자로 주면 리스트 크기에 맞는 새 배열이 반환됩니다.
        String[] newArr = list.toArray(new String[0]);
        // Arrays.toString을 사용하여 복원된 배열의 요소를 출력합니다.
        System.out.println("배열 복원: " + Arrays.toString(newArr));
    }
}
