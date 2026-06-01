package week10.day1;

/**
 * [보충 문제 4_1 정답 가이드]
 * 
 * 핵심 포인트:
 * 1. 각 스레드(Thread A, Thread B)가 자신의 run() 블록 내에서 Thread.sleep()을 호출하여 독립적으로 대기합니다.
 * 2. t1.start()와 t2.start()를 차례로 호출하여 두 스레드를 비동기(병렬)로 동시에 작동시킵니다.
 * 3. 메인 스레드에서 t1.join()과 t2.join()을 각각 호출하여 모든 스레드가 끝날 때까지 대기합니다.
 */
public class Answer4_1 {
    public static void main(String[] args) {
        // 1. 스레드 A 정의 및 생성 (Runnable 람다 활용)
        Thread threadA = new Thread(() -> {
            try {
                // 스레드 A 전용 작업 영역(run 블록) 내에서 500ms(0.5초) 동안 잠들게 합니다.
                Thread.sleep(500);
                System.out.println("Thread A 완료");
            } catch (InterruptedException e) {
                System.out.println("Thread A 슬립 중 오류 발생");
            }
        });

        // 2. 스레드 B 정의 및 생성 (Runnable 람다 활용)
        Thread threadB = new Thread(() -> {
            try {
                // 스레드 B 전용 작업 영역(run 블록) 내에서 1000ms(1.0초) 동안 잠들게 합니다.
                Thread.sleep(1000);
                System.out.println("Thread B 완료");
            } catch (InterruptedException e) {
                System.out.println("Thread B 슬립 중 오류 발생");
            }
        });

        System.out.println("메인 작업 시작 - 스레드 A & B 출발");

        // 3. 두 스레드를 순차적으로 실행하여 병렬(비동기) 처리를 유도합니다.
        threadA.start();
        threadB.start();

        try {
            // 4. 메인 스레드는 threadA의 완료를 기다립니다.
            threadA.join();
            // 5. 메인 스레드는 threadB의 완료를 기다립니다.
            threadB.join();
        } catch (InterruptedException e) {
            System.out.println("메인 스레드 대기 중 에러 발생");
        }

        // 6. 모든 자식 스레드가 종료되었으므로, 메인의 마지막 메시지가 출력됩니다.
        System.out.println("모든 스레드 작업 종료!");
    }
}
