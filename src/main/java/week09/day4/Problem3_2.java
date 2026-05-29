package week09.day4;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * [보충 문제 3_2] 전공별 학생 이름 그룹핑
 * 문제: 학생 리스트를 전공별로 그룹화하되, 리스트에는 학생 객체가 아닌 '이름'만 담기게 하세요.
 * 힌트: groupingBy와 mapping을 함께 사용하거나, groupingBy 후 결과를 재가공할 수 있습니다.
 */
public class Problem3_2 {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("컴퓨터공학", "김철수"),
            new Student("전자공학", "이영희"),
            new Student("컴퓨터공학", "박민수"),
            new Student("경영학", "최지영")
        );

        // TODO: 전공(Major)을 Key로, 학생 이름(Name) 리스트를 Value로 갖는 Map을 만드세요.
        Map<String,List<String>> maps = students.stream().collect(Collectors.groupingBy(Student::getMajor, TreeMap::new,Collectors.mapping(Student::getName,Collectors.toList())));

        for(Map.Entry<String,List<String>> entry : maps.entrySet())
        {
            System.out.println("전공: "+entry.getKey());
            for(String s: entry.getValue())
            {
                System.out.println("- "+s);
            }
        }
}

    static class Student {
        String major;
        String name;
        Student(String major, String name) { this.major = major; this.name = name; }
        String getMajor() { return major; }
        String getName() { return name; }
    }
}
