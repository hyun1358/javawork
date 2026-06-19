package week11.day5;

import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * [연습 문제 3] 동적 호출
 * 문제: Scanner 객체에서 "nextLine" 메서드를 리플렉션으로 찾아서 실행해보세요.
 */
public class Problem3 {
    public static void main(String[] args) throws Exception
    {
        // TODO
        Scanner sc = new Scanner("Hello World\n");
        Method nextLineMethod = sc.getClass().getMethod("nextLine");
        String result = (String) nextLineMethod.invoke(sc);
        System.out.println(result);

        Person person = new Person("홍길동",30);
        Method greet = person.getClass().getDeclaredMethod("greet");
        greet.invoke(person);
    }
    static class Person {
        private String name;
        private int age;

        Person(String name, int age) {
            this.name = name;
            this.age  = age;
        }

        public void greet() {
            System.out.println("안녕하세요, 저는 " + name + "이고 " + age + "살입니다.");
        }
    }
}
