package week10.day1;

// 스레드(Thread)를 상속받아 구현하는 기본 예제 클래스입니다.
public class Answer1 {
    public static void main(String[] args) {
        // NumThread 객체를 생성하고 start() 메서드를 호출하여 새로운 스레드를 실행합니다.
        new NumThread().start();
    }
}

// Thread 클래스를 상속받아 사용자 정의 스레드를 만듭니다.
class NumThread extends Thread {
    // 스레드가 실행할 작업을 run() 메서드에 재정의(Override)합니다.
    public void run() {
        // 1부터 5까지의 숫자를 순차적으로 출력합니다.
        for (int i = 1; i <= 5; i++) System.out.println(i);
    }
}
