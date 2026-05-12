package week04.day3;

public class Answer3 {
    public static void main(String[] args) {
        add(1, 2); // 더 구체적인 타입(int, int)이 우선순위를 갖습니다.
    }

    public static void add(int a, int b) {
        System.out.println("고정 인자 호출");
    }

    public static void add(int... nums) {
        System.out.println("가변 인자 호출");
    }
}
