package week08.day3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * [복습 문제 4-1] 다중 조건 정렬
 * 
 * 목표: 직원(Employee) 리스트를 다음 조건에 맞게 정렬하세요.
 *   - 1순위: 월급(salary) 내림차순 (많이 받는 사람 먼저)
 *   - 2순위: 월급이 같다면 나이(age) 오름차순 (어린 사람 먼저)
 * 제약: Employee 클래스 수정 금지.
 */
public class Problem4_1 {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("김대리", 300, 30));
        employees.add(new Employee("이과장", 400, 35));
        employees.add(new Employee("박대리", 300, 28)); // 김대리와 월급은 같지만 나이가 어림

        // TODO: 조건에 맞는 Comparator 객체를 만드세요.
        Comparator<Employee> comparator = new Comparator<Employee>()
        {
            @Override
            public int compare(Employee o1, Employee o2)
            {
                if(o1.salary==o2.salary)
                {
                    return o1.age-o2.age;
                }
                return o2.salary - o1.salary;
            }
        };
        

        // TODO: 정렬 실행
        Collections.sort(employees, comparator);
        

        // 출력 로직 (이과장 -> 박대리 -> 김대리 순으로 나와야 정답!)
        for (Employee e : employees) {
            System.out.println(e.name + " (월급: " + e.salary + ", 나이: " + e.age + ")");
        }
    }

    // 이 클래스는 절대 수정하지 마세요!
    static class Employee {
        String name;
        int salary;
        int age;
        Employee(String name, int salary, int age) {
            this.name = name; 
            this.salary = salary; 
            this.age = age;
        }
    }
}
