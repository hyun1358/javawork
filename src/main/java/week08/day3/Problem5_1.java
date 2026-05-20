package week08.day3;

import java.util.Arrays;
import java.util.List;

/**
 * [복습 문제 5-1] 공동 등수 처리
 * 
 * 목표: 점수가 내림차순으로 미리 정렬된 리스트가 주어집니다.
 *       공동 점수가 있을 때 숫자를 '건너뛰는' 방식으로 등수를 출력하세요.
 * 
 * 예상 출력:
 * 1등: 900점
 * 1등: 900점
 * 3등: 850점
 * 4등: 800점
 */
public class Problem5_1 {
    public static void main(String[] args) {
        // 이미 내림차순 정렬이 끝났다고 가정한 리스트
        List<Integer> scores = Arrays.asList(900, 900, 850, 800);

        int rank = 0;
        int prevScore = -1;

        // TODO: 아래 반복문 안의 로직을 완성하여 예상 출력과 동일하게 나오게 하세요.
        for (int i = 0; i < scores.size(); i++) {
            int currentScore = scores.get(i);
            
            // 여기에 등수(rank)를 계산하는 로직 작성
            // 힌트: currentScore와 prevScore를 비교하고, 인덱스(i)를 잘 활용하세요.
            if(currentScore != prevScore)
            {
                rank = i + 1;
            }
            System.out.println(rank + "등: " + currentScore + "점");
            prevScore = currentScore;
        }
    }
}
