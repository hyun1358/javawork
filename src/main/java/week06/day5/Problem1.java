package week06.day5;

/**
 * [연습 문제 1] Flyable 인터페이스 구현
 * 문제: Flyable 인터페이스를 만들고 Bird와 Airplane 클래스가 이를 구현하게 하세요.
 */
public class Problem1 {
    public static void main(String[] args)
    {
        // TODO
        Flyable f1 = new Bird();
        Flyable f2 = new Airplane();

        f1.fly();
        f2.fly();
    }

    interface Flyable
    {
        void fly();
    }

    static class Bird implements Flyable
    {
        @Override
        public void fly()
        {
            System.out.println("새가 날개로 날다");
        }
    }

    static class Airplane implements Flyable
    {
        @Override
        public void fly()
        {
            System.out.println("비행기가 날다");
        }

    }


}
