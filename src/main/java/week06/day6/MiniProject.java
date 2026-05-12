package week06.day6;

/**
 * [미니 프로젝트] Week 06 Day 6 — 직원 관리 시스템
 * <p>
 * 상속, 오버라이딩, 다형성이 적용된 직원 관리 시스템 구현 완료
 */
public class MiniProject {
    public static void main(String[] args) {
        Employee[] employees = { 
                new Manager("홍길동", 1500000, 100000),
                new Developer("개발자", 2500000, 500000),
                new Manager("관리자", 3000000, 500000),
                new Developer("고수개발자", 5000000, 1000000) 
        };

        int totalSalary = 0;

        for (Employee e : employees) {
            int salary = e.getSalary();
            System.out.printf("이름 : %-6s, 급여: %,d\n", e.name, salary);
            totalSalary += salary;
        }

        System.out.println("------------------------------------");
        System.out.println("전체 직원 급여 총합: " + totalSalary + "원");
    }

    static class Employee {
        private String name;
        private int baseSalary;

        Employee(String name, int baseSalary) {
            this.name = name;
            this.baseSalary = baseSalary;
        }

        int getSalary() {
            return this.baseSalary;
        }
    }

    static class Manager extends Employee {
        private int bonus;

        Manager(String name, int baseSalary, int bonus) {
            super(name, baseSalary);
            this.bonus = bonus;
        }

        @Override
        int getSalary() {
            return this.bonus + super.getSalary();
        }
    }

    static class Developer extends Employee {
        private int techAllowance;

        Developer(String name, int baseSalary, int techAllowance) {
            super(name, baseSalary);
            this.techAllowance = techAllowance;
        }

        @Override
        int getSalary() {
            return this.techAllowance + super.getSalary();
        }
    }
}
