package week02.day1;

import java.util.Scanner;

/*
 * [정답 + 해설 3] Week 02 Day 1
 * 문제: 점수별 학점(A~F) 출력
 */
public class Answer3 {
    public static void main(String[] args) {
        // else if 문은 위에서부터 아래로 조건을 하나씩 확인하며, 가장 먼저 참이 되는 블록만 실행합니다.
        // 따라서 조건의 범위가 겹칠 때는 좁은 범위나 가장 큰 수부터 비교하도록 작성해야 로직이 꼬이지 않습니다.
        Scanner sc = new Scanner(System.in);
        System.out.print("점수를 입력하세요: ");
        int score = sc.nextInt();

        if (score >= 90) {
            System.out.println("학점: A");
        } else if (score >= 80) {
            System.out.println("학점: B");
        } else if (score >= 70) {
            System.out.println("학점: C");
        } else if (score >= 60) {
            System.out.println("학점: D");
        } else {
            System.out.println("학점: F");
        }

        sc.close();
    }
}
/*
 * [해설]
 * - else if 문을 사용할 때 조건의 순서가 중요합니다.
 * - 큰 숫자부터 검사해야 의도한 대로 동작합니다. (예: 95점은 90↑ 조건에 먼저 걸림)
 */
