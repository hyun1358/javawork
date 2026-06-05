package week10.day5;

import java.io.*;
import java.nio.charset.Charset;

/**
 * [연습 문제 1] 객체 직렬화
 * 문제: Serializable을 구현한 Student 클래스를 파일에 저장해보세요.
 * (단, 이름(String)과 나이(int) 필드를 갖는 Student 클래스를 직접 작성하세요.)
 */
public class Problem1 {
    public static void main(String[] args)
    {
        // TODO
        Student s = new Student("홍길동",20);

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.dat")))
        {
            oos.writeObject(s);
            System.out.println(s);
            System.out.println("객체 직렬화 완료");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    static class Student implements Serializable
    {
        String name;
        int age;

        Student(String name, int age) {this.name = name; this.age = age;}

        @Override
        public String toString()
        {
            return String.format("Student{name = %s, age = %d}",this.name,this.age);
        }
    }
}
