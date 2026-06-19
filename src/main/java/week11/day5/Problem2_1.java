package week11.day5;

import java.lang.reflect.Field;

/**
 * [보충 문제 2_1] private 필드 값 강제 변경
 * 
 * 문제: 리플렉션을 사용하여 Person 객체의 private 필드인 `name`을 "이순신"으로,
 *       `age`를 35로 강제 변경(set)한 후, 원래 객체의 getter 메서드를 통해 출력해 보세요.
 */
public class Problem2_1 {
    public static void main(String[] args) throws Exception {
        Person person = new Person("홍길동", 20);

        // TODO: 리플렉션을 활용해 person 객체의 private 필드인 name을 "이순신", age를 35로 변경해 보세요.

        Field nameF = person.getClass().getDeclaredField("name");
        nameF.setAccessible(true);
        nameF.set(person,"이순신");

        Field ageF = person.getClass().getDeclaredField("age");
        ageF.setAccessible(true);
        ageF.set(person,35);


        // 아래 출력 결과를 통해 값이 잘 변경되었는지 확인합니다.
        System.out.println("이름: " + person.getName());
        System.out.println("나이: " + person.getAge());
    }

    static class Person {
        private String name;
        private int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() { return name; }
        public int getAge() { return age; }
    }
}
