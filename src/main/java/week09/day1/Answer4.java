package week09.day1;

import java.util.*;
import java.util.function.Consumer;

// Consumer 인터페이스와 메서드 참조(Method Reference)를 사용하는 예제 클래스입니다.
public class Answer4 {
    public static void main(String[] args) {
        // 1. 람다식을 사용한 방식
        // 입력값 x를 받아 그대로 콘솔에 출력하는 Consumer를 구현합니다.
        Consumer<String> c1 = x -> System.out.println(x);
        
        // 2. 메서드 참조를 사용한 방식
        // 람다식이 단순히 기존 메서드를 호출하기만 할 경우, 메서드 참조(::)로 더 간결하게 표현할 수 있습니다.
        Consumer<String> c2 = System.out::println; // 메서드 참조
        
        // 구현된 메서드 참조를 실행하여 문자열을 출력합니다.
        c2.accept("메서드 참조 테스트");
    }
}
