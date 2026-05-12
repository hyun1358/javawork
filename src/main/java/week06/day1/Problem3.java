package week06.day1;

/**
 * [연습 문제 3] Employee -> Manager, Developer
 * 문제: Employee(이름, 급여)를 상속받는 Manager(부서), Developer(사용 언어)를 구현하세요.
 */
public class Problem3 {
    public static void main(String[] args) {
        // TODO: 구현
        Manager m = new Manager();
        m.name = "김팀장";
        m.dept = "개발팀";
        System.out.println(m.name + " " + m.dept);
    }

    static class Employee {
        String name;
        int salary;
    }

    static class Manager extends Employee {
        String dept;
    }

    static class Developer extends Employee {
        String lang;
    }
}
