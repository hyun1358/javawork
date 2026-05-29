package week06.day3;

public class Answer5 {
    public static void main(String[] args) {
        // 부모 타입인 Employee 배열을 생성하여 서로 다른 자식 객체들을 그룹화합니다.
        Employee[] emps = {new Manager(5000), new Developer(4000)};
        int total = 0; // 총 급여를 누적할 변수
        
        // 다형성을 활용하여 각기 다른 직군의 객체를 동일한 Employee 타입으로 일괄 처리합니다.
        for (Employee e : emps) total += e.getSalary();
        System.out.println("총 급여: " + total);
    }
}

// [클래스 설명] 공통된 급여 속성과 급여 확인 메서드를 제공하는 부모 클래스입니다.
class Employee {
    int salary; // 기본 급여

    // [생성자 설명] 급여를 매개변수로 받아 초기화합니다.
    Employee(int s) {
        salary = s;
    }

    // [메서드 설명] 급여를 반환합니다.
    int getSalary() {
        return salary;
    }
}

// [클래스 설명] Employee를 상속받는 관리자 클래스입니다.
class Manager extends Employee {
    // [생성자 설명] 부모 생성자를 호출하여 초기화합니다.
    Manager(int s) {
        super(s);
    }
}

// [클래스 설명] Employee를 상속받는 개발자 클래스입니다.
class Developer extends Employee {
    // [생성자 설명] 부모 생성자를 호출하여 초기화합니다.
    Developer(int s) {
        super(s);
    }
}
