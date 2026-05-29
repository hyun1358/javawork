package week10.day2;

/**
 * synchronized 키워드를 사용하여 메서드 동기화를 처리하고,
 * 스레드 안전성(Thread Safety)을 확보하는 예제입니다.
 */
public class Answer2 {
    // 공유 변수
    static int cnt = 0;

    // synchronized 키워드를 붙여 한 번에 하나의 스레드만 이 메서드를 실행할 수 있도록 보장합니다.
    public static synchronized void inc() {
        cnt++;
    }

    public static void main(String[] args) throws Exception {
        // Runnable 객체를 생성하여, 1000번 반복하면서 동기화된 inc() 메서드를 호출하도록 합니다.
        Runnable r = () -> {
            for (int i = 0; i < 1000; i++) inc();
        };
        
        // 스레드 두 개를 생성하고 시작합니다.
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
        
        // 메인 스레드가 t1, t2의 종료를 기다립니다.
        t1.join();
        t2.join();
        
        // 동기화 처리가 되어 있으므로 데이터 유실 없이 항상 2000이 출력됩니다.
        System.out.println("항상 2000 보장: " + cnt);
    }
}
