package week10.day2;

/**
 * [실습 1] 스레드 안전하지 않은 공유 변수 경쟁 조건 재현 (Problem 1 연계)
 * 
 * 비유: "자물쇠(synchronized)가 없는 공용 칠판 방"
 * 두 일꾼(스레드)이 칠판에 적힌 숫자를 동시에 보고 동시에 1을 더해 고쳐 적으려다 보니,
 * 서로의 작업 결과가 덮어씌워져 연산 횟수가 씹히는 현상을 재현합니다.
 */
public class Example1 {
    static class Counter {
        private int count = 0;

        // 비동기화 메서드 (자물쇠 없음 - 경쟁 조건 발생)
        public void increment() {
            count++; // CPU 수준에서는 [읽고 -> 더하고 -> 쓰기]의 3단계로 이루어짐
        }

        public int getCount() {
            return count;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("=== [실습 1] 스레드 안전하지 않은 공유 변수 경쟁 조건 재현 ===");
        Counter unsafeCounter = new Counter();

        // 1000번씩 숫자를 더하는 작업 정의
        Runnable r = () -> {
            for (int i = 0; i < 1000; i++) {
                unsafeCounter.increment();
            }
        };

        // 두 명의 일꾼(스레드)을 고용합니다.
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        
        t1.start(); // 일꾼 A 일 시작
        t2.start(); // 일꾼 B 일 시작
        
        t1.join();  // 일꾼 A가 끝날 때까지 대기
        t2.join();  // 일꾼 B가 끝날 때까지 대기

        System.out.println("기대 수치: 2000");
        System.out.println("실제 비동기화 결과: " + unsafeCounter.getCount());
        System.out.println("-> 설명: 자물쇠가 없어서 두 스레드가 충돌해 2000보다 낮은 값이 출력됩니다.");
    }
}
