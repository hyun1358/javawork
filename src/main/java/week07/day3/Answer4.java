package week07.day3;

public class Answer4 {
    public static void main(String[] args) {
        A();
    }

    public static void A() {
        try {
            B();
        } catch (Exception e) {
            System.out.println("A에서 잡음");
        }
    }

    public static void B() throws Exception {
        C();
    }

    public static void C() throws Exception {
        throw new Exception("에러 발생");
    }
}
