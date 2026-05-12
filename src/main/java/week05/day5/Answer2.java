package week05.day5;

public class Answer2 {
    public static void main(String[] args) {
        ImmutableBook b = new ImmutableBook("Java", 30000);
        System.out.println(b.title);
    }
}

class ImmutableBook {
    final String title;
    final int price;

    ImmutableBook(String title, int price) {
        this.title = title;
        this.price = price;
    }
}
