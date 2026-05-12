package week06.day5;

/**
 * [연습 문제 2] 다중 구현
 * 문제: Swimable, Flyable을 동시에 구현하는 Duck 클래스를 만드세요.
 */
public class Problem2 {
    public static void main(String[] args)
    {
        // TODO
        Duck d = new Duck();
        d.swim();
        d.fly();
    }

    interface Swimeable
    {
        void swim();
    }

    interface Flyable
    {
        void fly();
    }

    static class Duck implements Swimeable,Flyable
    {
        @Override
        public void swim()
        {
            System.out.println("오리가 헤엄을 치다");
        }
        @Override
        public void fly()
        {
            System.out.println("오리가 날다");
        }
    }

}
