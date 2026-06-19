package week11.day5;

import java.lang.reflect.Field;

// 리플렉션을 사용하여 private 필드의 값을 강제로 수정(set)하는 보충 문제 모범 답안입니다.
public class Answer2_1 {
    public static void main(String[] args) throws Exception {
        Person person = new Person("홍길동", 20);

        // 1. name 필드 획득 및 접근 권한 허용
        Field nameField = Person.class.getDeclaredField("name");
        nameField.setAccessible(true);
        // 2. name 필드 값 변경 ("홍길동" -> "이순신")
        nameField.set(person, "이순신");

        // 3. age 필드 획득 및 접근 권한 허용
        Field ageField = Person.class.getDeclaredField("age");
        ageField.setAccessible(true);
        // 4. age 필드 값 변경 (20 -> 35)
        // 기본형 변수에 값을 세팅할 때도 setInt()를 사용하는 것이 효율적입니다.
        ageField.setInt(person, 35);

        // 결과 출력
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
