package week05.day1;

/*
 * [정답 + 해설 3] Week 05 Day 1
 * 문제: 서로 다른 두 객체 생성
 */
public class Answer3 {
    public static void main(String[] args) {
        // 첫 번째 Person 객체(p1)를 생성하고 정보를 설정합니다.
        Person p1 = new Person();
        p1.name = "홍길동";
        p1.age = 20;

        // 두 번째 Person 객체(p2)를 생성하고 정보를 설정합니다.
        // p1과 p2는 메모리 상에서 서로 다른 독립적인 객체입니다.
        Person p2 = new Person();
        p2.name = "이순신";
        p2.age = 45;

        // 각 객체에 저장된 독립적인 데이터를 화면에 출력합니다.
        System.out.println("사람 1: " + p1.name + "(" + p1.age + "세)");
        System.out.println("사람 2: " + p2.name + "(" + p2.age + "세)");
    }
}

// [클래스 설명] Person 클래스는 사람의 이름과 나이 정보를 담기 위한 기본 자료구조 역할을 합니다.
class Person {
    String name;
    int age;
}
