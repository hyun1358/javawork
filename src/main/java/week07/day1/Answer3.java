package week07.day1;

public class Answer3 {
    public static void main(String[] args) {
        try {
            int num = Integer.parseInt("ABC");
        } catch (NumberFormatException e) {
            System.out.println("숫자로 변환할 수 없습니다.");
        }
    }
}
