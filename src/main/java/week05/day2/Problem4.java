package week05.day2;

/**
 * [연습 문제 4] Week 05 Day 2
 * <p>
 * 문제: this()를 사용하여 생성자 체이닝을 구현하세요.
 * 1. Computer 클래스: brand, cpu, ram 필드
 * 2. 매개변수 3개짜리 생성자를 만듭니다.
 * 3. 매개변수 1개짜리(brand) 생성자에서 this()를 사용해 3개짜리 생성자를 호출하세요.
 * (기본 CPU는 "i5", RAM은 8로 설정)
 * <p>
 * 난이도: ★★★☆☆
 */
public class Problem4 {
    public static void main(String[] args) {
        // TODO: 브랜드만 넣어서 Computer 객체를 생성해보고 CPU와 RAM이 기본값으로 들어갔는지 확인하세요.
        Computer com = new Computer("SAMSUNG");
        com.init();

    }

    static class Computer {
        String brand, cpu;
        int ram;

        Computer(String brand) {
            this(brand, "i5", 8);
        }

        Computer(String brand, String cpu, int ram) {
            this.brand = brand;
            this.cpu = cpu;
            this.ram = ram;
        }

        void init() {
            System.out.println("브랜드 : " + this.brand + ", cpu : " + this.cpu + ", ram: " + this.ram);
        }
    }
}
