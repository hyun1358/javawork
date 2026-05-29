package week03.day1;

/*
 * [정답 + 해설 3] Week 03 Day 1
 * 문제: 배열 원소 역순으로 출력
 */
public class Answer3 {
    // 메인 메서드: 배열 요소를 역순으로 출력
    public static void main(String[] args) {
        // 1부터 5까지의 정수를 담은 배열 생성
        int[] arr = {1, 2, 3, 4, 5};

        // 1. 역순 출력을 위해 인덱스를 length-1부터 0까지 감소시킵니다.
        // 배열의 마지막 인덱스(길이 - 1)부터 시작하여 0까지 역순으로 순회
        for (int i = arr.length - 1; i >= 0; i--) {
            // 각 요소를 공백으로 구분하여 한 줄에 출력
            System.out.print(arr[i] + " ");
        }
    }
}
/*
 * [해설]
 * - 배열의 '마지막 인덱스'는 '배열의 길이 - 1'입니다. (0부터 시작하기 때문)
 * - 초기값을 arr.length - 1로 설정하고, 조건식을 i >= 0, 증감식을 i--로 설정하면
 *   거꾸로 순회할 수 있습니다.
 */
