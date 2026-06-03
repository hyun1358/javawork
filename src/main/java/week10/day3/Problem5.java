package week10.day3;

/**
 * [연습 문제 5] 스레드 풀 안전한 종료
 * 문제: 작업을 모두 마친 후 pool.shutdown()을 호출하고,
 * 왜 종료해야 하는지 주석으로 남기세요.
 */
public class Problem5 {
    public static void main(String[] args)
    {
        // TODO
        //shutdown을 안하면 쓰레드가 작업이 남아있다고 판단하고 게속 대기중 상태라 jvm종료가 안된다.
    }
}
