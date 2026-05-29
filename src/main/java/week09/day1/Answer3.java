package week09.day1;

// 매개변수가 없고 반환값도 없는 형태의 람다식을 사용하는 예제 클래스입니다.
public class Answer3 {
    public static void main(String[] args) {
        // Runnable 인터페이스의 run 메서드를 람다식으로 구현합니다.
        // 실행 시 "Hello Lambda!" 문자열을 콘솔에 출력하도록 정의합니다.
        Runnable r = () -> System.out.println("Hello Lambda!");
        
        // 구현된 람다식(메서드)을 실행합니다.
        r.run();
    }
}
