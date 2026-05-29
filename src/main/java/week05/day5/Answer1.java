package week05.day5;

// [클래스 설명] 상수를 정의하고 활용하는 방법을 보여주는 예제입니다.
public class Answer1 {
    // [필드 설명] static final 키워드를 사용하여 변하지 않는 상수(PI)를 정의합니다. 관례상 대문자로 작성합니다.
    static final double PI = 3.14;

    // [메서드 설명] 원의 넓이를 계산하여 출력하는 메인 메서드입니다.
    public static void main(String[] args) {
        int r = 5; // 원의 반지름
        // 계산 과정에서 상수로 선언된 PI를 사용하여 넓이를 계산하고 출력합니다.
        System.out.println("넓이: " + (PI * r * r));
    }
}
