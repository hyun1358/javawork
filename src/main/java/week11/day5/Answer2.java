package week11.day5;

import java.lang.reflect.Field;

// 리플렉션을 사용하여 private 필드에 접근하고 값을 읽어오는 예제입니다.
public class Answer2 {
    // 메인 메서드
    public static void main(String[] args) throws Exception {
        // 대상이 될 Dummy 객체를 생성합니다.
        Dummy d = new Dummy();
        // Dummy 클래스에서 이름이 "age"인 필드 객체를 가져옵니다.
        Field f = Dummy.class.getDeclaredField("age");
        // private 필드이므로 접근 가능하도록 설정합니다 (캡슐화 우회).
        f.setAccessible(true);
        // f.get(d)를 호출하여 객체 d의 age 필드 값을 읽어와 출력합니다.
        System.out.println("age 값: " + f.get(d));
    }
}

// 테스트용 클래스
class Dummy {
    // 외부에서 접근할 수 없는 private 필드
    private int age = 20;
}
