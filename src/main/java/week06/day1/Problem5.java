package week06.day1;

/**
 * [연습 문제 5] 3단계 상속 계층
 * 문제: A -> B -> C 순서로 상속받는 3단계 계층 클래스를 만들고 동작을 확인하세요.
 */
public class Problem5 {
    public static void main(String[] args) {
        // TODO: 구현
        C c = new C();
        c.methodA();
        c.methodB();
        c.methodC();
    }

    static class A {
        void methodA() {
            System.out.println("메소드A");
        }
    }

    static class B extends A {
        void methodB() {
            System.out.println("메소드B");
        }
    }

    static class C extends B {
        void methodC() {
            System.out.println("메소드C");
        }
    }
}
