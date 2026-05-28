package week07.day3;

/**
 * [예습 파일] Week 07 Day 3 — throw와 throws
 * 
 * [핵심 개념: 예외 생성과 책임 전가]
 * 1. throw 키워드 (예외의 능동적 발생):
 *    - `throw new IllegalArgumentException("에러메시지");`와 같이 비즈니스 규칙에 위배되는 부적절한 흐름을 발견했을 때, JVM에게 명시적으로 예외 객체를 생성하여 던지는 직접 에러 유발 장치입니다.
 * 
 * 2. throws 키워드 (예외의 상위 전파):
 *    - 메서드 선언부 끝에 `void myMethod() throws IOException`와 같이 정의합니다.
 *    - 메서드 내부에서 발생할 수 있는 잠재적 위험 예외들을 자신이 직접 해결(try-catch)하지 않고, 이 메서드를 호출하게 되는 상위 호출자(Caller)에게 "이 예외들에 대한 대처를 대신 수행하라"며 책임을 떠넘기는 폭탄 돌리기식 설계 기법입니다.
 */
public class Preview {
    public static void main(String[] args) {
        try {
            checkAge(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("예외 처리 완료: " + e.getMessage());
        }
    }

    // 예외를 직접 발생시켜 위로 던집니다.
    public static void checkAge(int age) throws IllegalArgumentException {
        if (age < 0) {
            throw new IllegalArgumentException("나이는 음수가 될 수 없습니다.");
        }
        System.out.println("나이 유효");
    }
}
