package week05.day1;

/*
 * [정답 + 해설 1] Week 05 Day 1
 * 문제: Dog 클래스 정의 및 활용
 */
public class Answer1 {
    public static void main(String[] args) {
        Dog myDog = new Dog(); // 객체 생성
        myDog.name = "초코";
        myDog.age = 3;
        myDog.breed = "푸들";

        System.out.println("강아지 이름: " + myDog.name);
        System.out.println("강아지 나이: " + myDog.age);
        System.out.println("강아지 품종: " + myDog.breed);
        myDog.bark(); // 메서드 호출
    }
}

class Dog {
    String name;
    int age;
    String breed;

    void bark() {
        System.out.println(name + ": 멍멍!");
    }
}

/*
 * [해설]
 * - class Dog: 강아지의 설계도를 정의합니다.
 * - new Dog(): 메모리에 실제 강아지 객체를 만듭니다.
 * - . (점): 객체 내부에 접근할 때 사용합니다.
 */
