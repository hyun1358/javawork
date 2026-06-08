package week05.day5;

/**
 * [학습 예제 4] Week 05 Day 5 — final 키워드와 불변 설계
 * 
 * [학습 핵심 이론: final 제약 조건을 활용한 안전성 극대화]
 * 5. final 매개변수:
 *    - 메서드 내부에서 인자로 넘어온 변수 값을 임의로 덮어씌워 유실하거나 오염시키는 실수를 컴파일 타임에 철저히 방지합니다.
 * 
 * [문제별 학습 목표]
 * - Lab4: final 매개변수 재할당 제약 및 컴파일 에러 원인 (Problem 4 연계)
 */
public class Example4 {
    public static void main(String[] args) {
        System.out.println("[매개변수 final 제약 설명]");
        printAge(25);
    }

    static void printAge(final int age) {
        // age = 30; // [컴파일 에러!] final 매개변수 age는 메서드 바디 내부에서 다시 대입(Reassign)될 수 없습니다.
        System.out.println("전달받은 안전한 나이 값: " + age);
    }
}
