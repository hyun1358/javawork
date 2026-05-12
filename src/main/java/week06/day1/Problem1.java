package week06.day1;

/**
 * [연습 문제 1] Animal -> Dog, Cat
 * 문제: Animal 클래스(필드: 이름)를 만들고 이를 상속받는 Dog, Cat 클래스를 구현하세요.
 */
public class Problem1 {
    public static void main(String[] args) {
        // TODO: Dog와 Cat 객체 생성 후 부모 필드에 접근해보세요.
        Dog dog = new Dog("흰둥이");
        Cat cat = new Cat("사랑이");
        dog.showName();
        cat.showName();
    }

    static class Aninal {
        String name;
    }

    static class Dog extends Aninal {
        Dog(String name) {
            this.name = name;
        }

        void showName() {
            System.out.println("이름 : " + name);
        }
    }

    static class Cat extends Aninal {
        Cat(String name) {
            this.name = name;
        }

        void showName() {
            System.out.println("이름 : " + name);
        }
    }
}
