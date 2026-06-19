package week11.day5;

import java.lang.reflect.Field;

/**
 * [연습 문제 2] private 값 읽기
 * 문제: 어떤 클래스의 private int age 값을 리플렉션으로 읽어보세요.
 */
public class Problem2 {
    public static void main(String[] args) throws Exception {
        // TODO
        Person person = new Person("홍길동",20);

        Field ageField = person.getClass().getDeclaredField("age");
        ageField.setAccessible(true); // private 접근을 하기 위해 설정 이게 뭔지는 모르겠지만

        int age = (int) ageField.get(person);

        System.out.println("person 필드 age :" + age);
    }

    static class Person
    {
        private String name;
        private int age;

        Person(String name, int age) {
            this.name = name;
            this.age  = age;
        }

        public String getName() { return name; }
        public int getAge()     { return age; }
    }
}
