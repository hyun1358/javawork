package week05.day1;

/**
 * [연습 문제 3] Week 05 Day 1
 * <p>
 * 문제: 같은 클래스로 두 개의 서로 다른 객체를 만드세요.
 * 1. Person 클래스(이름, 나이)를 만듭니다.
 * 2. '홍길동(20세)', '이순신(45세)' 정보를 가진 두 객체를 각각 생성합니다.
 * 3. 두 사람의 정보를 각각 출력하세요.
 * <p>
 * 난이도: ★★☆☆☆
 */
public class Problem3 {
    public static void main(String[] args) {
        // TODO: Person 객체 2개를 만들어 각각 다른 데이터를 저장하고 출력하세요.
        Person p1 = new Person("홍길동", 15);
        p1.init();

        Person p2 = new Person("김철수", 20);
        p2.init();

    }

    static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        void init() {
            System.out.printf("%s(%d세)\n", this.name, this.age);
        }
    }
}
