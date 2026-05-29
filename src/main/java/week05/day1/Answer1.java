package week05.day1;

/*
 * [정답 + 해설 1] Week 05 Day 1
 * 문제: Dog 클래스 정의 및 활용
 */
public class Answer1 {
    public static void main(String[] args) {
        // Dog 클래스를 기반으로 myDog라는 새로운 객체를 메모리에 생성합니다.
        Dog myDog = new Dog(); // 객체 생성
        
        // 생성된 myDog 객체의 필드(속성)에 초기값을 할당합니다.
        myDog.name = "초코";
        myDog.age = 3;
        myDog.breed = "푸들";

        // 객체의 상태(필드 값)를 화면에 출력하여 확인합니다.
        System.out.println("강아지 이름: " + myDog.name);
        System.out.println("강아지 나이: " + myDog.age);
        System.out.println("강아지 품종: " + myDog.breed);
        
        // 객체의 기능(메서드)을 호출하여 강아지가 짖는 동작을 실행합니다.
        myDog.bark(); // 메서드 호출
    }
}

// [클래스 설명] Dog 클래스는 강아지의 공통적인 속성(이름, 나이, 품종)과 동작(짖기)을 정의한 설계도입니다.
class Dog {
    String name;
    int age;
    String breed;

    // [메서드 설명] 강아지의 이름 속성을 활용하여 짖는 동작을 콘솔에 출력하는 메서드입니다.
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
