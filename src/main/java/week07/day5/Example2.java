package week07.day5;

/**
 * [학습 예제 2] Week 07 Day 5 — String 클래스와 효율적 가공
 * 
 * [문제별 학습 목표]
 * - Lab2: 특정 문자열의 등장 횟수 빈도 측정 (Problem 2 연계)
 */
public class Example2 {
    public static void main(String[] args) {
        System.out.println("\n--- Lab2: 특정 문자열의 등장 횟수 빈도 측정 (Problem 2 연계) ---");
        Lab2.run();
    }

    static class Lab2 {
        static void run() {
            // Problem 2: 문자열 안의 특정 문자 개수 카운트
            String str = "asdcdacdascdvasdxccsxcvfa";
            String target = "c";
            int count = 0;

            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                // 문자를 문자열로 변환하여 equals 비교
                if (String.valueOf(ch).equals(target)) {
                    count++;
                }
            }
            System.out.printf("대상 문자열: \"%s\"\n찾을 문자: '%s' | 총 개수: %d개\n", str, target, count);
        }
    }
}
