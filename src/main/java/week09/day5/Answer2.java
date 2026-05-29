package week09.day5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Answer2 {
    public static void main(String[] args) {
        // 3명의 사용자 정보를 가지는 리스트 생성
        List<User> list = Arrays.asList(
                new User("Kim", 25, 90), new User("Lee", 18, 85), new User("Park", 22, 70)
        );
        
        List<String> names = list.stream()
                // 나이가 20세 이상이고 점수가 80점 이상인 사용자만 필터링
                .filter(u -> u.age >= 20 && u.score >= 80)
                // 조건에 맞는 사용자의 이름(name)만 추출하여 매핑
                .map(u -> u.name)
                // 추출된 이름들을 새로운 리스트로 수집
                .collect(Collectors.toList());
                
        // 결과 출력
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
