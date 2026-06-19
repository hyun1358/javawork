package week11.day5;

import java.lang.reflect.Field;

/**
 * [연습 문제 4] 객체 복사 (Shallow Copy)
 * 리플렉션을 통해 한 객체의 모든 필드 값을 다른 객체로 복사하는 코드를 작성하세요.
 */
public class Problem4 {
    public static void main(String[] args) throws Exception
    {
        // TODO
        Person person = new Person("홍길동",20);
        Person copy = new Person(null,0);

        System.out.println("복사시작");
        for(Field f : person.getClass().getDeclaredFields())
        {
            f.setAccessible(true);
            f.set(copy, f.get(person) );
        }

        System.out.println("원본 - 이름: "+ person.getName() + ", 나이: "+ person.getAge());
        System.out.println("복사본 - 이름: "+ copy.getName() + ", 나이: "+ copy.getAge());
    }

    static class Person {
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
