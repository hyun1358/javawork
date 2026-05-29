package week09.day4;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Answer3_2 {
    public static void main(String[] args) {
        // 전공과 이름을 가진 학생 객체 리스트 초기화
        List<Student> students = Arrays.asList(
            new Student("컴퓨터공학", "김철수"),
            new Student("전자공학", "이영희"),
            new Student("컴퓨터공학", "박민수"),
            new Student("경영학", "최지영")
        );
        
        // 전공(major)을 기준으로 그룹화하고, 해당 그룹에 속한 학생들의 이름(name)만 리스트로 추출
        // 정답 예시: groupingBy 내부에서 mapping을 사용하여 이름만 추출
        Map<String, List<String>> majorMap = students.stream()
                .collect(Collectors.groupingBy(Student::getMajor, 
                         Collectors.mapping(Student::getName, Collectors.toList())));
                         
        // 전공별 학생 이름 리스트 맵 출력
        System.out.println(majorMap);
    }
    // 학생의 전공과 이름 정보를 저장하는 정적 내부 클래스
    static class Student {
        String major; String name;
        Student(String major, String name) { this.major = major; this.name = name; }
        String getMajor() { return major; }
        String getName() { return name; }
    }
}
