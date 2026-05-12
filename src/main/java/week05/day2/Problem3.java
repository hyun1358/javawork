package week05.day2;

/**
 * [연습 문제 3] Week 05 Day 2
 * <p>
 * 문제: Phone 클래스에 생성자 오버로딩을 구현하세요.
 * 1. 생성자 1: 모델명만 받음
 * 2. 생성자 2: 모델명과 색상을 받음
 * 3. 생성자 3: 모델명, 색상, 가격을 받음
 * <p>
 * 난이도: ★★☆☆☆
 */
public class Problem3 {
    public static void main(String[] args) {
        // TODO: 3가지 방식으로 객체를 생성해 보세요.
        Phone phone1 = new Phone("갤럭시 s3");
        phone1.init();
        Phone phone2 = new Phone("갤럭시 s3", "검정");
        phone2.init();
        Phone phone3 = new Phone("갤럭시 s3", "검정", 120000);
        phone3.init();

    }

    static class Phone {
        String model;
        String color;
        int price;

        Phone(String model) {
            this.model = model;
        }

        Phone(String model, String color) {
            this.model = model;
            this.color = color;
        }

        Phone(String model, String color, int price) {
            this.model = model;
            this.color = color;
            this.price = price;
        }

        void init() {
            System.out.println("모델 : " + this.model + ", 색상 : " + this.color + ", 가격 : " + this.price);
        }

    }
}
