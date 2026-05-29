package week09.day4;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Answer3 {
    public static void main(String[] args) {
        // 학생 객체 리스트 생성
        List<Student> list = Arrays.asList(new Student(1, "Kim"), new Student(2, "Lee"));
        
        // 학생의 id를 키로, name을 값으로 가지는 Map으로 변환
        Map<Integer, String> map = list.stream()
                .collect(Collectors.toMap(s -> s.id, s -> s.name));
                
        // 변환된 Map 출력
        System.out.println(map);
    }
}

// 학생 정보를 저장하는 클래스
class Student {
    int id;
    String name;

    Student(int i, String n) {
        id = i;
        name = n;
    }
}
