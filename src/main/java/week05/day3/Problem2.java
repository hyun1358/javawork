package week05.day3;

/**
 * [연습 문제 2] setter 유효성 검사
 * 문제: Person 클래스의 setAge(int age) 메서드에서
 * 나이가 0보다 작으면 "잘못된 입력"을 출력하고 저장하지 않도록 구현하세요.
 */
public class Problem2 {
    public static void main(String[] args) {
        // TODO: 음수 나이 입력 시나리오 테스트

        Person person = new Person();
        person.setAge(15);
        System.out.println(person.getAge());
        person.setAge(-23);
        System.out.println(person.getAge());
    }
}

class Person {
    private int age;

    // TODO: 유효성 검사가 포함된 setter 구현
    void setAge(int age) {
        if (age < 0) {
            System.out.println("잘못된 입력");
        } else {
            this.age = age;
        }
    }

    int getAge() {
        return this.age;
    }
}
