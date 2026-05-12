package week07.day5;

public class Answer1 {
    public static void main(String[] args) {
        String s = "level";
        String rev = new StringBuilder(s).reverse().toString();
        System.out.println("회문 여부: " + s.equals(rev));
    }
}
