package week03.day5;

/**
 * [학습 예제 3] Week 03 Day 5 — Math API와 난수 생성
 * 
 * [학습 핵심 이론: Math 클래스와 난수(Random) 활용]
 * 2. Math.pow(base, exponent) & Math.sqrt(value):
 *    - `Math.pow(a, b)`: a의 b제곱을 계산하여 `double`로 반환합니다.
 *    - `Math.sqrt(a)`: a의 제곱근(루트)을 계산하여 `double`로 반환합니다.
 *    - 기하학적 계산(예: 피타고라스 정리를 이용한 두 점 사이의 거리)에 널리 활용됩니다.
 * 
 * [문제별 학습 목표]
 * - Lab3: 피타고라스 정리를 이용한 좌표 간 거리 측정 (Problem 3 연계)
 */
public class Example3 {
    public static void main(String[] args) {
        System.out.println("\n--- Lab3: 피타고라스 정리를 이용한 좌표 간 거리 측정 (Problem 3 연계) ---");
        Lab3.run();
    }

    static class Lab3 {
        static void run() {
            // Problem 3: 두 점 (0,0)과 (3,4) 사이의 직선 거리 구하기
            int x1 = 0, y1 = 0;
            int x2 = 3, y2 = 4;

            // 공식: sqrt((x2-x1)^2 + (y2-y1)^2)
            double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
            System.out.printf("점 (%d,%d)와 (%d,%d) 사이의 거리: %.2f\n", x1, y1, x2, y2, distance);
        }
    }
}
