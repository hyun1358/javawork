package week05.day4;

public class Answer1 {
    public static void main(String[] args) {
        // Circle 객체를 두 번 생성합니다. 
        // 객체가 생성될 때마다 생성자가 호출되어 정적 변수 count가 증가합니다.
        new Circle();
        new Circle();
        
        // 클래스 이름을 통해 정적 변수에 직접 접근하여 누적된 생성 횟수를 출력합니다.
        System.out.println("생성된 원의 개수: " + Circle.count);
    }
}

// [클래스 설명] Circle 클래스는 static 키워드를 사용하여 모든 객체가 공유하는 데이터를 다루는 예제입니다.
class Circle {
    // [필드 설명] 모든 Circle 객체가 공유하는 정적 변수입니다. 객체가 생성될 때마다 이 변수의 값이 누적됩니다.
    static int count = 0;

    // [생성자 설명] 객체가 생성될 때마다 자동으로 호출되어 공유 변수인 count를 1씩 증가시킵니다.
    Circle() {
        count++;
    }
}
