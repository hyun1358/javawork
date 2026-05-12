package week06.day4;

/**
 * [연습 문제 2] 추상/일반 공존
 * 문제: 추상 메서드 sound()와 일반 메서드 breathe()를 갖는 Animal 구현.
 */
public class Problem2 {
    public static void main(String[] args)
    {
        // TODO
        Dog dog = new Dog();
        dog.breathe();
        dog.sound();
    }

    static abstract class Animal
    {
        abstract void sound();
        void breathe() {
            System.out.println("숨을 쉬다");
        }
    }

    static class Dog extends Animal
    {
        @Override
        void sound()
        {
            System.out.println("멍멍");
        }
    }
}
