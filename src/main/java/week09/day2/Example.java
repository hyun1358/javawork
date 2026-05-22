package week09.day2;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * [학습 예제] Week 09 Day 2 — Consumer(소비자)와 Supplier(공급자) 및 BiFunction(두 매개변수 함수)
 * 
 * 1. Consumer<T> (소비자):
 *    - <T> 타입을 받아서 '사용'만 하고 아무것도 돌려주지 않습니다. (리턴값 없음)
 *    - 실행 메서드: .accept(value)
 *    - 용도: 출력하기, DB에 저장하기, 로그 남기기 등
 * 
 * 2. Supplier<T> (공급자):
 *    - 아무것도 받지 않고(매개변수 없음), <T> 타입의 값을 '제공'만 합니다.
 *    - 실행 메서드: .get()
 *    - 용도: 랜덤값 생성, 현재 시간 가져오기, 초기 설정값 제공 등
 * 
 * 3. BiFunction<T, U, R> (두 개의 입력값을 가진 함수):
 *    - <T> 타입과 <U> 타입 두 개를 받아서 가공한 뒤 <R> 타입을 리턴합니다.
 *    - 실행 메서드: .apply(t, u)
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Lab 1: Consumer (받아서 출력하기) ===");
        // String을 받아서 출력만 하는 소비자 생성
        Consumer<String> greeter = name -> System.out.println("안녕하세요, " + name + "님!");
        
        // .accept()로 값을 전달하면 람다식이 실행됩니다.
        greeter.accept("홍길동");
        greeter.accept("이순신");

        System.out.println("\n=== Lab 2: Supplier (데이터 공급받기) ===");
        // 매개변수 없이 () -> 로 시작하며, 랜덤 숫자를 돌려주는 공급자 생성
        Supplier<Double> randomNum = () -> Math.random();
        
        // .get()을 호출할 때마다 새로운 값을 생성해서 가져옵니다.
        System.out.println("첫 번째 랜덤값: " + randomNum.get());
        System.out.println("두 번째 랜덤값: " + randomNum.get());

        System.out.println("\n=== Lab 3: BiFunction (두 수의 곱 계산하기) ===");
        BiFunction<Integer, Integer, Integer> multiply = (x, y) -> x * y;
        System.out.println("10 * 20 = " + multiply.apply(10, 20));
    }
}
