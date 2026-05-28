package week03.day2;

import java.util.Arrays;

/**
 * [예습 파일] Week 03 Day 2 — 다차원 배열
 * 
 * [핵심 개념: 다차원 배열]
 * 1. 2차원 배열의 개념:
 *    - 1차원 배열의 묶음으로, 흔히 행(Row)과 열(Column)로 구성된 격자판 구조의 데이터를 다루는 데 최적입니다.
 *    - 선언 방식: `int[][] arr = new int[행크기][열크기];`
 * 
 * 2. 메모리 상의 2차원 배열 구조 (참조의 참조):
 *    - 자바의 2차원 배열은 사실 '배열의 배열'입니다.
 *    - 행(Row)을 가리키는 1차원 주소 배열이 존재하고, 각 행의 요소들이 다시 실제 데이터 배열의 주소를 가리키는 중첩 참조 구조를 이룹니다.
 * 
 * 3. 가변 배열 (Ragged Array):
 *    - 행마다 열의 크기를 다르게 생성할 수 있는 자바 다차원 배열만의 독특한 특징입니다.
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
