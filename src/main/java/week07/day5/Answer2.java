package week07.day5;

public class Answer2 {
    public static void main(String[] args) {
        String s = "apple banana apple orange apple";
        String target = "apple";
        int count = s.split(target, -1).length - 1;
        System.out.println("apple 개수: " + count);
    }
}
