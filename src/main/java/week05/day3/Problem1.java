package week05.day3;

/**
 * [연습 문제 1] getter/setter 만들기
 * 문제: Dog 클래스에 private String name 필드를 만들고
 * 이를 설정하고 가져오는 getter와 setter를 작성하세요.
 */
public class Problem1 {
    public static void main(String[] args) {
        // TODO: Dog 객체 생성 후 캡슐화된 필드 접근 테스트
        Dog dog = new Dog();
        dog.setDogName("복돌이");
        System.out.println(dog.getDogName());
    }
}

class Dog {
    private String name;
    // TODO: getter, setter 구현

    String getDogName() {
        return this.name;
    }

    void setDogName(String name) {
        this.name = name;
    }
}
