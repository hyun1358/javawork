package week06.day2;

import java.util.Objects;

/**
 * [연습 문제 3] equals() 오버라이딩
 * 문제: Person 클래스의 인스턴스 두 개가 이름과 나이가 같으면 true를 반환하도록 equals를 만드세요.
 */
public class Problem3 {
    public static void main(String[] args)
    {
        // TODO
        Person p1 = new Person("홍길동",15);
        Person p2 = new Person("홍길동",15);

        System.out.println(p1.equals(p2));

    }

    static class Person
    {
        String name;
        int age;

        Person(String name, int age)
        {
            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(Object obj)
        {
            if(obj instanceof Person)
            {
                Person p = (Person)obj;
                return (this.name.equals(p.name) && this.age == p.age);
            }
            else
                return false;
        }
    }
}
