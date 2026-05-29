package week09.day2;

import java.util.function.Supplier;

public class Answer4 {
    public static void main(String[] args) {
        // Supplier는 매개변수 없이 값을 반환(T)하는 함수형 인터페이스입니다. (주로 값을 생성하거나 제공할 때 사용)
        // 이 람다식은 호출될 때마다 1부터 10 사이의 임의의 정수(난수)를 생성하여 반환합니다.
        Supplier<Integer> rand = () -> (int) (Math.random() * 10) + 1;
        
        // get 메서드를 호출하여 생성된 난수를 가져오고 그 값을 콘솔에 출력합니다.
        System.out.println("난수: " + rand.get());
    }
}
