package week02.day1;

/**
 * [학습 예제 5] Week 02 Day 1 — IF 조건문 기초
 * 
 * [문제별 학습 목표]
 * - Lab5: 조건식 단순화
 */
public class Example5 {
    public static void main(String[] args) {
        System.out.println("--- Lab5: 조건식 단순화 ---");
        Lab5.run();
        System.out.println("\n[해설] boolean 타입 변수는 '== true' 없이 변수명 자체로 조건식에 쓸 수 있습니다.");
    }

    static class Lab5 {
        static void run() {
            boolean isRainy = true;
            // if (isRainy == true) 보다는 아래 형식이 권장됩니다.
            if (isRainy) {
                System.out.println("우산을 챙기세요.");
            }
        }
    }
}
