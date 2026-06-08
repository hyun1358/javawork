package week05.day3;

/**
 * [학습 예제 1] Week 05 Day 3 — 접근 제어자와 캡슐화
 * 
 * [학습 핵심 이론: 객체의 자율성과 정보 은닉]
 * 3. 캡슐화 (Encapsulation)와 Getter/Setter:
 *    - 데이터를 private 필드로 감추고, 안전하고 검증된 통로인 public Getter(조회)와 Setter(값 입력 시 유효성 체크 적용) 메서드를 통해서만 제어할 수 있도록 캡슐화합니다.
 * 
 * [문제별 학습 목표]
 * - Lab1: Dog 클래스의 getter / setter (Problem 1 연계)
 */
public class Example1 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.setDogName("복돌이");
        System.out.println("강아지 이름: " + dog.getDogName());
    }

    // Problem 1: Dog 클래스 캡슐화
    static class Dog {
        private String name;

        // getter
        public String getDogName() {
            return this.name;
        }

        // setter
        public void setDogName(String name) {
            this.name = name;
        }
    }
}
