package week08.day4;

import java.util.*;

public class Answer4_1 {
    public static void main(String[] args) {
        // 방법 1: TreeSet 사용 (자동으로 중복 제거 + 오름차순 정렬)
        Set<Integer> lottoTree = new TreeSet<>();
        while (lottoTree.size() < 6) {
            lottoTree.add((int) (Math.random() * 45) + 1);
        }
        System.out.println("정렬된 로또 번호(TreeSet): " + lottoTree);

        /*
        // 방법 2: HashSet + Collections.sort() 사용
        Set<Integer> lottoHash = new HashSet<>();
        while (lottoHash.size() < 6) {
            lottoHash.add((int) (Math.random() * 45) + 1);
        }
        // 정렬을 위해 List로 변환
        List<Integer> sortedList = new ArrayList<>(lottoHash);
        Collections.sort(sortedList);
        System.out.println("정렬된 로또 번호(List): " + sortedList);
        */
    }
}
