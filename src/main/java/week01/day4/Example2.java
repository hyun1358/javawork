package week01.day4;

/**
 * [학습 예제 2] Week 01 Day 4 — 형변환 (Casting)과 데이터 파싱
 * 
 * [학습 핵심 이론: 데이터 타입 변환 매커니즘]
 * 2. 강제 형변환 (Explicit Casting / Demotion):
 *    - 큰 크기의 자료형에서 작은 크기의 자료형으로 강제로 변환할 때 씁니다.
 *    - 소괄호 안에 대상 자료형을 직접 지정합니다: (int) doubleValue
 *    - 변환 시 메모리 비트의 상위 바이트가 잘려 나가므로 '데이터 왜곡' 또는 '소수점 절삭' 등의 값 손실(Overflow/Truncation)이 발생합니다.
 * 
 * [문제별 학습 목표]
 * - Lab2: 강제 형변환 (Casting)
 */
public class Example2 {
    public static void main(String[] args) {
        System.out.println("--- Lab2: 강제 형변환 (Casting) ---");
        Lab2.run();
        System.out.println("\n[해설] 데이터 손실 가능성이 있을 때 (자료형)을 명시하여 강제로 바꿉니다.");
    }

    static class Lab2 {
        static void run() {
            double d = 3.99;
            int i = (int) d; // 3으로 소수점 절삭
            System.out.println("double 3.99 -> int: " + i);
        }
    }
}
