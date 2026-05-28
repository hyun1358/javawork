package week09.day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * [연습 문제 3] toMap 사용
 * 문제: Student 객체 리스트를 (학번 -> 이름) 형태의 Map으로 변환하세요.
 */
public class Problem3 {
    public static void main(String[] args)
    {
        // TODO
        List<Studnet> studnets = new ArrayList<>(Arrays.asList(
                new Studnet(20260528,"홍길동"),
                new Studnet(20260527,"이길동"),
                new Studnet(20260526,"삼길동"),
                new Studnet(20260525,"사길동")));

        Map<Integer,String> students_map = studnets.stream().collect(Collectors.toMap(s->s.studnet_number,s->s.name));
        System.out.println(students_map);
    }

    static class Studnet
    {
        int studnet_number;
        String name;

        Studnet(int n,String name)
        {
            this.studnet_number=n;
            this.name=name;
        }
    }
}
