package week02.day5;

/**
 * [학습 예제 2] Week 02 Day 5 — break와 continue 활용
 * 
 * [학습 핵심 이론: 반복 제어 실무 패턴]
 * 3. 중첩 반복문 이름(Label) 지정:
 *    - `outer:`와 같은 이름표를 사용해 내부 깊숙한 루프에서 바깥 루프 전체를 제어하는 고급 제어 흐름 기법을 실습합니다.
 * 
 * [문제별 학습 목표]
 * - Lab2: 레이블(Label) break
 */
public class Example2 {
    public static void main(String[] args) {
        System.out.println("--- Lab2: 레이블(Label) break ---");
        Lab2.run();
    }

    static class Lab2 {
        static void run() {
            outer:
            // 레이블 이름
            for (int i = 1; i <= 3; i++) {
                for (int j = 1; j <= 3; j++) {
                    if (i == 2 && j == 2) break outer; // 바깥쪽 루프까지 한 번에 탈출
                    System.out.println("i=" + i + ", j=" + j);
                }
            }
        }
    }
}
