package week09.day4;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * [보충 문제 2_2] 사원 명부 Map 변환
 * 문제: Employee 객체 리스트를 (사번 -> 이름) 형태의 Map으로 변환하세요.
 */
public class Problem2_2 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(101, "Alice"),
            new Employee(102, "Bob"),
            new Employee(103, "Charlie")
        );

        // TODO: toMap을 사용하여 Map<Integer, String>으로 변환하세요.
        Map<Integer, String> empMap = employees.stream().collect(Collectors.toMap(e->e.id, e->e.name));

        System.out.println(empMap);
    }

    static class Employee {
        int id;
        String name;
        Employee(int id, String name) { this.id = id; this.name = name; }
    }
}
