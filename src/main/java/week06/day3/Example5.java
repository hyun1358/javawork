package week06.day3;

/**
 * [학습 예제 5] Week 06 Day 3 — 다형성(Polymorphism)의 심화
 * 
 * [문제별 학습 목표]
 * - Lab5: 다형성을 이용한 전사 급여(Employee) 총합 계산기 (Problem 5 연계)
 */
public class Example5 {
    public static void main(String[] args) {
        Employee[] team = {
            new Manager(15000),
            new Developer(20000),
            new Manager(25000),
            new Developer(50000)
        };

        int totalSalary = 0;
        for (Employee e : team) {
            totalSalary += e.getMoney();
        }
        System.out.println("우리 팀의 전체 급여 지출액 합계: " + totalSalary + "원");
    }

    // Problem 5: Employee 계층
    static class Employee {
        int money;
        int getMoney() { return money; }
    }

    static class Manager extends Employee {
        Manager(int money) { this.money = money; }
    }

    static class Developer extends Employee {
        Developer(int money) { this.money = money; }
    }
}
