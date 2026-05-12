package week06.day2;

/**
 * [연습 문제 4] super.메서드() 호출
 * 문제: 자식 클래스에서 오버라이딩 할 때, 부모의 기능을 그대로 호출한 뒤 내용을 추가하세요.
 */
public class Problem4 {
    public static void main(String[] args)
    {
        // TODO
        Dog dog = new Dog();
        dog.show();
    }

    static class Animal
    {
        void sound() {
            System.out.println("소리내기");
        }
    }

    static class Dog extends Animal
    {
        void show()
        {
            super.sound();
            System.out.println("나는 강아지");
        }
    }
}
