package week05.day2;

/**
 * [학습 예제 4] Week 05 Day 2 — 생성자(Constructor) 기초와 오버로딩
 * 
 * [학습 핵심 이론: 객체의 올바른 초기화 보장]
 * 4. 생성자 체이닝 (Constructor Chaining, `this()`):
 *    - 같은 클래스 내의 다른 생성자를 호출하여 중복 작성된 초기화 로직을 결합하고 누수를 방지합니다.
 *    - 반드시 생성자 블록의 **첫 번째 줄(First Line)**에 기술되어야만 구문 오류가 발생하지 않습니다.
 * 
 * [문제별 학습 목표]
 * - Lab4: this()를 이용한 생성자 체이닝(기본값 자동 주입) (Problem 4 연계)
 */
public class Example4 {
    public static void main(String[] args) {
        Computer com = new Computer("삼성");
        com.showComputerInfo(); // CPU: i5, RAM: 8GB 기본값 확인
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
}
