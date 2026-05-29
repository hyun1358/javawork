package week09.day1;

// 사용자 정의 함수형 인터페이스와 람다식을 활용하는 예제 클래스입니다.
public class Answer5 {
    public static void main(String[] args) {
        // Printer 인터페이스의 print 메서드를 람다식으로 구현합니다.
        // 입력받은 msg 앞에 "메시지: "를 붙여서 콘솔에 출력하도록 정의합니다.
        Printer p = msg -> System.out.println("메시지: " + msg);
        
        // for 루프를 사용하여 1부터 3까지 반복합니다.
        for (int i = 1; i <= 3; i++) {
            // 구현된 람다식을 호출하여 메시지를 출력합니다.
            p.print("테스트 " + i);
        }
    }
}

// 문자열을 입력받아 동작을 수행하는 단일 추상 메서드를 가진 함수형 인터페이스입니다.
interface Printer {
    void print(String msg);
}
