package week09.day4;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Answer2_2 {
    public static void main(String[] args) {
        // 직원 객체 리스트 생성
        List<Employee> employees = Arrays.asList(
            new Employee(101, "Alice"),
            new Employee(102, "Bob"),
            new Employee(103, "Charlie")
        );
        
        // 직원 리스트를 순회하며 사번(id)을 키로, 이름(name)을 값으로 하는 Map 생성
        // Collectors.toMap을 사용하여 변환
        Map<Integer, String> empMap = employees.stream()
                .collect(Collectors.toMap(e -> e.id, e -> e.name));
                
        // 생성된 Map 출력
        System.out.println(empMap);
    }
    
    // 직원 정보를 담는 내부 클래스
    static class Employee {
        int id; String name;
        Employee(int id, String name) { this.id = id; this.name = name; }
    }
}
