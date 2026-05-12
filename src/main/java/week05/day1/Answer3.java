package week05.day1;

/*
 * [정답 + 해설 3] Week 05 Day 1
 * 문제: 서로 다른 두 객체 생성
 */
public class Answer3 {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.name = "홍길동";
        p1.age = 20;

        Person p2 = new Person();
        p2.name = "이순신";
        p2.age = 45;

        System.out.println("사람 1: " + p1.name + "(" + p1.age + "세)");
        System.out.println("사람 2: " + p2.name + "(" + p2.age + "세)");
    }
}

class Person {
    String name;
    int age;
}
