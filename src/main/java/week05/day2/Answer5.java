package week05.day2;

/*
 * [정답 + 해설 5] Week 05 Day 2
 * 문제: 종합 생성자 실습
 */
public class Answer5 {
    public static void main(String[] args) {
        Employee e1 = new Employee("홍길동", "개발팀", 5000);
        Employee e2 = new Employee("김철수", "인사팀", 4500);

        e1.show();
        e2.show();
    }
}

class Employee {
    String name;
    String dept;
    int salary;

    Employee(String name, String dept, int salary) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

    void show() {
        System.out.println("사원명: " + name + ", 부서: " + dept + ", 연봉: " + salary);
    }
}
