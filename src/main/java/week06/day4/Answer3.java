package week06.day4;

// [클래스 설명] 추상 클래스는 직접 인스턴스화(객체 생성)할 수 없다는 것을 확인하는 예제입니다.
public class Answer3 {
    public static void main(String[] args) {
        // [로직 설명] 추상 클래스에는 미완성된 추상 메서드가 포함될 수 있기 때문에,
        // new 키워드를 통해 직접 메모리에 객체를 생성하려고 하면 컴파일 에러가 발생합니다.
        // Shape s = new Shape(); // Cannot instantiate the type Shape 컴파일 에러 발생
        
        System.out.println("추상 클래스는 미완성 설계도라 객체 생성이 안됩니다.");
    }
}
