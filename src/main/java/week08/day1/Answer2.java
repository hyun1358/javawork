package week08.day1;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * ArrayList에 저장된 요소들의 합계와 평균을 계산하는 예제입니다.
 */
public class Answer2 {
    public static void main(String[] args) {
        // Arrays.asList를 사용하여 초기값을 가진 ArrayList를 쉽게 생성합니다.
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(80, 90, 100));
        int sum = 0;
        
        // 향상된 for문을 돌면서 모든 점수를 합산합니다.
        for (int s : scores) sum += s;
        
        // size() 메서드로 리스트의 길이를 구하여 평균을 계산한 뒤 출력합니다.
        System.out.println("합계: " + sum + ", 평균: " + (sum / scores.size()));
    }
}
