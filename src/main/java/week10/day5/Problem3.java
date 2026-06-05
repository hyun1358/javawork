package week10.day5;

import java.io.*;

/**
 * [연습 문제 3] transient 키워드
 * 문제: Student의 민감한 정보 필드에 transient를 붙여 파일에 저장되지 않음을 확인하세요.
 */
public class Problem3 {
    public static void main(String[] args)
    {
        // TODO
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.dat")))
        {
            User u = new User("홍길동","1234",30);
            oos.writeObject(u);
            System.out.println(u);
            System.out.println("직렬화 완료");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat")))
        {
            User u = (User)ois.readObject();
            System.out.println(u);
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

    static class User implements Serializable
    {
        String name;
        transient String pw;

        int age;

        User(String name , String pw, int age) {this.name=name; this.pw=pw; this.age=age;}

        @Override
        public String toString()
        {
            return String.format("User{name = %s, pw = %s, age = %d}",this.name,this.pw,this.age);
        }
    }
}
