package week09.day5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Answer2 {
    public static void main(String[] args) {
        List<User> list = Arrays.asList(
                new User("Kim", 25, 90), new User("Lee", 18, 85), new User("Park", 22, 70)
        );
        List<String> names = list.stream()
                .filter(u -> u.age >= 20 && u.score >= 80)
                .map(u -> u.name)
                .collect(Collectors.toList());
        System.out.println(names);
    }
}

class User {
    String name;
    int age;
    int score;

    User(String n, int a, int s) {
        name = n;
        age = a;
        score = s;
    }
}
