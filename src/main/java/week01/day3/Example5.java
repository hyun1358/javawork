package week01.day3;

/**
 * [학습 예제 5] Week 01 Day 3 — 연산자 종합
 * 
 * [학습 핵심 이론: 자바의 연산자 체계]
 * 2. 증감 연산자 (Increment/Decrement Operators):
 *    - 전위 증감 (++a, --a): 변수의 값을 먼저 1 증가/감소시킨 후, 해당 라인의 연산에 반영합니다.
 *    - 후위 증감 (a++, a--): 현재 변수 값을 연산에 먼저 사용한 후, 해당 라인의 실행이 끝나면 값을 1 증가/감소시킵니다.
 * 
 * [문제별 학습 목표]
 * - Lab5: 증감 연산자 (++, --)
 */
public class Example5 {
    public static void main(String[] args) {
        System.out.println("--- Lab5: 증감 연산자 (++, --) ---");
        Lab5.run();
        System.out.println("\n[해설] ++이 앞에 붙으면(전위) 증가 후 사용, 뒤에 붙으면(후위) 사용 후 증가합니다.");
    }

    static class Lab5 {
        static void run() {
            int i = 1;
            System.out.println("++i : " + (++i)); // 2
            System.out.println("i++ : " + (i++)); // 2 (출력 후 3이 됨)
            System.out.println("최종 i: " + i);
        }
    }
}
