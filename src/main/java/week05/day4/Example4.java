package week05.day4;

/**
 * [학습 예제 4] Week 05 Day 4 — static과 메모리 구조
 * 
 * [학습 핵심 이론: static 키워드와 클래스 멤버]
 * 4. static 초기화 블록 (`static { }`):
 *    - 클래스가 최초로 메모리에 로드될 때 실행되며, 복잡한 static 필드 초기화에 적합합니다.
 * 
 * [문제별 학습 목표]
 * - Lab4: 클래스 최초 로드 시 실행되는 static 초기화 블록 (Problem 4 연계)
 */
public class Example4 {
    public static void main(String[] args) {
        System.out.println("--- 첫 번째 객체 생성 시도 ---");
        TestClass t1 = new TestClass();

        System.out.println("\n--- 두 번째 객체 생성 시도 ---");
        TestClass t2 = new TestClass(); // static 블록은 재실행되지 않음을 확인!
    }

    // Problem 4: static 초기화 블록 클래스
    static class TestClass {
        static {
            System.out.println("[static 블록] TestClass가 JVM에 처음 로드되었습니다. (한 번만 출력됨)");
        }

        TestClass() {
            System.out.println("[생성자] TestClass 인스턴스가 생성되었습니다.");
        }
    }
}
