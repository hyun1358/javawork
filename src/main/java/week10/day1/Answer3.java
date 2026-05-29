package week10.day1;

// 하나의 Runnable 객체를 여러 스레드가 공유하며 실행하는 예제입니다.
public class Answer3 {
    public static void main(String[] args) {
        // 현재 실행 중인 스레드의 이름을 출력하는 Runnable 객체를 생성합니다.
        Runnable r = () -> System.out.println("현재 스레드: " + Thread.currentThread().getName());
        
        // 동일한 Runnable 객체 r을 사용하여 세 개의 스레드를 생성하고, 각각의 이름을 지정하여 실행합니다.
        new Thread(r, "Thread-A").start();
        new Thread(r, "Thread-B").start();
        new Thread(r, "Thread-C").start();
    }
}
