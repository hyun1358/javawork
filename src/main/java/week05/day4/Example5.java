package week05.day4;

/**
 * [학습 예제 5] Week 05 Day 4 — static과 메모리 구조
 * 
 * [학습 핵심 이론: static 키워드와 클래스 멤버]
 * 5. 싱글톤 패턴 (Singleton Pattern):
 *    - 시스템 전체에서 단 하나의 인스턴스만 보장하도록 하는 핵심 디자인 패턴입니다.
 * 
 * [문제별 학습 목표]
 * - Lab5: 싱글톤(Singleton) 패턴의 올바른 설계 및 테스트 (Problem 5 연계)
 */
public class Example5 {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        System.out.println("s1의 주소: " + s1);
        System.out.println("s2의 주소: " + s2);

        if (s1 == s2) {
            System.out.println("결과: 두 변수는 물리적으로 완벽히 동일한 메모리 주소를 가리킵니다. (싱글톤 성공)");
        }
    }

    // Problem 5: Singleton 패턴 구현
    static class Singleton {
        // 1. 클래스 로드 시점에 단 하나의 인스턴스를 static 영역에 미리 생성
        private static final Singleton INSTANCE = new Singleton();

        // 2. 생성자를 private으로 통제하여 외부에서 new 호출을 차단
        private Singleton() {
            System.out.println("-> 싱글톤 인스턴스가 생성되었습니다.");
        }

        // 3. 외부에서는 오직 이 static 메서드를 통해서만 공유 인스턴스를 가져가게 함
        public static Singleton getInstance() {
            return INSTANCE;
        }
    }
}
