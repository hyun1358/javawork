package week04.day2;

public class Answer5 {
    // 메인 메서드: 메서드 오버로딩(Overloading)의 동작 확인
    public static void main(String[] args) {
        // 매개변수가 있는 greet() 호출
        greet("홍길동");
        // 매개변수가 없는 greet() 호출
        greet();
    }

    // greet 메서드 1: 문자열을 매개변수로 받는 버전
    public static void greet(String name) {
        // 전달받은 이름을 넣어 인사말 출력
        System.out.println("안녕하세요, " + name + "님!");
    }

    // greet 메서드 2: 매개변수가 없는 버전 (메서드 오버로딩)
    public static void greet() {
        // 기본값인 "손님"을 넣어 매개변수가 있는 greet() 메서드를 재호출
        greet("손님"); // 코드 중복 제거를 위해 다른 메서드 호출
    }
}
