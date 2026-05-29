package week05.day3;

public class Answer1 {
    public static void main(String[] args) {
        // DogAnswer 객체를 생성합니다.
        DogAnswer d = new DogAnswer();
        
        // setter 메서드를 사용하여 캡슐화된 private 필드 name에 값을 안전하게 설정합니다.
        d.setName("멍멍이");
        
        // getter 메서드를 사용하여 private 필드 name의 값을 가져와 출력합니다.
        System.out.println("개 이름: " + d.getName());
    }
}

// [클래스 설명] DogAnswer 클래스는 private 필드와 public getter/setter를 활용한 기본적인 캡슐화 예제입니다.
class DogAnswer {
    // [필드 설명] private 접근 제어자를 사용하여 외부 클래스에서 직접 접근하지 못하게 데이터를 보호합니다.
    private String name;

    // [메서드 설명] 캡슐화된 name 필드의 값을 외부로 반환하는 getter 메서드입니다.
    public String getName() {
        return name;
    }

    // [메서드 설명] 외부에서 전달된 값을 받아 캡슐화된 name 필드를 안전하게 변경하는 setter 메서드입니다.
    public void setName(String name) {
        this.name = name;
    }
}
