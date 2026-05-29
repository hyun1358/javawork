package week04.day3;

public class Answer3 {
    // 메인 메서드: 고정 인자와 가변 인자가 함께 오버로딩되었을 때의 호출 규칙 확인
    public static void main(String[] args) {
        // 두 개의 정수를 전달할 때, 가변 인자보다 정확히 개수가 일치하는(더 구체적인 타입의) 
        // 메서드가 우선적으로 선택됩니다.
        add(1, 2); // 더 구체적인 타입(int, int)이 우선순위를 갖습니다.
    }

    // add 메서드 오버로딩 1: 매개변수의 개수가 고정된 형태 (int 2개)
    public static void add(int a, int b) {
        System.out.println("고정 인자 호출");
    }

    // add 메서드 오버로딩 2: 매개변수의 개수가 동적인 가변 인자 형태 (int... 개)
    public static void add(int... nums) {
        System.out.println("가변 인자 호출");
    }
}
