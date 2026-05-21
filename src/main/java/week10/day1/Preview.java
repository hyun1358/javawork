package week10.day1;

/**
 * [예습 파일] Week 10 Day 1 — 스레드(Thread) 기초
 * 
 * 지금까지의 자바 코드는 한 사람이 일하는 것처럼 '순서대로' 하나씩만 처리했습니다.
 * 스레드는 '일꾼'입니다. 멀티 스레드를 쓰면 여러 일꾼이 '동시에' 일을 처리할 수 있습니다.
 * 
 * [스레드 만드는 2가지 방법]
 * 1. Thread 클래스 상속 : 일꾼 자체를 새로 만드는 방식.
 * 2. Runnable 인터페이스 구현 : 일꾼에게 줄 '업무 리스트'를 만드는 방식. (권장)
 */
public class Preview {
    public static void main(String[] args) {
        System.out.println("Main 일꾼: 작업 시작!");

        // 1. Thread 클래스를 상속받는 방식
        Thread t1 = new MyThread();

        // 2. Runnable 인터페이스를 구현하는 방식 (람다식 사용)
        // () -> { 코드 } 형태로 업무를 정의합니다.
        Runnable task = () -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("Runnable 일꾼: 열일 중... (" + i + ")");
            }
        };
        Thread t2 = new Thread(task);

        // [주의] run()이 아니라 start()를 호출해야 '동시 실행'이 시작됩니다!
        t1.start(); 
        t2.start();

        System.out.println("Main 일꾼: 내 할 일 끝!");
    }
}

/**
 * 일꾼 클래스 정의
 */
class MyThread extends Thread {
    @Override
    public void run() {
        // 이 안의 내용이 스레드가 실제로 할 일입니다.
        System.out.println("상속 일꾼: 나도 시작합니다!");
    }
}
