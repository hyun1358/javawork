package week04.day3;

/**
 * [학습 예제 3] Week 04 Day 3 — 오버로딩(Overloading)의 상세 규칙
 * 
 * [학습 핵심 이론: 컴파일러의 오버로딩 결정 순서]
 * - 단계 1: 실인자(Arguments) 타입과 100% 동일한 선언을 가진 메서드를 찾습니다.
 * - 단계 3: 여전히 매칭되는 것이 없으면 가변 인자(Varargs) 메서드를 매칭합니다.
 * 
 * [문제별 학습 목표]
 * - Lab3: 가변 인자 vs 구체적인 오버로딩의 매칭 우선순위 (Problem 3 연계)
 */
public class Example3 {
    public static void main(String[] args) {
        // Problem 3: add(int, int)와 add(int... nums)가 둘 다 있을 때 호출 매칭 테스트
        // 컴파일러는 가변 인자보다 구체적으로 매칭되는 일반 메서드를 우선 선택합니다!
        int resultExact = add(1, 2);
        int resultVarargs = add(1, 2, 3, 4, 5);

        System.out.println("add(1, 2) 호출 결과: " + resultExact + " [add(int, int) 실행됨]");
        System.out.println("add(1, 2, 3, 4, 5) 호출 결과: " + resultVarargs + " [add(int...) 실행됨]");
    }

    static int add(int a, int b) {
        return a + b;
    }

    static int add(int... nums) {
        int sum = 0;
        for (int n : nums) sum += n;
        return sum;
    }
}
