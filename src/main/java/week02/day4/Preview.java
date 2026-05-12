package week02.day4;

import java.util.Scanner;

/**
 * [예습 파일] Week 02 Day 4 — while / do-while 반복문
 * <p>
 * ▶ 이 파일을 먼저 실행해보세요!
 * for 문이 '횟수'가 정해진 반복에 유리하다면,
 * while 문은 '조건'이 만족되는 동안 계속 반복할 때 유리합니다.
 */
public class Preview {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== 오늘 배울 내용 미리보기 ===");

        // 1. while 문 (1부터 5까지 출력)
        int i = 1;
        System.out.print("while 출력: ");
        while (i <= 5) {
            System.out.print(i + " ");
            i++;
        }
        System.out.println("\n");

        // 2. break 활용 (무한 루프 탈출)
        int count = 1;
        System.out.print("break 탈출: ");
        while (true) {
            System.out.print(count + " ");
            if (count == 3) break; // 3이 되면 탈출
            count++;
        }
        System.out.println("\n");

        // 3. do-while 문 (조건이 뒤에 있음)
        int num = 10;
        System.out.print("do-while 실행: ");
        do {
            System.out.println("조건이 틀려도 최소 한 번은 실행됩니다.");
        } while (num < 5);

        System.out.println("\n--- 미리보기 끝 ---");
        sc.close();
    }
}
