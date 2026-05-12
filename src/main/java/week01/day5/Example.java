package week01.day5;

import java.util.Scanner;

/**
 * [학습 예제] Week 01 Day 5 — Scanner 기초
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Week 01 Day 5 학습 예제 ===\n");

        System.out.println("--- Lab1: Scanner 객체 생성 ---");
        System.out.println("[설명] Scanner sc = new Scanner(System.in); 코드가 필요합니다.");

        System.out.println("--- Lab2: 문자열 입력 (next, nextLine) ---");
        // Lab2.run() 등은 실제 입력을 대기하므로 여기서는 구조만 설명하거나 
        // 주석으로 처리된 실행 예시를 보여줍니다.
        System.out.println("[설명] next()는 공백 전까지, nextLine()은 한 줄 전체를 읽습니다.");

        System.out.println("--- Lab3: 숫자 입력 (nextInt, nextDouble) ---");
        System.out.println("[설명] 정수는 nextInt(), 실수는 nextDouble()을 사용합니다.");

        System.out.println("--- Lab4: 입력 버퍼의 함정 ---");
        Lab4.run();

        System.out.println("--- Lab5: Scanner 닫기 ---");
        System.out.println("[설명] sc.close()로 자원을 반납합니다.");
    }

    static class Lab4 {
        static void run() {
            System.out.println("[해설] nextInt()를 쓴 뒤 nextLine()을 쓰면 엔터 키 값이 남아서 ");
            System.out.println("문자열 입력이 무시되는 경우가 있습니다. 이때는 sc.nextLine()을 한 번 더 써서 비워줘야 합니다.");
        }
    }
}
