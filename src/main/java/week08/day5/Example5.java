package week08.day5;

/**
 * [학습 예제 5] Week 08 Day 5 — 제네릭(Generics) 심화와 와일드카드
 * 
 * [학습 핵심 이론: 컴파일 타임 타입 안전성 보장 - 제네릭]
 * 4. 타입 파라미터 네이밍 관례:
 *    - `T`: Type (가장 일반적인 자료형 지칭)
 *    - `E`: Element (ArrayList 등 컬렉션 요소 지칭)
 *    - `K`: Key (Map의 Key 지칭)
 *    - `V`: Value (Map의 Value 지칭)
 *    - `N`: Number (숫자 전용 지칭)
 * 
 * [문제별 학습 목표]
 * - Lab5: 제네릭 타입 파라미터 표준 네이밍 관례 설명 (Problem 5 연계)
 */
public class Example5 {
    public static void main(String[] args) {
        System.out.println("\n--- Lab5: 제네릭 타입 파라미터 표준 네이밍 관례 설명 (Problem 5 연계) ---");
        Lab5.run();

        System.out.println("\n--- Lab6: Bounded Type Parameter <T extends Number> (보너스) ---");
        Lab6.run();
    }

    // Lab6: 제한된 타입 매개변수 클래스
    static class NumberBox<T extends Number> {
        private T number;
        NumberBox(T n) { this.number = n; }
        public double doubleValue() { return number.doubleValue(); }
    }

    static class Lab5 {
        static void run() {
            System.out.println("[제네릭 타입 파라미터 표준 네이밍 관례]");
            System.out.println("1. <T> (Type): 클래스나 인터페이스 설계 시 가장 일반적인 가상 타입 선언");
            System.out.println("2. <E> (Element): 리스트, 셋 등 컬렉션 요소의 타입 지정");
            System.out.println("3. <K, V> (Key, Value): 맵 등 키-밸류 쌍의 타입으로 매핑 지정");
            System.out.println("4. <N> (Number): 숫자형 기본 클래스 제약에 주로 지정");
        }
    }

    static class Lab6 {
        static void run() {
            // NumberBox는 Number 계열(Double, Integer 등)만 가능합니다.
            NumberBox<Double> dBox = new NumberBox<>(3.14);
            System.out.println("NumberBox 값 꺼내기 (doubleValue): " + dBox.doubleValue());
        }
    }
}
