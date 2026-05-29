package week10.day1;

// Runnable 인터페이스와 람다식을 이용한 스레드 구현 예제입니다.
public class Answer2 {
    public static void main(String[] args) {
        // Runnable 인터페이스의 run() 메서드를 람다식으로 구현하여 Thread 생성자에 전달합니다.
        Thread t = new Thread(() -> {
            // 1부터 5까지의 숫자를 "Runnable: 숫자" 형식으로 출력합니다.
            for (int i = 1; i <= 5; i++) System.out.println("Runnable: " + i);
        });
        // 생성된 스레드를 실행합니다.
        t.start();
    }
}
