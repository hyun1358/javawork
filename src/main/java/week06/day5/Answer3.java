package week06.day5;

public class Answer3 {
    public static void main(String[] args) {
        // 인터페이스 타입(Printable) 변수로 구현체(Document) 객체를 받습니다.
        // 이를 통해 출력 가능한 모든 객체를 일관된 방법으로 처리할 수 있습니다.
        Printable p = new Document();
        
        // 구현된 출력 기능을 실행합니다.
        p.print();
    }
}

// [인터페이스 설명] 무언가를 출력할 수 있다는 "능력(기능)"을 정의하는 인터페이스입니다.
// 인터페이스 이름은 주로 ~able 형태로 지어지는 경우가 많습니다.
interface Printable {
    // [메서드 설명] 출력 기능을 위한 추상 메서드입니다.
    void print();
}

// [클래스 설명] 일반 문서가 출력 기능을 제공하기 위해 Printable 인터페이스를 구현합니다.
class Document implements Printable {
    // [메서드 설명] 문서 출력에 맞는 구체적인 내용을 작성합니다.
    public void print() {
        System.out.println("문서 출력");
    }
}
