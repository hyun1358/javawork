package week05.day4;

/**
 * [학습 예제 3] Week 05 Day 4 — static과 메모리 구조
 * 
 * [학습 핵심 이론: static 키워드와 클래스 멤버]
 * 3. static의 제약 조건:
 *    - static 멤버는 인스턴스가 생성되기 전에 이미 메모리에 올라가므로, 아직 메모리에 생성되지 않았을 수 있는 인스턴스 멤버(필드, 메서드)에 직접 접근할 수 없습니다.
 * 
 * [문제별 학습 목표]
 * - Lab3: static 메서드 내부에서 인스턴스 자원 접근 제약 (Problem 3 연계)
 */
public class Example3 {
    int instanceValue = 10; // 인스턴스 변수

    public static void main(String[] args) {
        System.out.println("[해설] static 메서드는 인스턴스화 이전에 로드되므로 인스턴스 변수(non-static)를 인식할 수 없습니다.");
        System.out.println("[해결책] 다음과 같이 객체를 먼저 명시적으로 생성하여 접근해야 합니다:");
        
        Example3 ex = new Example3();
        System.out.println("-> 객체 생성 후 접근한 인스턴스 값: " + ex.instanceValue);
    }
}
