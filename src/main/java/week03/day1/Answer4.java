package week03.day1;

import java.util.Scanner;

/*
 * [정답 + 해설 4] Week 03 Day 1
 * 문제: 배열에 특정 값이 있는지 찾기
 */
public class Answer4 {
    // 메인 메서드: 배열에서 특정 값이 존재하는지 탐색
    public static void main(String[] args) {
        // 검색 대상이 될 정수 배열 초기화
        int[] arr = {10, 20, 30, 40, 50};
        
        // 사용자 입력을 받기 위해 Scanner 객체 생성
        Scanner sc = new Scanner(System.in);
        System.out.print("찾을 숫자 입력: ");
        // 사용자가 입력한 숫자를 target 변수에 저장
        int target = sc.nextInt();

        // 찾았는지 여부를 기록하기 위한 불리언 변수, 기본값은 false
        boolean found = false; // 발견 여부 저장용

        // 배열의 첫 번째 요소부터 마지막 요소까지 순차 탐색
        for (int i = 0; i < arr.length; i++) {
            // 현재 요소가 찾고자 하는 값(target)과 일치하는지 확인
            if (arr[i] == target) {
                // 일치하는 값을 찾으면 found를 true로 변경
                found = true;
                // 값을 찾았으므로 더 이상 반복할 필요 없이 루프 종료
                break; // 찾았으면 더 돌지 않고 탈출
            }
        }

        // 탐색 결과에 따라 적절한 메시지 출력
        if (found) {
            System.out.println(target + "은(는) 배열에 있습니다.");
        } else {
            System.out.println(target + "은(는) 배열에 없습니다.");
        }

        // 사용이 끝난 Scanner 자원 해제
        sc.close();
    }
}
/*
 * [해설]
 * - '순차 탐색(Sequential Search)'의 기본 원리입니다.
 * - 처음부터 끝까지 돌며 값이 일치하는지 확인합니다.
 * - found라는 변수를 사용해 '발견 여부'를 저장해두는 방식은 아주 흔히 쓰입니다.
 * - break를 사용해 불필요한 연산을 줄이는 습관도 중요합니다.
 */
