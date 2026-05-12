package week02.day2;

import java.util.Scanner;

/**
 * [예습 파일] Week 02 Day 2 — switch 문
 * <p>
 * ▶ 이 파일을 먼저 실행해보세요!
 * if 문이 복잡해질 때, switch 문을 쓰면 코드가 훨씬 깔끔해집니다.
 * 자바 14부터 추가된 새로운 switch 표현식도 구경해보세요.
 */
public class Preview {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== 오늘 배울 내용 미리보기 ===");

        // 1. 기존 switch 문 (정수 비교)
        int ranking = 1;
        switch (ranking) {
            case 1:
                System.out.println("금메달");
                break;
            case 2:
                System.out.println("은메달");
                break;
            case 3:
                System.out.println("동메달");
                break;
            default:
                System.out.println("참가상");
        }

        // 2. 새로운 switch 표현식 (Java 14+)
        String medal = switch (ranking) {
            case 1 -> "Gold";
            case 2 -> "Silver";
            case 3 -> "Bronze";
            default -> "None";
        };
        System.out.println("Medal: " + medal);

        System.out.println("--- 미리보기 끝 ---");
        sc.close();
    }
}
