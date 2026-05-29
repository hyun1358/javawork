package week06.day1;

public class Answer3 {
    public static void main(String[] args) {
        // Manager 객체를 생성합니다.
        Manager m = new Manager();
        
        // 부모 클래스 Employee에서 상속받은 name 필드를 사용합니다.
        m.name = "김팀장";
        // 자식 클래스 Manager에 정의된 dept(부서) 필드를 사용합니다.
        m.dept = "개발팀";
        
        // 팀장 정보(이름, 부서)를 화면에 출력합니다.
        System.out.println(m.name + " " + m.dept);
    }
}

// [클래스 설명] 모든 직원이 공통으로 가지는 이름(name)과 급여(salary) 속성을 정의한 부모 클래스입니다.
class Employee {
    String name;
    int salary;
}

// [클래스 설명] Employee를 상속받아 관리자에게만 필요한 부서(dept) 정보를 추가로 확장한 클래스입니다.
class Manager extends Employee {
    String dept;
}

// [클래스 설명] Employee를 상속받아 개발자에게만 필요한 프로그래밍 언어(lang) 정보를 추가로 확장한 클래스입니다.
class Developer extends Employee {
    String lang;
}
