package week05.day2;

/*
 * [정답 + 해설 3] Week 05 Day 2
 * 문제: 생성자 오버로딩
 */
public class Answer3 {
    public static void main(String[] args) {
        // 매개변수 개수와 타입이 다른 다양한 생성자를 통해 Phone 객체를 각각 생성합니다.
        Phone p1 = new Phone("갤럭시 S24"); // 모델명만 입력
        Phone p2 = new Phone("아이폰 15", "블루"); // 모델명과 색상 입력
        Phone p3 = new Phone("픽셀 8", "블랙", 1000000); // 모델명, 색상, 가격 모두 입력

        // 생성된 각 객체의 info() 메서드를 호출하여 상태를 출력합니다.
        p1.info();
        p2.info();
        p3.info();
    }
}

// [클래스 설명] Phone 클래스는 모델명, 색상, 가격 속성을 가지며 생성자 오버로딩을 보여줍니다.
class Phone {
    String model;
    String color;
    int price;

    // [생성자 설명] 모델명만 전달받아 초기화하고, 색상은 기본값("화이트")으로 설정합니다.
    Phone(String m) {
        model = m;
        color = "화이트"; // 기본값
    }

    // [생성자 설명] 모델명과 색상을 전달받아 초기화합니다.
    Phone(String m, String c) {
        model = m;
        color = c;
    }

    // [생성자 설명] 모델명, 색상, 가격을 모두 전달받아 초기화합니다.
    Phone(String m, String c, int p) {
        model = m;
        color = c;
        price = p;
    }

    // [메서드 설명] 스마트폰의 현재 속성 정보를 포맷팅하여 출력합니다.
    void info() {
        System.out.println("모델: " + model + ", 색상: " + color + ", 가격: " + price + "원");
    }
}
