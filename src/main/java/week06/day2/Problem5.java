package week06.day2;

/**
 * [연습 문제 5] @Override 어노테이션
 * 문제: @Override 없이 오타를 내면 어떻게 되는지 실습하고, 이유를 주석으로 적으세요.
 */
public class Problem5 {
    public static void main(String[] args)
    {
        // TODO
        Person p = new Person("홍길동",20);
        System.out.println(p.toString());
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
        public String toString()
        {
            return "이름 : " + name + ", 나이 : " + age;
        }
    }
}
