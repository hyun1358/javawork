package week02.day2;

import java.util.Scanner;

/**
 * [예습 파일] Week 02 Day 2 — switch 조건문
 * 
 * [핵심 개념: switch 분기문]
 * 1. switch문의 특징:
 *    - 하나의 변수 값에 따라 여러 경로(case)로 실행 흐름을 빠르고 명확하게 분기합니다.
 *    - 범위 비교(> , <)가 불가능하며, 값의 일치 여부(==)로만 판단합니다.
 *    - byte, short, char, int 타입의 정수형 변수와 String 및 Enum 타입만 지원합니다.
 * 
 * 2. break 키워드의 역할:
 *    - 현재 case의 실행이 완료되었음을 알리고 switch 블록을 강제로 탈출합니다.
 *    - break가 누락되면 아래의 case 블록들이 조건 일치 여부와 무관하게 차례로 실행되는 'Fall-through' 현상이 발생합니다.
 * 
 * 3. default 블록:
 *    - 어떤 case와도 값이 매칭되지 않는 경우 최종적으로 실행되는 예외 처리 블록입니다.
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
