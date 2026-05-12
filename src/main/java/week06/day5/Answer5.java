package week06.day5;

public class Answer5 {
    public static void main(String[] args) {
        Clickable[] btns = {new Button(), new Link()};
        for (Clickable c : btns) c.click();
    }
}

interface Clickable {
    void click();
}

class Button implements Clickable {
    public void click() {
        System.out.println("버튼 클릭");
    }
}

class Link implements Clickable {
    public void click() {
        System.out.println("링크 클릭");
    }
}
