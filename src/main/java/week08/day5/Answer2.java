package week08.day5;

import java.util.Arrays;

/**
 * 제네릭 메서드를 사용하여 다양한 타입의 배열에서 요소들의 위치를 교환(Swap)하는 예제입니다.
 */
public class Answer2 {
    public static void main(String[] args) {
        String[] arr = {"A", "B", "C"};
        // swap 메서 호출 시 컴파일러가 인자를 보고 제네릭 타입 T를 String으로 추론합니다.
        swap(arr, 0, 2);
        // "A"와 "C"가 교환된 배열을 출력합니다.
        System.out.println(Arrays.toString(arr));
    }

    // 메서드의 반환 타입 앞에 <T>를 선언하여 제네릭 메서드임을 나타냅니다.
    // 어떠한 타입의 배열이라도 인자로 받을 수 있습니다.
    public static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
