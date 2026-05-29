package week05.day2;

/*
 * [정답 + 해설 5] Week 05 Day 2
 * 문제: 종합 생성자 실습
 */
public class Answer5 {
    public static void main(String[] args) {
        // Employee 생성자를 호출하여 직원 객체 e1, e2를 생성하고 속성을 초기화합니다.
        Employee e1 = new Employee("홍길동", "개발팀", 5000);
        Employee e2 = new Employee("김철수", "인사팀", 4500);

        // show() 메서드를 통해 생성된 객체의 세부 정보를 출력합니다.
        e1.show();
        e2.show();
    }
}

// [클래스 설명] Employee 클래스는 사원의 이름, 소속 부서, 연봉 데이터를 다루는 클래스입니다.
class Employee {
    String name;
    String dept;
    int salary;

    // [생성자 설명] 매개변수로 전달된 값을 this 키워드를 사용해 객체 자신의 필드에 할당합니다.
    Employee(String name, String dept, int salary) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

    // [메서드 설명] 사원의 정보(이름, 부서, 연봉)를 문자열로 구성하여 화면에 출력합니다.
    void show() {
        System.out.println("사원명: " + name + ", 부서: " + dept + ", 연봉: " + salary);
    }
}
