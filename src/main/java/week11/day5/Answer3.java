package week11.day5;

import java.lang.reflect.Method;
import java.util.Scanner;

// 리플렉션을 통해 특정 메서드를 동적으로 찾아 실행(invoke)하는 예제입니다.
public class Answer3 {
    // 메인 메서드
    public static void main(String[] args) throws Exception {
        // "Hello\n" 문자열을 입력 소스로 하는 Scanner 객체를 생성합니다.
        Scanner sc = new Scanner("Hello\n");
        // Scanner 클래스에서 매개변수가 없는 "nextLine"이라는 이름의 메서드 객체를 찾습니다.
        Method m = Scanner.class.getMethod("nextLine");
        // 찾은 메서드 객체를 sc 인스턴스를 대상으로 실행(invoke)합니다. 반환값은 Object이므로 String으로 캐스팅합니다.
        String result = (String) m.invoke(sc);
        // 실행 결과를 출력합니다.
        System.out.println("리플렉션으로 읽은 값: " + result);
    }
}
