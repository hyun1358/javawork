package week05.day2;

/**
 * [연습 문제 5] Week 05 Day 2
 * <p>
 * 문제: 생성자를 활용해 간결하게 객체를 생성하고 정보를 출력하세요.
 * 1. Employee 클래스(이름, 부서, 급여)를 만듭니다.
 * 2. 모든 정보를 한 번에 받는 생성자를 만듭니다.
 * 3. main에서 2명의 직원을 생성하고 정보를 출력하세요.
 * <p>
 * 난이도: ★★☆☆☆
 */
public class Problem5 {
    public static void main(String[] args) {
        // TODO: Employee 객체 2개를 생성하고 출력하세요.
        Employee e1 = new Employee("홍길동", "총괄", 1200000);
        e1.init();
        Employee e2 = new Employee("김철수", "디자이너", 1600000);
        e2.init();
    }

    static class Employee {
        String name, department;
        int salary;

        Employee(String name, String department, int salary) {
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        void init() {
            System.out.println("이름 : " + this.name + ", 부서 : " + this.department + ", 급여 : " + this.salary);
        }
    }
}
