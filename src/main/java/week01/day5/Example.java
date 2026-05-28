package week01.day5;

import java.util.Scanner;

/**
 * [학습 예제] Week 01 Day 5 — 입력 처리 (Scanner)와 입력 버퍼 문제 해결
 * 
 * [학습 핵심 이론: 자바의 표준 입력 처리]
 * 1. Scanner 클래스:
 *    - java.util 패키지에 속한 표준 입력 분석 도구로, 문자열, 정수, 실수 등 다양한 자료형으로 콘솔 입력을 안전하게 파싱하여 수집합니다.
 * 
 * 2. 주요 입력 메소드:
 *    - next(): 공백(스페이스, 탭, 엔터) 전까지의 하나의 단어 문자열을 읽습니다.
 *    - nextLine(): 줄바꿈(엔터)이 일어나기 전까지 한 줄 전체의 문자열을 읽습니다.
 *    - nextInt(): 정수형 데이터를 읽습니다.
 *    - nextDouble(): 실수형 데이터를 읽습니다.
 * 
 * 3. 입력 버퍼(Input Buffer)의 함정과 해결책:
 *    - `nextInt()`나 `nextDouble()` 등은 숫자를 파싱한 뒤, 사용자가 입력하고 누른 엔터 키(`\n` 개행 문자)를 입력 버퍼에 그대로 남겨둔 채 숫자값만 꺼내옵니다.
 *    - 그 뒤에 바로 `nextLine()`을 호출하면, 버퍼에 남아있던 엔터 키(`\n`)를 마치 사용자가 새로운 줄 입력을 마친 것으로 오인하여 그대로 빈 문자열을 수집하고 입력을 조기 종료시킵니다.
 *    - **해결책**: `nextInt()` 직후에 의미 없이 `sc.nextLine();`을 한 번 단독 호출해 주어 입력 버퍼에 꼬여 있는 엔터 키 값을 깨끗이 비워낸(Flush) 후, 진짜 원하는 `nextLine()` 입력을 호출해야 안전하게 처리됩니다.
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Week 01 Day 5 학습 예제 ===\n");

        System.out.println("--- Lab1: Scanner 객체 생성 ---");
        System.out.println("[설명] Scanner sc = new Scanner(System.in); 코드가 필요합니다.");

        System.out.println("--- Lab2: 문자열 입력 (next, nextLine) ---");
        System.out.println("[설명] next()는 공백 전까지, nextLine()은 한 줄 전체를 읽습니다.");

        System.out.println("--- Lab3: 숫자 입력 (nextInt, nextDouble) ---");
        System.out.println("[설명] 정수는 nextInt(), 실수는 nextDouble()을 사용합니다.");

        System.out.println("--- Lab4: 입력 버퍼의 함정 및 Flush 해결 ---");
        Lab4.run();

        System.out.println("--- Lab5: Scanner 닫기 ---");
        System.out.println("[설명] sc.close()로 자원을 반납합니다.");
    }

    static class Lab4 {
        static void run() {
            System.out.println("[해설] nextInt()를 쓴 뒤 nextLine()을 쓰면 엔터 키 값이 남아서 ");
            System.out.println("문자열 입력이 무시되는 경우가 있습니다. 이때는 sc.nextLine()을 중간에 한 번 써서 비워줘야 합니다.");
            System.out.println("예시 코드:");
            System.out.println("    int age = sc.nextInt();");
            System.out.println("    sc.nextLine(); // 버퍼 비우기 (개행문자 소모)");
            System.out.println("    String message = sc.nextLine(); // 이제 정상적으로 대기합니다.");
        }
    }
}
