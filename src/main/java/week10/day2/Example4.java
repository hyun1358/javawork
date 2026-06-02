package week10.day2;

/**
 * [실습 4] volatile 플래그를 이용한 스레드 간 메모리 가시성 보장 (Problem 4 연계)
 * 
 * 비유: "개인 수첩 보지 말고, 벽에 걸린 진짜 칠판을 보고 일해라!"
 * CPU 캐시(개인 수첩)에 값이 저장되어 스레드가 메인 메모리(진짜 칠판)의 바뀐 중단 값을 알아차리지 못하는
 * '메모리 가시성' 문제를 volatile 키워드를 통해 강제로 메인 메모리만 읽게 하여 해결합니다.
 */
public class Example4 {
    static class VolatileFlag implements Runnable {
        // volatile이 없으면 CPU 캐시에 저장된 값을 계속 읽어 무한 루프에 빠질 수 있습니다.
        private volatile boolean stopRequested = false;

        public void requestStop() {
            stopRequested = true;
        }

        @Override
        public void run() {
            int count = 0;
            System.out.println("[작업 스레드] 시작합니다.");
            while (!stopRequested) {
                count++; // stopRequested가 true가 될 때까지 무한 루프
            }
            System.out.println("[작업 스레드] 정지 신호 수신 완료. 최종 루프 횟수: " + count);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("=== [실습 4] volatile 플래그를 이용한 스레드 간 메모리 가시성 보장 ===");
        VolatileFlag flagTask = new VolatileFlag();
        Thread worker = new Thread(flagTask);
        worker.start();

        Thread.sleep(100); // 메인 스레드 잠시 대기
        System.out.println("[메인 스레드] 작업 정지를 요청합니다.");
        flagTask.requestStop(); // stopRequested 플래그를 true로 변경
        
        worker.join(); // 메인 메모리에 가시성이 보장되어 작업 스레드가 즉시 종료됨을 확인
        System.out.println("[메인 스레드] 작업 스레드가 무사히 종료되었습니다.");
    }
}
