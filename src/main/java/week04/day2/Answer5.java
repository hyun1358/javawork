package week04.day2;

public class Answer5 {
    public static void main(String[] args) {
        greet("홍길동");
        greet();
    }

    public static void greet(String name) {
        System.out.println("안녕하세요, " + name + "님!");
    }

    public static void greet() {
        greet("손님"); // 코드 중복 제거를 위해 다른 메서드 호출
    }
}
