package week10.day5;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [연습 문제 5] 수동 CSV 저장 (직렬화 아님)
 * 문제: 직렬화 대신, 객체의 데이터를 "이름,점수" 형태의 쉼표 문자열로 변환하여
 * 텍스트 파일(csv)에 저장하는 코드를 작성하세요.
 */
public class Problem5 {
    public static void main(String[] args)
    {
        // TODO



        try(FileWriter fw = new FileWriter("user.csv", Charset.forName("MS949")))
        {
            List<Problem5.Student> students = new ArrayList<>(Arrays.asList(
                    new Problem5.Student("일길공","1111",21,70),
                    new Problem5.Student("이길공","1234",23,50),
                    new Problem5.Student("삼길공","14567",25,76),
                    new Problem5.Student("사길공","4637",31,78),
                    new Problem5.Student("오길공","45786i",61,90),
                    new Problem5.Student("육길공","457745",31,60)
            ));
            fw.write("이름,패스워드,나이,스코어\n");
            for(Student s : students)
            {
                fw.write(s.name+","+s.pw+","+s.age+","+s.score+"\n");
            }
            System.out.println("csv생성 완료");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        try
        {
           List<String> students = Files.readAllLines(Path.of("user.csv"),Charset.forName("MS949"));
           for(String s : students)
           {
               System.out.println(s);
           }
        }
        catch (IOException e)
        {
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
