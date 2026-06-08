package week05.day2;

/**
 * [학습 예제 5] Week 05 Day 2 — 생성자(Constructor) 기초와 오버로딩
 * 
 * [문제별 학습 목표]
 * - Lab5: 완성도 높은 생성자를 통한 Employee 객체 선언 (Problem 5 연계)
 */
public class Example5 {
    public static void main(String[] args) {
        Employee emp1 = new Employee("홍길동", "개발팀", 3500000);
        Employee emp2 = new Employee("김철수", "인사팀", 2800000);
        emp1.showEmployeeInfo();
        emp2.showEmployeeInfo();
    }

    // Problem 5: Employee 클래스 정의
    static class Employee {
        String name;
        String department;
        int salary;

        Employee(String name, String department, int salary) {
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        void showEmployeeInfo() {
            System.out.println("이름: " + name + ", 부서: " + department + ", 급여: " + salary + "원");
        }
    }
}
