package week09.day4;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * [학습 예제 4] Week 09 Day 4 — 그룹핑과 리듀스 및 toMap
 * 
 * [학습 핵심 이론: 스트림의 고급 가공 및 최종 처리]
 * 3. Collectors.toMap(keyMapper, valueMapper)를 이용한 맵 변환:
 *    - 리스트 등 컬렉션 안의 객체 데이터들을 꺼내서 (특정 고유 필드 -> 다른 필드) 혹은 (특정 고유 필드 -> 객체 자신) 형태의 Map 구조로 변환할 때 씁니다.
 *    - keyMapper는 Map의 Key를 추출하는 함수, valueMapper는 Map의 Value를 추출하는 함수입니다.
 */
public class Example4 {
    public static void main(String[] args) {
        System.out.println("\n=== Lab4: Collectors.toMap을 통한 객체 리스트의 맵 변환 ===");
        List<Employee> employees = Arrays.asList(
                new Employee(101, "Alice"),
                new Employee(102, "Bob"),
                new Employee(103, "Charlie")
        );
        // Collectors.toMap(keyMapper, valueMapper):
        // keyMapper로 사원 번호(e -> e.empId), valueMapper로 사원 이름(e -> e.name)을 연결하여 
        // List<Employee>를 Map<Integer, String> 구조로 완벽히 치환합니다.
        Map<Integer, String> empMap = employees.stream()
                .collect(Collectors.toMap(e -> e.empId, e -> e.name));
        System.out.println("사원 맵: " + empMap); // {101=Alice, 102=Bob, 103=Charlie}
    }

    // Lab4용 보조 클래스
    static class Employee {
        int empId;
        String name;

        Employee(int empId, String name) {
            this.empId = empId;
            this.name = name;
        }
    }
}
