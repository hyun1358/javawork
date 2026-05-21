package week05.day1;

/**
 * [예습 파일] Week 05 Day 1 — 클래스(Class)와 객체(Object) 기초
 * 
 * 자바는 '객체 지향' 언어입니다. 모든 것을 실제 물건처럼 다룹니다.
 * 
 * 1. 클래스 (설계도) : 붕어빵 틀입니다. 어떤 속성(맛, 가격)과 기능(굽기)이 있는지 정의만 합니다.
 * 2. 객체 (실체) : 틀에서 찍어낸 실제 붕어빵입니다. 메모리에 실제로 존재하며 우리가 만질 수 있습니다.
 * 
 * [객체 지향 3단계]
 * 1단계: 클래스(설계도)를 만든다.
 * 2단계: new 키워드로 객체(실체)를 만든다.
 * 3단계: 도트(.)를 써서 객체의 속성을 바꾸거나 기능을 쓴다.
 */
public class Preview {
    public static void main(String[] args) {
        // [2단계] 설계도를 보고 실제 붕어빵(객체) 하나를 만듭니다.
        Bread b1 = new Bread();

        // [3단계] 붕어빵의 속성을 정하고(필드), 정보를 보여달라고 시킵니다(메서드).
        b1.flavor = "슈크림";
        b1.price = 1500;
        b1.info();

        // 또 다른 붕어빵을 만들 수도 있습니다! (독립적인 존재)
        Bread b2 = new Bread();
        b2.flavor = "팥";
        b2.price = 1000;
        b2.info();
    }
}

/**
 * [1단계] 붕어빵 설계도
 */
class Bread {
    // [속성 - 필드]
    String flavor; 
    int price;     

    // [기능 - 메서드]
    void info() {
        System.out.println("=== 붕어빵 정보 ===");
        System.out.println("맛: " + flavor);
        System.out.println("가격: " + price + "원");
    }
}
