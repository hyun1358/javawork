package week10.day1;

/**
 * [예습 파일] Week 10 Day 1 — 스레드(Thread) 기초
 */
public class Preview {
    public static void main(String[] args) {
        // 1. Thread 클래스를 상속받는 방식
        Thread t1 = new MyThread();

        // 2. Runnable 인터페이스를 구현하는 방식 (권장)
        Runnable r = () -> System.out.println("Runnable 스레드 실행!");
        Thread t2 = new Thread(r);

        t1.start(); // 스레드 시작
        t2.start();

        System.out.println("Main 스레드 끝");
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("상속받은 스레드 실행!");
    }
}
