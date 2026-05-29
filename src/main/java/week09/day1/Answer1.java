package week09.day1;

// 두 수 중 큰 값을 찾는 함수형 인터페이스와 람다식을 사용하는 예제 클래스입니다.
public class Answer1 {
    public static void main(String[] args) {
        // 람다식을 사용하여 MaxFinder 인터페이스의 getMax 메서드를 구현합니다.
        // 삼항 연산자를 사용하여 a가 b보다 크면 a를, 그렇지 않으면 b를 반환합니다.
        MaxFinder m = (a, b) -> a > b ? a : b;
        
        // 구현된 람다식을 호출하여 두 수 중 큰 값을 출력합니다.
        System.out.println("큰 수: " + m.getMax(10, 20));
    }
}

// 함수형 인터페이스임을 나타내는 어노테이션입니다.
// 단 하나의 추상 메서드만 가질 수 있도록 강제합니다.
@FunctionalInterface
interface MaxFinder {
    // 두 정수를 입력받아 정수를 반환하는 추상 메서드입니다.
    int getMax(int a, int b);
}
