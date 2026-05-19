package week08.day2;

import java.util.HashMap;

/**
 * [추가 연습 문제 5-1] getOrDefault() 활용 심화 (투표 시스템)
 * 문제: 아래의 투표 배열을 읽고, 각 후보가 몇 표를 받았는지 HashMap을 사용하여 집계하세요.
 * 힌트: getOrDefault() 메서드를 사용하면 코드를 아주 짧게 줄일 수 있습니다. (if-else 없이 시도해 보세요!)
 */
public class Problem5_1 {
    public static void main(String[] args) {
        String[] votes = {"김철수", "이영희", "김철수", "홍길동", "이영희", "이영희"};
        HashMap<String, Integer> voteCount = new HashMap<>();

        // TODO: votes 배열을 순회하며 voteCount에 득표수를 누적하세요.
        // 여기에 코드를 작성하세요.
        for(int i = 0; i < votes.length; i++)
        {
            voteCount.put(votes[i], voteCount.getOrDefault(votes[i],0) +1 );
        }

        // 출력 확인 (변경하지 마세요)
        for (String name : voteCount.keySet()) {
            System.out.println(name + " 득표수: " + voteCount.get(name));
        }
        // 예상 출력:
        // 홍길동 득표수: 1
        // 김철수 득표수: 2
        // 이영희 득표수: 3
    }
}