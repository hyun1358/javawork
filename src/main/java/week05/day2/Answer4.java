package week05.day2;

/*
 * [정답 + 해설 4] Week 05 Day 2
 * 문제: this() 생성자 체이닝
 */
public class Answer4 {
    public static void main(String[] args) {
        // 브랜드 이름만 전달하여 Computer 객체를 생성합니다.
        // 이때 내부적으로 this() 체이닝을 통해 다른 생성자가 연쇄 호출됩니다.
        Computer c = new Computer("삼성");
        
        // 초기화된 컴퓨터 객체의 상태를 출력합니다.
        c.info();
    }
}

// [클래스 설명] Computer 클래스는 this() 생성자 체이닝을 통해 중복 코드를 줄이는 방법을 보여줍니다.
class Computer {
    String brand;
    String cpu;
    int ram;

    // [생성자 설명] 브랜드만 입력받는 생성자입니다.
    Computer(String brand) {
        // this()를 사용해 3개의 매개변수를 받는 생성자를 호출하여 나머지 필드를 기본값으로 설정합니다.
        this(brand, "i5", 8); // 다른 생성자 호출
    }

    // [생성자 설명] 브랜드, CPU, RAM을 모두 입력받아 초기화하는 주 생성자입니다.
    Computer(String brand, String cpu, int ram) {
        this.brand = brand;
        this.cpu = cpu;
        this.ram = ram;
    }

    // [메서드 설명] 컴퓨터의 전체 스펙 정보를 출력합니다.
    void info() {
        System.out.println("브랜드: " + brand + ", CPU: " + cpu + ", RAM: " + ram + "GB");
    }
}
/*
 * [해설]
 * - this()는 반드시 생성자의 첫 줄에 작성해야 합니다.
 * - 한 생성자에서 다른 생성자를 호출함으로써 중복되는 초기화 코드를 한 곳에서 관리할 수 있습니다.
 */
