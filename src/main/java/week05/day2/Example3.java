package week05.day2;

/**
 * [학습 예제 3] Week 05 Day 2 — 생성자(Constructor) 기초와 오버로딩
 * 
 * [학습 핵심 이론: 객체의 올바른 초기화 보장]
 * 3. 생성자 오버로딩 (Constructor Overloading):
 *    - 전달받는 매개변수의 개수, 순서, 타입 시그니처에 따라 여러 생성자를 한 클래스 내에 정의할 수 있습니다.
 * 
 * [문제별 학습 목표]
 * - Lab3: 매개변수 개수에 따른 생성자 오버로딩 (Problem 3 연계)
 */
public class Example3 {
    public static void main(String[] args) {
        Phone p1 = new Phone("갤럭시 S23");
        Phone p2 = new Phone("갤럭시 S23", "크림");
        Phone p3 = new Phone("갤럭시 S23", "라벤더", 1150000);

        p1.showPhoneInfo();
        p2.showPhoneInfo();
        p3.showPhoneInfo();
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
}
