package week07.day3;

/**
 * 예외 전파(Exception Propagation)를 보여주는 예제입니다. 여러 메서드를 거쳐 예외가 전달됩니다.
 */
public class Answer4 {
    public static void main(String[] args) {
        // A 메서드를 호출하여 예외 전파 테스트를 시작합니다.
        A();
    }

    public static void A() {
        try {
            // B 메서드를 호출합니다. B가 던진 예외는 여기서 처리됩니다.
            B();
        } catch (Exception e) {
            System.out.println("A에서 잡음");
        }
    }

    // throws로 C 메서드에서 발생한 예외를 A 메서드로 떠넘깁니다.
    public static void B() throws Exception {
        C();
    }

    // 예외를 직접 처리하지 않고 throws 키워드를 통해 B 메서드로 던집니다.
    public static void C() throws Exception {
        throw new Exception("에러 발생");
    }
}
