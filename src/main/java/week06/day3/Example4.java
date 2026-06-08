package week06.day3;

/**
 * [학습 예제 4] Week 06 Day 3 — 다형성(Polymorphism)의 심화
 * 
 * [학습 핵심 이론: 다형적 형변환과 런타임 바인딩]
 * 3. 다운캐스팅 (Downcasting):
 *    - 힙의 실제 객체가 해당 자식 타입이 아닐 때 다운캐스팅하면 `ClassCastException`이 일어나며 프로그램이 크래시됩니다.
 * 
 * [문제별 학습 목표]
 * - Lab4: 잘못된 형변환 시 발생하는 ClassCastException 실습 (Problem 4 연계)
 */
public class Example4 {
    public static void main(String[] args) {
        Parents p = new Parents(); // 실제 힙 객체가 부모임
        
        try {
            System.out.println("의도적으로 잘못된 다운캐스팅을 시도합니다...");
            Child c = (Child) p; // ClassCastException 발생!
        } catch (ClassCastException e) {
            System.out.println("예외 포착 성공: " + e.toString());
            System.out.println("-> [해설] 힙 객체(Parents)는 자식의 메모리 구조를 갖추지 않았으므로 강제 형변환하면 다운됩니다.");
        }
    }

    static class Parents {}
    static class Child extends Parents {}
}
