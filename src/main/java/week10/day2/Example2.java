package week10.day2;

/**
 * [실습 2] synchronized 메서드를 적용한 스레드 안전 증가 연산 (Problem 2 연계)
 * 
 * 비유: "자물쇠(synchronized)가 적용된 공용 칠판 방"
 * 한 일꾼이 방에 들어가서 문을 잠그고 칠판의 숫자를 안전하게 1 증가시킨 뒤 나옵니다.
 * 대기하던 다른 일꾼은 자물쇠가 열려야만 들어가서 작업을 이어가므로 연산 유실이 생기지 않습니다.
 */
public class Example2 {
    static class Counter {
        private int count = 0;

        // synchronized 키워드를 붙여 메서드 전체에 자물쇠를 겁니다.
        public synchronized void synchronizedIncrement() {
            count++;
        }

        public int getCount() {
            return count;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("=== [실습 2] synchronized 메서드를 적용한 스레드 안전 증가 연산 ===");
        Counter safeCounter = new Counter();

        Runnable r = () -> {
            for (int i = 0; i < 1000; i++) {
                safeCounter.synchronizedIncrement(); // 자물쇠 잠긴 메서드 호출
            }
        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        
        t1.start();
        t2.start();
        
        t1.join();
        t2.join();

        System.out.println("기대 수치: 2000");
        System.out.println("synchronized 처리 결과: " + safeCounter.getCount() + " (안전)");
        System.out.println("-> 설명: 한 번에 한 일꾼씩 문을 잠그고 숫자를 증가시켰으므로 정확하게 2000이 출력됩니다.");
    }
}
