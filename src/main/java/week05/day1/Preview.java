package week05.day1;

/**
 * [예습 파일] Week 05 Day 1 — 클래스와 객체 기초
 * <p>
 * ▶ 이 파일을 먼저 실행해보세요!
 * 오늘 배울 내용을 코드로 미리 구경할 수 있습니다.
 * 붕어빵 틀(클래스)과 실제 붕어빵(객체)의 비유를 코드로 확인해 봅시다.
 */
public class Preview {
    public static void main(String[] args) {
        // 1. 설계도(클래스)를 바탕으로 실제 물건(객체)을 만듭니다.
        // new 클래스명(); 형식으로 생성합니다.
        Bread myBread = new Bread();

        // 2. 객체의 속성(필드)에 값을 넣습니다.
        myBread.flavor = "슈크림";
        myBread.price = 1500;

        // 3. 객체의 기능(메서드)을 실행합니다.
        myBread.info();
        System.out.println("--- 오늘 배울 내용 미리보기 끝 ---");
    }
}

/**
 * 붕어빵을 만들기 위한 설계도 (클래스)
 */
class Bread {
    // [필드] 객체의 속성
    String flavor; // 맛
    int price;     // 가격

    // [메서드] 객체의 기능
    void info() {
        System.out.println("맛: " + flavor);
        System.out.println("가격: " + price + "원");
        System.out.println("따끈따끈한 " + flavor + " 붕어빵이 나왔습니다!");
    }
}
