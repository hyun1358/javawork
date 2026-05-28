package week05.day4;

/**
 * [예습 파일] Week 05 Day 4 — static (공유 변수와 메서드)
 * 
 * [핵심 개념: 인스턴스가 아닌 클래스 레벨의 자원]
 * 1. static 키워드 정의:
 *    - 객체(인스턴스)를 생성하지 않아도 메모리에 자동으로 미리 상주하여 클래스 이름만으로 다이렉트 접근 및 제어가 가능한 정적 자원입니다.
 * 
 * 2. 메모리 상의 정적 데이터 할당:
 *    - static 멤버는 JVM이 클래스 파일 로딩 단계 시 Method Area(메서드 영역) 내의 정적 데이터 존에 단 한 번만 생성하며, 애플리케이션 종료 시까지 모든 인스턴스가 주소값을 타고 들어와 하나의 데이터를 공동으로 공유합니다.
 * 
 * 3. static 메서드 내부의 제약:
 *    - static 메서드는 객체가 아예 생성되지 않은 런타임 시작 시점에도 호출될 수 있으므로, 메서드 내부에서 특정 객체에 귀속된 '인스턴스 변수(Instance Variable)'나 'this' 레퍼런스는 절대 사용할 수 없습니다!
 */
public class Preview {
    public static void main(String[] args) {
        // 1. static 변수 접근 (객체 생성 없이 가능)
        System.out.println("현재 학생 수: " + Student.count);

        Student s1 = new Student("홍길동");
        Student s2 = new Student("이순신");

        System.out.println("학생 추가 후 수: " + Student.count);

        // 2. static 메서드 호출 (Math 클래스처럼 사용)
        int result = Calculator.add(10, 20);
        System.out.println("계산 결과: " + result);
    }
}

class Student {
    static int count = 0; // 모든 학생 객체가 공유하는 변수
    String name;

    Student(String name) {
        this.name = name;
        count++; // 학생이 생성될 때마다 카운트 증가
    }
}

class Calculator {
    static int add(int a, int b) {
        return a + b;
    }
}
