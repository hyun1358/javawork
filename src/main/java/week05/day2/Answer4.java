package week05.day2;

/*
 * [정답 + 해설 4] Week 05 Day 2
 * 문제: this() 생성자 체이닝
 */
public class Answer4 {
    public static void main(String[] args) {
        Computer c = new Computer("삼성");
        c.info();
    }
}

class Computer {
    String brand;
    String cpu;
    int ram;

    Computer(String brand) {
        this(brand, "i5", 8); // 다른 생성자 호출
    }

    Computer(String brand, String cpu, int ram) {
        this.brand = brand;
        this.cpu = cpu;
        this.ram = ram;
    }

    void info() {
        System.out.println("브랜드: " + brand + ", CPU: " + cpu + ", RAM: " + ram + "GB");
    }
}
/*
 * [해설]
 * - this()는 반드시 생성자의 첫 줄에 작성해야 합니다.
 * - 한 생성자에서 다른 생성자를 호출함으로써 중복되는 초기화 코드를 한 곳에서 관리할 수 있습니다.
 */
