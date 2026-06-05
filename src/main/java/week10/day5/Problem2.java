package week10.day5;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * [연습 문제 2] 객체 역직렬화
 * 문제: Problem1에서 만든 파일을 읽어들여 Student 객체로 복원하고 출력하세요.
 */
public class Problem2 {
    public static void main(String[] args)
    {
        // TODO
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.dat")))
        {
            Problem1.Student s = (Problem1.Student)ois.readObject();
            System.out.println(s);
            System.out.println("역직렬화 불러오기완료");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("클래스를 못찾음");
            throw new RuntimeException(e);
        }
        catch (IOException e)
        {
            System.out.println("IO오류");
            e.printStackTrace();
        }
    }
}
