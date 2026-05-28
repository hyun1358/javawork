package week09.day4;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Answer2_2 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(101, "Alice"),
            new Employee(102, "Bob"),
            new Employee(103, "Charlie")
        );
        Map<Integer, String> empMap = employees.stream()
                .collect(Collectors.toMap(e -> e.id, e -> e.name));
        System.out.println(empMap);
    }
    static class Employee {
        int id; String name;
        Employee(int id, String name) { this.id = id; this.name = name; }
    }
}
