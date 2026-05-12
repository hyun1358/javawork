package week05.day4;

/**
 * [학습 예제] Week 05 Day 4 — static vs instance
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Lab1: static 변수 공유 확인 ===");
        Counter c1 = new Calculator2().getCounter(); // 가상 시나리오
        Lab1.run();

        System.out.println("\n=== Lab2: static 메서드 제약 사항 ===");
        Lab2.run();
    }

    static class Lab1 {
        static void run() {
            Data d1 = new Data();
            Data d2 = new Data();
            d1.instanceVal = 10;
            Data.staticVal = 100;
            System.out.println("d2의 인스턴스 변수: " + d2.instanceVal); // 0 (개별적)
            System.out.println("d2가 보는 정적 변수: " + Data.staticVal); // 100 (공유됨)
        }
    }

    static class Lab2 {
        int x = 10;

        static void run() {
            // System.out.println(x); // 에러! static 메서드는 인스턴스 변수 접근 불가
            System.out.println("static 메서드는 메모리에 먼저 올라가 있어서 인스턴스 자원을 모릅니다.");
        }
    }
}

class Data {
    int instanceVal;
    static int staticVal;
}

class Calculator2 {
    public Counter getCounter() {
        return new Counter();
    }
}

class Counter {
}
