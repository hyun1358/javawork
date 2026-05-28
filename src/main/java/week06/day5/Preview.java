package week06.day5;

/**
 * [예습 파일] Week 06 Day 5 — 인터페이스 (interface)
 * 
 * [핵심 개념: 표준 규격서와 다중 구현]
 * 1. 인터페이스(Interface)의 성격:
 *    - 추상 클래스보다 훨씬 극단적으로 추상화된, 오직 '규격(Specification)'만을 규정하는 완전한 약속판입니다.
 * 
 * 2. 인터페이스 멤버의 자동 키워드 주입:
 *    - 변수: 모든 변수는 컴파일러에 의해 자동으로 `public static final`이 되어 상수가 됩니다.
 *    - 메서드: 모든 일반 메서드는 자동으로 `public abstract`가 붙어 추상 메서드이 됩니다.
 * 
 * 3. 다중 구현 (Multiple Implements)의 특권:
 *    - 단일 상속만 허용하는 일반 클래스와 달리, 자바의 클래스는 쉼표(,)를 구분자로 사용하여 여러 인터페이스를 한꺼번에 다중 구현(`implements A, B, C`)할 수 있어 상속 계층과 상관없는 공통 역할 부여에 압도적입니다.
 */
public class Preview {
    public static void main(String[] args) {
        Flyable f = new Bird();
        f.fly();
    }
}

interface Flyable {
    void fly(); // public abstract 자동 생략
}

class Bird implements Flyable {
    @Override
    public void fly() {
        System.out.println("새가 납니다.");
    }
}
