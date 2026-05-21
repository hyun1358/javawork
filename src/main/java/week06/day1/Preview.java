package week06.day1;

/**
 * [예습 파일] Week 06 Day 1 — 상속(Inheritance) 기초
 * 
 * 상속은 기존의 클래스(부모)가 가진 속성과 기능을 그대로 물려받아
 * 새로운 클래스(자식)를 만드는 기법입니다. (코드 재사용)
 * 
 * [핵심 용어]
 * 1. 부모 클래스 (Parent/Super Class) : 기능을 물려주는 클래스.
 * 2. 자식 클래스 (Child/Sub Class) : 기능을 물려받는 클래스.
 * 3. extends : "나 누구누구한테 물려받을래!"라고 선언하는 키워드.
 */
public class Preview {
    public static void main(String[] args) {
        // 자식 객체를 만듭니다.
        Dog myDog = new Dog();

        // 1. 부모로부터 물려받은 '이름' 필드를 그대로 씁니다.
        myDog.name = "바둑이"; 
        
        // 2. 부모로부터 물려받은 '먹기' 기능을 씁니다.
        myDog.eat(); 

        // 3. 자식만 가진 '소리내기' 기능을 씁니다.
        myDog.sound();       
    }
}

/**
 * [부모 클래스] 일반적인 동물
 */
class Animal {
    String name;

    void eat() {
        System.out.println(name + "가 밥을 아주 맛있게 먹습니다.");
    }
}

/**
 * [자식 클래스] 동물 중에서도 강아지
 * extends Animal : "Animal 클래스의 모든 걸 물려받겠다"는 뜻!
 */
class Dog extends Animal {
    void sound() {
        System.out.println("멍멍! (꼬리를 흔듭니다)");
    }
}
