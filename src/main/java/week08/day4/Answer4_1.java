package week08.day4;

import java.util.*;

/**
 * 중복 없는 로또 번호를 추출하면서 자동으로 오름차순 정렬까지 수행하는 예제입니다.
 */
public class Answer4_1 {
    public static void main(String[] args) {
        // 방법 1: TreeSet 사용 (자동으로 중복 제거 + 오름차순 정렬)
        // TreeSet은 Set의 특성(중복 불가)과 요소들을 항상 정렬된 상태로 유지하는 특징을 갖습니다.
        Set<Integer> lottoTree = new TreeSet<>();
        while (lottoTree.size() < 6) {
            lottoTree.add((int) (Math.random() * 45) + 1);
        }
        System.out.println("정렬된 로또 번호(TreeSet): " + lottoTree);

        /*
        // 방법 2: HashSet + Collections.sort() 사용
        // 먼저 HashSet으로 중복을 제거한 뒤,
        Set<Integer> lottoHash = new HashSet<>();
        while (lottoHash.size() < 6) {
            lottoHash.add((int) (Math.random() * 45) + 1);
        }
        // 정렬을 위해 List로 변환하고 Collections.sort()를 호출합니다.
        List<Integer> sortedList = new ArrayList<>(lottoHash);
        Collections.sort(sortedList);
        System.out.println("정렬된 로또 번호(List): " + sortedList);
        */
    }
}
