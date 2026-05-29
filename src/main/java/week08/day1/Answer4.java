package week08.day1;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * removeIf 메서드와 람다식을 활용하여 조건에 맞는 요소를 리스트에서 일괄 제거하는 예제입니다.
 */
public class Answer4 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        // 람다식(n -> n % 2 != 0)을 사용하여 2로 나누어 떨어지지 않는 수(홀수)를 모두 삭제합니다.
        list.removeIf(n -> n % 2 != 0); 
        // 짝수만 남은 리스트를 출력합니다.
        System.out.println(list);
    }
}
