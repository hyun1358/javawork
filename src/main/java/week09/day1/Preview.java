package week09.day1;

/**
 * [예습 파일] Week 09 Day 1 — 람다식(Lambda Expression) 기초
 * 
 * 람다식은 '함수(메서드)'를 하나의 '식(Expression)'으로 표현한 것입니다.
 * 코드를 훨씬 간결하고 가독성 좋게 만들어줍니다.
 * 
 * [람다식의 특징]
 * 1. 메서드 이름이 없습니다 (익명 함수).
 * 2. 인터페이스의 메서드를 아주 짧게 구현할 수 있습니다.
 * 3. 화살표(->)를 사용하여 '매개변수 -> 실행코드' 형태로 작성합니다.
 * 
 * [람다식을 쓸 수 있는 조건]
 * - 인터페이스에 추상 메서드가 딱 '하나'만 있어야 합니다. 
 * - 이런 인터페이스를 @FunctionalInterface (함수형 인터페이스)라고 부릅니다.
 */
public class Preview {
    public static void main(String[] args) {
        // 1. 기존 익명 클래스 방식 (코드가 길고 복잡함)
        MyFunc legacyFunc = new MyFunc() {
            @Override
            public int calc(int a, int b) {
                return a + b;
            }
        };

        // 2. 람다식 방식 (획기적으로 짧아짐!)
        // (a, b)는 매개변수, -> 뒤는 리턴될 값입니다.
        MyFunc lambdaFunc = (a, b) -> a + b;

        System.out.println("1. 기존 방식 결과: " + legacyFunc.calc(10, 20));
        System.out.println("2. 람다 방식 결과: " + lambdaFunc.calc(10, 20));
        
        // 빼기 연산도 람다로 바로 만들 수 있습니다.
        MyFunc subFunc = (a, b) -> a - b;
        System.out.println("3. 빼기 람다 결과: " + subFunc.calc(50, 20));
    }
}

/**
 * 함수형 인터페이스 정의
 */
@FunctionalInterface
interface MyFunc {
    int calc(int a, int b);
}
