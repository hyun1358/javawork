package week05.day3;

/**
 * [학습 예제 2] Week 05 Day 3 — 접근 제어자와 캡슐화
 * 
 * [학습 핵심 이론: 객체의 자율성과 정보 은닉]
 * 1. 정보 은닉 (Information Hiding):
 *    - 외부에서 객체의 내부 핵심 데이터(필드)에 직접 마음대로 접근하여 예기치 않은 조작이나 무효한 상태값을 주입하는 것을 철저히 차단합니다.
 * 
 * [문제별 학습 목표]
 * - Lab2: Person 클래스의 setter 나이 유효성 검증 (Problem 2 연계)
 */
public class Example2 {
    public static void main(String[] args) {
        Person person = new Person();
        person.setAge(15);
        System.out.println("나이 설정(15세): " + person.getAge());
        
        person.setAge(-23); // 음수 설정 시도 -> 경고 출력
        System.out.println("음수 설정 시도 후 나이: " + person.getAge() + " [값이 오염되지 않고 유지됨]");
    }

    // Problem 2: Person 클래스 유효성 검증
    static class Person {
        private int age;

        public int getAge() {
            return this.age;
        }

        public void setAge(int age) {
            if (age < 0) {
                System.out.println("경고: 잘못된 입력 (나이는 음수가 될 수 없습니다.)");
            } else {
                this.age = age;
            }
        }
    }
}
