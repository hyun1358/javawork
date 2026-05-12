package week05.day5;

public class Answer4 {
    /*
     * final 매개변수: 메서드 내부에서 인자 값을 변경하지 못하게 함.
     * 실수를 방지하고 코드의 가독성을 높임.
     */
    static void print(final int n) {
        // n = 20; // 변경 불가!
        System.out.println(n);
    }

    public static void main(String[] args) {
        print(10);
    }
}
