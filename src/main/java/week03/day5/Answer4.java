package week03.day5;

public class Answer4 {
    public static void main(String[] args) {
        String[] words = {"Apple", "Book", "Car", "Java", "Python"};
        int idx = (int) (Math.random() * words.length);
        System.out.println("랜덤 단어: " + words[idx]);
    }
}
