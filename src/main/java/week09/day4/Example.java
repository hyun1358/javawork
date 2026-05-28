package week09.day4;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * [학습 예제] Week 09 Day 4 — 그룹핑과 리듀스 및 toMap
 * 
 * [학습 핵심 이론: 스트림의 고급 가공 및 최종 처리]
 * 1. reduce(초기값, accumulator) 연산:
 *    - 스트림의 요소를 소비해가며 지정된 누적 동작(lambda)을 통해 하나의 단일 결과로 축소(reduce)하는 강력한 커스텀 최종 연산입니다.
 *    - 예: `reduce(1, (a, b) -> a * b)`는 1부터 시작해 스트림의 모든 정수를 차례로 곱해 단일 총 곱값을 도출해 냅니다.
 * 
 * 2. Collectors.groupingBy()를 이용한 그룹 분류:
 *    - 스트림 안의 데이터 객체들을 지정한 특성(키) 기준으로 쪼개어 분류한 뒤, Map 자료형(`Map<Key, List<Element>>`)으로 깔끔히 모아 수집(collect)하는 실무 핵심형 기법입니다.
 *    - 조건식에 따라 단순히 true/false(Boolean)로 분류할 수도 있지만, 삼항 연산자(Ternary Operator) 등을 사용하면 원하는 커스텀 문자열(예: "합격"/"불합격")을 Key로 갖는 그룹화 Map을 손쉽게 얻을 수 있습니다.
 * 
 * 3. Collectors.toMap(keyMapper, valueMapper)를 이용한 맵 변환:
 *    - 리스트 등 컬렉션 안의 객체 데이터들을 꺼내서 (특정 고유 필드 -> 다른 필드) 혹은 (특정 고유 필드 -> 객체 자신) 형태의 Map 구조로 변환할 때 씁니다.
 *    - keyMapper는 Map의 Key를 추출하는 함수, valueMapper는 Map의 Value를 추출하는 함수입니다.
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Lab1: reduce로 곱셈 합 구하기 ===");
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        // reduce(identity, accumulator) 연산:
        // identity(1)는 연산의 초기값이고, accumulator((a, b) -> a * b)는 두 요소를 결합하여 하나의 결과를 내는 람다식입니다.
        // 스트림의 요소를 돌며 1 * 1 = 1, 1 * 2 = 2, 2 * 3 = 6, 6 * 4 = 24와 같이 누적 곱을 처리하여 단일 최종 결과를 도출합니다.
        int multi = list.stream().reduce(1, (a, b) -> a * b);
        System.out.println("모두 곱한 값: " + multi);

        System.out.println("\n=== Lab2: groupingBy (문자열 첫 글자별 그룹화) ===");
        List<String> names = Arrays.asList("Kim", "Kang", "Lee", "Lim");
        // Collectors.groupingBy(classifier):
        // classifier 람다식(s -> s.charAt(0))을 기준 열쇠 삼아 스트림 요소를 분류하고, 결과를 Map<Character, List<String>> 형태로 수집(collect)합니다.
        Map<Character, List<String>> map = names.stream()
                .collect(Collectors.groupingBy(s -> s.charAt(0)));
        System.out.println(map); // 첫 글자별 묶임

        System.out.println("\n=== Lab3: groupingBy (조건별 커스텀 문자열 그룹화) ===");
        List<Integer> scores = Arrays.asList(50, 70, 45, 95, 80);
        // 단순히 n -> n >= 60 으로 분류하면 Map의 Key가 Boolean(true, false)이 되지만,
        // 아래처럼 삼항 연산자(n >= 60 ? "합격" : "불합격")를 활용하여 분류 기준을 작성하면 
        // Map의 Key를 "합격"/"불합격"이라는 의미 있는 문자열로 그룹핑하여 받아낼 수 있습니다!
        Map<String, List<Integer>> gradeMap = scores.stream()
                .collect(Collectors.groupingBy(n -> n >= 60 ? "합격" : "불합격"));
        System.out.println(gradeMap); // {합격=[70, 95, 80], 불합격=[50, 45]}

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
}

// Lab4용 보조 클래스
class Employee {
    int empId;
    String name;

    Employee(int empId, String name) {
        this.empId = empId;
        this.name = name;
    }
}
