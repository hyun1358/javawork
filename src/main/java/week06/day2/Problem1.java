package week06.day2;

/**
 * [연습 문제 1] Animal의 sound 오버라이딩
 * 문제: Animal의 sound()를 Dog는 "멍멍", Cat은 "야옹"으로 오버라이딩하세요.
 */
public class Problem1 {
    public static void main(String[] args) {
        // TODO
        Dog dog = new Dog();
        Cat cat = new Cat();

        dog.sound();
        cat.sound();
    }

    static class Animal {
        void sound() {
            System.out.println("동물소리");
        }
    }

    static class Dog extends Animal {
        void sound() {
            System.out.println("멍멍");
        }
    }

    static class Cat extends Animal {
        void sound() {
            System.out.println("야옹");
        }
    }
}
