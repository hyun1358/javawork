package week05.day2;

/*
 * [정답 + 해설 3] Week 05 Day 2
 * 문제: 생성자 오버로딩
 */
public class Answer3 {
    public static void main(String[] args) {
        Phone p1 = new Phone("갤럭시 S24");
        Phone p2 = new Phone("아이폰 15", "블루");
        Phone p3 = new Phone("픽셀 8", "블랙", 1000000);

        p1.info();
        p2.info();
        p3.info();
    }
}

class Phone {
    String model;
    String color;
    int price;

    Phone(String m) {
        model = m;
        color = "화이트"; // 기본값
    }

    Phone(String m, String c) {
        model = m;
        color = c;
    }

    Phone(String m, String c, int p) {
        model = m;
        color = c;
        price = p;
    }

    void info() {
        System.out.println("모델: " + model + ", 색상: " + color + ", 가격: " + price + "원");
    }
}
