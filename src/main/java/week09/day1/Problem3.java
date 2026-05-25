package week09.day1;

/**
 * [연습 문제 3] Runnable 람다
 * 문제: "Hello Lambda!"를 출력하는 Runnable 객체를 람다식으로 생성하고 run()을 호출하세요.
 */
public class Problem3 {
    public static void main(String[] args)
    {
        // TODO
        Runnable runnable1 = new Runnable()
        {
            @Override
            public void run()
            {
                System.out.println("Hello Lambda");
            }
        };

        runnable1.run();

        Runnable runnable2 = () -> System.out.println("Hello Lambda");
        runnable2.run();
    }
}
