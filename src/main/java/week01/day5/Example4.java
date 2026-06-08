package week01.day5;

/**
 * [학습 예제 4] Week 01 Day 5 — 입력 처리 (Scanner)와 입력 버퍼 문제 해결
 * 
 * [학습 핵심 이론: 자바의 표준 입력 처리]
 * 3. 입력 버퍼(Input Buffer)의 함정과 해결책:
 *    - `nextInt()`나 `nextDouble()` 등은 숫자를 파싱한 뒤, 사용자가 입력하고 누른 엔터 키(`\n` 개행 문자)를 입력 버퍼에 그대로 남겨둔 채 숫자값만 꺼내옵니다.
 *    - 그 뒤에 바로 `nextLine()`을 호출하면, 버퍼에 남아있던 엔터 키(`\n`)를 마치 사용자가 새로운 줄 입력을 마친 것으로 오인하여 그대로 빈 문자열을 수집하고 입력을 조기 종료시킵니다.
 *    - **해결책**: `nextInt()` 직후에 의미 없이 `sc.nextLine();`을 한 번 단독 호출해 주어 입력 버퍼에 꼬여 있는 엔터 키 값을 깨끗이 비워낸(Flush) 후, 진짜 원하는 `nextLine()` 입력을 호출해야 안전하게 처리됩니다.
 * 
 * [문제별 학습 목표]
 * - Lab4: 입력 버퍼의 함정 및 Flush 해결
 */
public class Example4 {
    public static void main(String[] args) {
        System.out.println("--- Lab4: 입력 버퍼의 함정 및 Flush 해결 ---");
        Lab4.run();
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
