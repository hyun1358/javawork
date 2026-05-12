package week09.day1;

public class Answer5 {
    public static void main(String[] args) {
        Printer p = msg -> System.out.println("메시지: " + msg);
        for (int i = 1; i <= 3; i++) {
            p.print("테스트 " + i);
        }
    }
}

interface Printer {
    void print(String msg);
}
