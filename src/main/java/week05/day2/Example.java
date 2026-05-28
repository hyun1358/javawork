package week05.day2;

/**
 * [학습 예제] Week 05 Day 2 — 생성자(Constructor) 기초와 오버로딩 (Book 초기화, Movie의 this 필드 매핑, Phone 생성자 오버로딩, Computer 생성자 체이닝, Employee 일괄 초기화)
 * 
 * [학습 핵심 이론: 객체의 올바른 초기화 보장]
 * 1. 생성자(Constructor)의 역할:
 *    - 객체가 `new` 연산자로 생성될 때 최초로 호출되며, 멤버 변수(필드)를 유효한 값으로 초기화하는 역할을 담당합니다.
 *    - 클래스 이름과 완전히 같아야 하고, 반환 타입(void 포함)을 적지 않습니다.
 * 
 * 2. this 키워드:
 *    - 힙 메모리에 인스턴스화된 '자기 자신'을 가리키는 숨겨진 참조 주소 변수입니다.
 *    - 생성자나 메서드 내에서 매개변수(Parameter)와 필드(Field)의 이름이 똑같아서 발생하는 식별자 모호성(Shadowing)을 해결합니다. (Problem 2 연계)
 * 
 * 3. 생성자 오버로딩 (Constructor Overloading):
 *    - 전달받는 매개변수의 개수, 순서, 타입 시그니처에 따라 여러 생성자를 한 클래스 내에 정의할 수 있습니다. (Problem 3 연계)
 * 
 * 4. 생성자 체이닝 (Constructor Chaining, `this()`):
 *    - 같은 클래스 내의 다른 생성자를 호출하여 중복 작성된 초기화 로직을 결합하고 누수를 방지합니다.
 *    - 반드시 생성자 블록의 **첫 번째 줄(First Line)**에 기술되어야만 구문 오류가 발생하지 않습니다. (Problem 4 연계)
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Week 05 Day 2 학습 예제 ===\n");

        System.out.println("--- Lab1: 생성자를 통한 Book 객체 필드 초기화 (Problem 1 연계) ---");
        Lab1.run();

        System.out.println("\n--- Lab2: this 키워드로 생성자 매개변수-필드 이름 충돌 해결 (Problem 2 연계) ---");
        Lab2.run();

        System.out.println("\n--- Lab3: 매개변수 개수에 따른 생성자 오버로딩 (Problem 3 연계) ---");
        Lab3.run();

        System.out.println("\n--- Lab4: this()를 이용한 생성자 체이닝(기본값 자동 주입) (Problem 4 연계) ---");
        Lab4.run();

        System.out.println("\n--- Lab5: 완성도 높은 생성자를 통한 Employee 객체 선언 (Problem 5 연계) ---");
        Lab5.run();
    }

    // Problem 1: Book 클래스 정의
    static class Book {
        String title;
        String author;
        int price;

        Book(String title, String author, int price) {
            this.title = title;
            this.author = author;
            this.price = price;
        }

        void showBookInfo() {
            System.out.println("제목: " + title + ", 저자: " + author + ", 가격: " + price + "원");
        }
    }

    // Problem 2: Movie 클래스 정의
    static class Movie {
        String title;
        String genre;

        // this를 안 쓰면 title = title; 식은 매개변수가 매개변수 자신에 대입하는 효과만 납니다.
        Movie(String title, String genre) {
            this.title = title; // 이 인스턴스의 title 필드에 매개변수 title을 저장
            this.genre = genre; // 이 인스턴스의 genre 필드에 매개변수 genre를 저장
        }

        void showMovieInfo() {
            System.out.println("영화 제목: " + title + ", 장르: " + genre);
        }
    }

    // Problem 3: Phone 클래스 정의
    static class Phone {
        String model;
        String color;
        int price;

        // 생성자 1: 모델명만
        Phone(String model) {
            this.model = model;
            this.color = "미정";
            this.price = 0;
        }

        // 생성자 2: 모델명, 색상
        Phone(String model, String color) {
            this.model = model;
            this.color = color;
            this.price = 0;
        }

        // 생성자 3: 모델명, 색상, 가격
        Phone(String model, String color, int price) {
            this.model = model;
            this.color = color;
            this.price = price;
        }

        void showPhoneInfo() {
            System.out.println("모델: " + model + ", 색상: " + color + ", 가격: " + price + "원");
        }
    }

    // Problem 4: Computer 클래스 정의
    static class Computer {
        String brand;
        String cpu;
        int ram;

        // 매개변수 1개짜리 생성자 (brand만 받음)
        Computer(String brand) {
            // this() 생성자 체이닝을 사용해 3개짜리 생성자를 첫 라인에서 위임 호출
            // 기본 CPU는 "i5", RAM은 8로 설정
            this(brand, "i5", 8); 
        }

        // 매개변수 3개짜리 생성자
        Computer(String brand, String cpu, int ram) {
            this.brand = brand;
            this.cpu = cpu;
            this.ram = ram;
        }

        void showComputerInfo() {
            System.out.println("브랜드: " + brand + ", CPU: " + cpu + ", RAM: " + ram + "GB");
        }
    }

    // Problem 5: Employee 클래스 정의
    static class Employee {
        String name;
        String department;
        int salary;

        Employee(String name, String department, int salary) {
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        void showEmployeeInfo() {
            System.out.println("이름: " + name + ", 부서: " + department + ", 급여: " + salary + "원");
        }
    }

    static class Lab1 {
        static void run() {
            Book book = new Book("자바의 정석", "남궁성", 30000);
            book.showBookInfo();
        }
    }

    static class Lab2 {
        static void run() {
            Movie movie = new Movie("어벤져스", "SF/액션");
            movie.showMovieInfo();
        }
    }

    static class Lab3 {
        static void run() {
            Phone p1 = new Phone("갤럭시 S23");
            Phone p2 = new Phone("갤럭시 S23", "크림");
            Phone p3 = new Phone("갤럭시 S23", "라벤더", 1150000);

            p1.showPhoneInfo();
            p2.showPhoneInfo();
            p3.showPhoneInfo();
        }
    }

    static class Lab4 {
        static void run() {
            Computer com = new Computer("삼성");
            com.showComputerInfo(); // CPU: i5, RAM: 8GB 기본값 확인
        }
    }

    static class Lab5 {
        static void run() {
            Employee emp1 = new Employee("홍길동", "개발팀", 3500000);
            Employee emp2 = new Employee("김철수", "인사팀", 2800000);
            emp1.showEmployeeInfo();
            emp2.showEmployeeInfo();
        }
    }
}
