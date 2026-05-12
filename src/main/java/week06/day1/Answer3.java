package week06.day1;

public class Answer3 {
    public static void main(String[] args) {
        Manager m = new Manager();
        m.name = "김팀장";
        m.dept = "개발팀";
        System.out.println(m.name + " " + m.dept);
    }
}

class Employee {
    String name;
    int salary;
}

class Manager extends Employee {
    String dept;
}

class Developer extends Employee {
    String lang;
}
