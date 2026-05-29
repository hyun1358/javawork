package week09.day5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [연습 문제 2] 복합 필터링
 * 문제: 사용자 객체 리스트에서 나이가 20세 이상이고 점수가 80 이상인 사람의 이름만 리스트로 반환하세요.
 * (단, 이름(String), 나이(int), 점수(int)를 필드로 갖는 User 클래스를 직접 생성하여 사용하세요.)
 */
public class Problem2 {
    public static void main(String[] args)
    {
        // TODO
        List<User> users = new ArrayList<>(Arrays.asList(
                new User("일길동",20,80),
                new User("이길동",30,30),
                new User("삼길동",50,50),
                new User("사길동",22,60),
                new User("오길동",30,87)
        ));

        users.stream().filter(u-> u.age >= 20 && u.score >= 80).map(User::getName).forEach(u-> System.out.println("이름: "+u));
    }
    static class User
    {
        String name;
        int age;
        int score;

        User(String name, int age, int score)
        {
            this.name = name;
            this.age = age;
            this.score = score;
        }

        public String getName()
        {
            return this.name;
        }
    }
}
