package week03.day4;

/**
 * [예습 파일] Week 03 Day 4 — String 배열과 병렬 배열
 */
public class Preview {
    public static void main(String[] args) {
        // 1. 문자열 배열
        String[] fruits = {"Apple", "Banana", "Cherry"};

        // 2. 병렬 배열 (이름과 점수를 동일한 인덱스로 매칭)
        String[] names = {"홍길동", "이순신", "강감찬"};
        int[] scores = {90, 85, 100};

        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i] + "의 점수: " + scores[i]);
        }
    }
}
