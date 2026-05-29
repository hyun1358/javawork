package week10.day2;

/**
 * 멀티스레드 환경에서 동기화 처리 없이 공유 변수를 수정할 때 발생할 수 있는 문제를 보여주는 예제입니다.
 */
public class Answer1 {
    // 여러 스레드가 동시에 접근할 공유 변수입니다.
    static int cnt = 0;

    public static void main(String[] args) throws Exception {
        // Runnable 객체를 생성하여, 1000번 반복하면서 공유 변수 cnt를 1씩 증가시키는 작업을 정의합니다.
        Runnable r = () -> {
            for (int i = 0; i < 1000; i++) cnt++;
        };
        
        // 두 개의 스레드 t1과 t2를 생성하고 시작합니다.
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
        
        // 메인 스레드가 t1, t2의 실행이 끝날 때까지 대기합니다.
        t1.join();
        t2.join();
        
        // 두 스레드가 동시에 cnt++를 실행하면서 경쟁 상태(Race Condition)가 발생하여
        // 2000이 되지 않을 수 있음을 확인하는 출력문입니다.
        System.out.println("2000이 아닐 수 있음: " + cnt);
    }
}
