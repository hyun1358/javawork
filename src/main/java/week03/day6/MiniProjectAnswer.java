package week03.day6;

import java.util.Arrays;
import java.util.Scanner;

/**
 * [미니 프로젝트 정답] Week 03 Day 6 — 로또 시뮬레이터
 */
public class MiniProjectAnswer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. 당첨 번호 생성 (중복 제거)
        int[] winNums = new int[6];
        for (int i = 0; i < 6; i++) {
            winNums[i] = (int) (Math.random() * 45) + 1;
            for (int j = 0; j < i; j++) { // 중복 체크
                if (winNums[i] == winNums[j]) {
                    i--;
                    break;
                }
            }
        }
        Arrays.sort(winNums); // 정렬

        // 2. 내 번호 입력
        int[] myNums = new int[6];
        System.out.println("6개의 로또 번호를 입력하세요 (1~45):");
        for (int i = 0; i < 6; i++) {
            System.out.printf("%d번째 번호: ", i + 1);
            myNums[i] = sc.nextInt();
        }

        // 3. 일치 개수 판별
        int matchCount = 0;
        for (int my : myNums) {
            for (int win : winNums) {
                if (my == win) {
                    matchCount++;
                    break;
                }
            }
        }

        // 4. 결과 출력
        System.out.println("\n--- 결과 발표 ---");
        System.out.println("당첨 번호: " + Arrays.toString(winNums));
        System.out.println("내 번호  : " + Arrays.toString(myNums));
        System.out.println("일치 개수: " + matchCount);

        switch (matchCount) {
            case 6 -> System.out.println("축하합니다! 1등입니다!");
            case 5 -> System.out.println("축하합니다! 2등입니다!");
            case 4 -> System.out.println("축하합니다! 3등입니다!");
            case 3 -> System.out.println("축하합니다! 4등입니다!");
            default -> System.out.println("아쉽지만 꽝입니다.");
        }

        sc.close();
    }
}
