package week05.day1;

/**
 * [연습 문제 1] Week 05 Day 1
 * <p>
 * 문제: Dog 클래스를 만들고 객체를 생성하여 정보를 출력하세요.
 * 1. Dog 클래스에는 name(이름), age(나이), breed(품종) 필드가 있어야 합니다.
 * 2. bark() 메서드를 만들어 "멍멍!" 이라고 짖는 소리를 출력하게 하세요.
 * 3. main 메서드에서 본인이 좋아하는 강아지 정보를 넣고 bark()를 호출하세요.
 * <p>
 * 난이도: ★☆☆☆☆
 */
public class Problem1 {
    public static void main(String[] args) {
        // TODO: Dog 클래스를 정의하고(파일 하단 혹은 외부), 객체를 생성하여 필드 값을 채우고 bark()를 호출하세요.
        Dog dog = new Dog("바둑이", 4, "리트리버");
        dog.bark();

    }

    static class Dog {
        String name;
        int age;
        String breed;

        Dog(String name, int age, String breed) {
            this.name = name;
            this.age = age;
            this.breed = breed;
        }

        void bark() {
            System.out.println("멍멍!");
        }
    }
}

// TODO: class Dog { ... } 정의
