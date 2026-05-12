package week03.day2;

import java.util.Arrays;

/**
 * [예습 파일] Week 03 Day 2 — 배열 활용 + 정렬
 * <p>
 * ▶ 이 파일을 먼저 실행해보세요!
 * 오늘은 배열을 정렬하고 복사하고, 더 편하게 다루는 법을 배웁니다.
 */
public class Preview {
    public static void main(String[] args) {
        // 1. 배열 정렬하기 (Arrays.sort)
        int[] numbers = {45, 12, 78, 23, 56};
        System.out.println("정렬 전: " + Arrays.toString(numbers));

        Arrays.sort(numbers);
        System.out.println("정렬 후: " + Arrays.toString(numbers));

        // 2. 향상된 for문 (for-each)
        System.out.print("모든 요소 출력: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();

        // 3. 배열 복사하기
        int[] copyArr = Arrays.copyOf(numbers, numbers.length);
        System.out.println("복사된 배열: " + Arrays.toString(copyArr));

        System.out.println("--- 오늘 배울 내용 미리보기 끝 ---");
    }
}
