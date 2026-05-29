package week06.day5;

public class Answer5 {
    public static void main(String[] args) {
        // 인터페이스 타입 배열을 만들어, '클릭 가능한' 다양한 UI 컴포넌트들을 하나로 묶어 관리합니다.
        Clickable[] btns = {new Button(), new Link()};
        
        // 반복문을 돌며 일괄적으로 클릭 이벤트를 발생시킵니다. (인터페이스를 통한 다형성 활용)
        for (Clickable c : btns) c.click();
    }
}

// [인터페이스 설명] 마우스 클릭 등의 이벤트에 반응할 수 있는 기능을 정의하는 인터페이스입니다.
interface Clickable {
    // [메서드 설명] 클릭 시 수행할 동작을 자식 클래스에게 위임합니다.
    void click();
}

// [클래스 설명] 클릭 기능을 가지는 버튼 UI 요소입니다.
class Button implements Clickable {
    // [메서드 설명] 버튼이 클릭되었을 때의 고유한 반응을 구현합니다.
    public void click() {
        System.out.println("버튼 클릭");
    }
}

// [클래스 설명] 클릭 기능을 가지는 하이퍼링크 UI 요소입니다.
class Link implements Clickable {
    // [메서드 설명] 링크가 클릭되었을 때의 고유한 반응을 구현합니다.
    public void click() {
        System.out.println("링크 클릭");
    }
}
