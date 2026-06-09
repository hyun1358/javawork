package week11.day2;

import java.util.Arrays;

/**
 * [학습 예제 1] Week 11 Day 2 — 전략 패턴 & 옵저버 패턴 완전 정복
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 1] 전략 패턴 (Strategy Pattern)
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - 알고리즘(행동)을 인터페이스로 추상화하여, 런타임에 교체 가능하게 설계
 *  - Context 클래스는 Strategy 인터페이스만 알고, 구체 구현은 모름
 *
 * [문제별 학습 목표]
 * - 문제 1: 전략 패턴 — Sorter 에 오름차순/내림차순 전략 주입
 */
public class Example1 {
    public static void main(String[] args) {
        // ─────────────────────────────────────────────
        // Lab 1: 전략 패턴 — 정렬 전략 (→ 문제 1 참고)
        // ─────────────────────────────────────────────
        System.out.println("=== Lab 1: 전략 패턴 — Sorter ===");
        int[] data = {5, 2, 8, 1, 9, 3};

        Sorter sorter = new Sorter();

        // 오름차순 전략 주입
        sorter.setStrategy(new AscendingSort());
        sorter.sort(data);
        System.out.println("오름차순: " + Arrays.toString(data));

        // 내림차순 전략으로 교체
        sorter.setStrategy(new DescendingSort());
        sorter.sort(data);
        System.out.println("내림차순: " + Arrays.toString(data));
    }

    // ─── 전략 패턴: 정렬 ───────────────────────────────────
    interface SortStrategy {
        void sort(int[] arr);
    }

    static class AscendingSort implements SortStrategy {
        public void sort(int[] arr) { Arrays.sort(arr); }
    }

    static class DescendingSort implements SortStrategy {
        public void sort(int[] arr) {
            Arrays.sort(arr);
            // 배열 뒤집기
            for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
    }

    static class Sorter {
        private SortStrategy strategy;

        public void setStrategy(SortStrategy s) { this.strategy = s; }

        public void sort(int[] arr) { strategy.sort(arr); }
    }
}
