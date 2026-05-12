package week06.day5;

/**
 * [연습 문제 5] 다형성과 인터페이스
 * 문제: 인터페이스 타입 배열을 선언하고 그 안에 구현 객체들을 넣어 일괄 처리해보세요.
 */
public class Problem5 {
    public static void main(String[] args)
    {
        // TODO
        Flyable[] flyable = {new Duck(), new Airplan() };
        for(Flyable f : flyable)
            f.fly();
    }

    interface Flyable
    {
        void fly();
    }

    static class Duck implements Flyable
    {
        @Override
        public void fly()
        {
            System.out.println("오리가 하늘을 날다.");
        }
    }

    static class Airplan implements Flyable
    {
        @Override
        public void fly()
        {
            System.out.println("비행기가 하늘을 날다");
        }
    }


}
