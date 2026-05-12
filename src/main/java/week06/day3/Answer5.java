package week06.day3;

public class Answer5 {
    public static void main(String[] args) {
        Employee[] emps = {new Manager(5000), new Developer(4000)};
        int total = 0;
        for (Employee e : emps) total += e.getSalary();
        System.out.println("총 급여: " + total);
    }
}

class Employee {
    int salary;

    Employee(int s) {
        salary = s;
    }

    int getSalary() {
        return salary;
    }
}

class Manager extends Employee {
    Manager(int s) {
        super(s);
    }
}

class Developer extends Employee {
    Developer(int s) {
        super(s);
    }
}
