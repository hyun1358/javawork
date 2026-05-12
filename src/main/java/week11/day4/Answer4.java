package week11.day4;

public class Answer4 {
    public static void main(String[] args) {
        oldMethod(); // IDE에서 취소선이 그어집니다.
    }

    @Deprecated
    public static void oldMethod() {
        System.out.println("구버전");
    }
}
