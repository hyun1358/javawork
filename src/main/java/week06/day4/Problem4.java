package week06.day4;

/**
 * [연습 문제 4] Beverage 추상 클래스
 * 문제: brew()를 추상으로, serve()를 일반으로 가진 추상 클래스를 만들고 상속하세요.
 */
public class Problem4 {
    public static void main(String[] args)
    {
        // TODO
        Drink d = new Drink();
        d.brew();
        d.serve();
    }

    static abstract class Beverage
    {
        abstract void brew();
        void serve()
        {
            System.out.println("제공하다");
        }
    }

    static class Drink extends Beverage
    {
        @Override
        void brew()
        {
            System.out.println("우려내다");
        }
    }
}
