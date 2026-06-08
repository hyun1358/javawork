package week06.day3;

/**
 * [학습 예제 3] Week 06 Day 3 — 다형성(Polymorphism)의 심화
 * 
 * [학습 핵심 이론: 다형적 형변환과 런타임 바인딩]
 * 3. 다운캐스팅 (Downcasting)과 instanceof 안전 장치:
 *    - 부모 타입 참조 변수를 자식 고유의 속성/메서드를 사용하기 위해 다시 자식 타입으로 돌려놓는 수동 형변환입니다.
 *    - 항상 `instanceof` 연산자로 힙 인스턴스 형식을 확인한 뒤 캐스팅을 실행하는 것이 철칙입니다.
 * 
 * [문제별 학습 목표]
 * - Lab3: instanceof 안전망을 이용한 안정적인 다운캐스팅 (Problem 3 연계)
 */
public class Example3 {
    public static void main(String[] args) {
        Parents p = new Child();
        
        // instanceof 안전하게 검증
        if (p instanceof Child) {
            Child c = (Child) p; // 안전한 다운캐스팅
            c.childSpecial();    // 자식 고유 메서드 호출 성공
        }
    }

    static class Parents {
        void info() { System.out.println("부모"); }
    }

    static class Child extends Parents {
        void childSpecial() {
            System.out.println("-> [자식 전용 기능] 자식 고유의 특수한 메서드를 실행합니다.");
        }
    }
}
