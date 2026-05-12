package week06.day3;

/**
 * [연습 문제 5] 다형성을 이용한 급여 계산기
 * 문제: Employee(부모)와 Manager, Developer(자식)를 배열에 넣고 총 급여 합계를 구하세요.
 */
public class Problem5 {
    public static void main(String[] args)
    {
        // TODO
        Employee[] e = {new Manager(15000),new Developer(20000),new Manager(25000),new Developer(50000)};

        int total_salary=0;

        for(Employee employee : e)
            total_salary+= employee.GetMoney();

        System.out.println("총 급여: " + total_salary);
    }

    static class Employee
    {
        int money;
        int GetMoney()
        {
           return money;
        }
    }

    static class Manager extends Employee
    {
        Manager(int money)
        {
            this.money = money;
        }
    }

    static class Developer extends Employee
    {
        Developer(int money)
        {
            this.money = money;
        }
    }

}
