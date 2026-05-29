package week06.day2;

public class Answer2 {
    public static void main(String[] args) {
        // Book 객체를 생성하여 제목과 저자를 초기화합니다.
        Book b = new Book("자바", "홍길동");
        
        // 객체 참조 변수(b)만 출력하더라도 내부적으로 b.toString()이 자동 호출되어 재정의된 문자열이 출력됩니다.
        System.out.println(b);
    }
}

// [클래스 설명] Object 클래스의 toString() 메서드를 오버라이딩하여 객체의 정보를 문자열로 표현하는 예제입니다.
class Book {
    String title, author;

    // [생성자 설명] 책의 제목과 저자를 초기화합니다.
    Book(String t, String a) {
        title = t;
        author = a;
    }

    // [메서드 설명] 최고 조상인 Object 클래스의 toString() 메서드를 재정의합니다.
    // 기본적으로 메모리 주소를 반환하지만, 여기서는 객체가 가진 실제 데이터(제목, 저자)를 반환하도록 변경했습니다.
    @Override
    public String toString() {
        return "제목: " + title + ", 저자: " + author;
    }
}
