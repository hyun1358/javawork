package week06.day6;

/**
 * [미니 프로젝트 정답] Week 06 Day 6 — 직원 관리 시스템
 */
public class MiniProjectAnswer {
    public static void main(String[] args) {
        Employee[] emps = {
                new Employee("사원A", 3000),
                new Manager("팀장B", 4000, 1000),
                new Developer("개발자C", 3500, 500)
        };

        int total = 0;
        for (Employee e : emps) {
            System.out.println(e.name + " 급여: " + e.getSalary());
            total += e.getSalary();
        }
        System.out.println("총 급여 합계: " + total);
    }
}

class Employee {
    String name;
    int baseSalary;

    Employee(String n, int s) {
        name = n;
        baseSalary = s;
    }

    int getSalary() {
        return baseSalary;
    }
}

class Manager extends Employee {
    int bonus;

    Manager(String n, int s, int b) {
        super(n, s);
        bonus = b;
    }

    @Override
    int getSalary() {
        return baseSalary + bonus;
    }
}

class Developer extends Employee {
    int techAllowance;

    Developer(String n, int s, int a) {
        super(n, s);
        techAllowance = a;
    }

    @Override
    int getSalary() {
        return baseSalary + techAllowance;
    }
}
