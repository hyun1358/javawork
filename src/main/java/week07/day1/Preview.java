package week07.day1;

/**
 * [예습 파일] Week 07 Day 1 — 예외 처리(Exception Handling) 기초
 * 
 * 프로그램 실행 중에 예상치 못한 실수(0으로 나누기, 없는 파일 열기 등)가 발생하면 
 * 자바는 '예외'라는 에러를 던지며 프로그램을 강제 종료해 버립니다.
 * 
 * '예외 처리'는 이런 갑작스러운 죽음을 막고, 우아하게 대처하는 기술입니다.
 * 
 * [try-catch 구조]
 * 1. try { ... } : 에러가 날 가능성이 있는 코드를 넣어둡니다.
 * 2. catch (에러종류 e) { ... } : 에러가 발생하면 일로 슥 들어와서 뒷수습을 합니다.
 * 3. 에러가 나도 프로그램은 죽지 않고 catch 문 아래 코드를 계속 실행합니다.
 */
public class Preview {
    public static void main(String[] args) {
        System.out.println("--- 프로그램 시작 ---");

        try {
            // [에러 유발] 수학적으로 0으로 나눌 수 없습니다.
            int result = 10 / 0; 
            System.out.println("나눗셈 결과: " + result); // 실행 안 됨
            
        } catch (ArithmeticException e) {
            // ArithmeticException : 산술 연산 에러가 났을 때 들어옵니다.
            System.out.println("[수습] 아하, 0으로 나누려고 하셨군요! 안 돼요~");
            System.out.println("에러 메시지: " + e.getMessage());
        }

        System.out.println("--- 프로그램이 죽지 않고 무사히 종료되었습니다 ---");
    }
}
