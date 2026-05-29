package week09.day2;

import java.util.function.Consumer;

public class Answer3 {
    public static void main(String[] args) {
        // Consumer는 하나의 인자(T)를 받고 반환값이 없는 함수형 인터페이스입니다. (주로 출력이나 상태 변경에 사용)
        // 이 람다식은 정수(n)를 입력받아 그 값을 포함한 문자열을 콘솔에 출력합니다.
        Consumer<Integer> printer = n -> System.out.println("입력값: " + n);
        
        // accept 메서드를 호출하여 100을 전달하고 람다식에 정의된 출력 동작을 수행합니다.
        printer.accept(100);
    }
}
