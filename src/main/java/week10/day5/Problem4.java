package week10.day5;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [연습 문제 4] 컬렉션 통째로 저장
 * 문제: Student 객체들을 담은 ArrayList를 직렬화하여 파일에 한 번에 저장하세요.
 */
public class Problem4 {
    public static void main(String[] args)
    {
        // TODO
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("studnets.dat")))
        {
            List<Student> students = new ArrayList<>(Arrays.asList(
                    new Student("일길공","1111",21,70),
                    new Student("이길공","1234",23,50),
                    new Student("삼길공","14567",25,76),
                    new Student("사길공","4637",31,78),
                    new Student("오길공","45786i",61,90),
                    new Student("육길공","457745",31,60)
            ));

            oos.writeObject(students);
            for(Student s : students)
            {
                System.out.println(s);
            }
            System.out.println("직렬화 완료");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("studnets.dat")))
        {
            @SuppressWarnings("unchecked")
            List<Student> students = (List<Student>) ois.readObject();
            for(Student s : students)
            {
                System.out.println(s);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("클래스 못찾음");
            e.printStackTrace();
        }
    }

    static class Student implements Serializable
    {
        String name;
        transient String pw;
        int age;
        int score;

        Student(String name,String pw, int age, int score)
        {
            this.name=name;
            this.pw=pw;
            this.age=age;
            this.score=score;
        }

        @Override
        public String toString()
        {
            return String.format("Student{name = %s, pw = %s, age = %d, score = %d",this.name,this.pw,this.age,this.score);
        }
    }
}
