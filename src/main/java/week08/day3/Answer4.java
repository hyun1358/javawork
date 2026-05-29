package week08.day3;

import java.util.*;

/**
 * 람다식을 활용한 Comparator 구현으로 다중 조건 정렬을 수행하는 예제입니다.
 */
public class Answer4 {
    public static void main(String[] args) {
        List<Stud4> list = Arrays.asList(new Stud4("Kim", 30), new Stud4("Kim", 20));
        // 람다식을 사용하여 Comparator의 compare 메서드를 간단하게 구현합니다.
        list.sort((o1, o2) -> {
            // 이름이 같다면 나이를 기준으로 오름차순 정렬합니다.
            if (o1.name.equals(o2.name)) return o1.age - o2.age;
            // 이름이 다르다면 이름을 기준으로 사전순(오름차순) 정렬합니다.
            return o1.name.compareTo(o2.name);
        });
        for (Stud4 s : list) System.out.println(s.name + " " + s.age);
    }
}

class Stud4 {
    String name;
    int age;

    Stud4(String n, int a) {
        name = n;
        age = a;
    }
}
