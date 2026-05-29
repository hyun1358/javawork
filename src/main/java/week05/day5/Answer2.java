package week05.day5;

public class Answer2 {
    public static void main(String[] args) {
        // 객체를 생성하면서 생성자를 통해 불변 필드의 값을 초기화합니다.
        ImmutableBook b = new ImmutableBook("Java", 30000);
        
        // 초기화된 final 필드의 값을 읽어서 출력합니다. (이후 수정은 불가능합니다.)
        System.out.println(b.title);
    }
}

// [클래스 설명] 객체가 생성된 후 상태가 변하지 않는 불변 객체(Immutable Object)를 설계하는 예제입니다.
class ImmutableBook {
    // [필드 설명] final 키워드가 붙어 있어 한 번 값이 할당되면 이후에 변경할 수 없습니다.
    final String title;
    final int price;

    // [생성자 설명] final 필드는 선언 시 초기화하거나, 반드시 생성자에서 한 번 초기화해주어야 합니다.
    ImmutableBook(String title, int price) {
        this.title = title;
        this.price = price;
    }
}
