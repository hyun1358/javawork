package week02.day4;

/**
 * [학습 예제 5] Week 02 Day 4 — while / do-while 반복문 및 루프 제어
 * 
 * [학습 핵심 이론: 조건에 따라 유연하게 반복하는 while 루프]
 * 3. 무한 루프(Infinite Loop) 방지:
 *    - while(true) 구문 사용 시 내부에서 반드시 특정 조건을 충족하면 루프를 탈출시키는 break 장치가 존재해야 메모리 고갈을 방지할 수 있습니다.
 * 
 * [문제별 학습 목표]
 * - Lab5: 무한 루프와 탈출
 */
public class Example5 {
    public static void main(String[] args) {
        System.out.println("--- Lab5: 무한 루프와 탈출 ---");
        System.out.println("\n[해설] while(true)는 의도적으로 무한 반복을 시킬 때 사용하며, 내부에 반드시 종료 조건(if+break)이 있어야 합니다.");
    }
}
