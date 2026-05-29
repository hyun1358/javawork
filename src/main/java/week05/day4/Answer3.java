package week05.day4;

// [클래스 설명] static 컨텍스트(예: main 메서드)에서 인스턴스 멤버에 접근하는 방법을 보여주는 예제입니다.
public class Answer3 {
    // [필드 설명] static이 없는 인스턴스 변수로, 객체가 생성되어야만 메모리에 할당됩니다.
    int value = 10;

    // [메서드 설명] 프로그램의 시작점인 main 메서드는 메모리에 가장 먼저 올라가는 static 메서드입니다.
    public static void main(String[] args) {
        // [로직 설명] static 메서드 안에서는 인스턴스 변수에 직접 접근할 수 없으므로,
        // 해결방법: 객체를 생성한 후 참조를 통해 접근해야 합니다.
        Answer3 obj = new Answer3();
        System.out.println(obj.value); // 생성된 객체의 참조를 통해 value 값을 출력합니다.
    }
}
