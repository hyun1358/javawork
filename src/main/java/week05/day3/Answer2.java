package week05.day3;

public class Answer2 {
    public static void main(String[] args) {
        // PersonAnswer 객체를 생성합니다.
        PersonAnswer p = new PersonAnswer();
        
        // setter 메서드를 통해 나이에 음수(-10)를 설정하려고 시도합니다.
        p.setAge(-10);
        
        // 유효성 검사로 인해 값이 설정되지 않고, 기본값인 0이 출력되는 것을 확인합니다.
        System.out.println("나이: " + p.getAge());
    }
}

// [클래스 설명] PersonAnswer 클래스는 setter 내부에서 데이터의 유효성을 검사하여 잘못된 값으로부터 필드를 보호합니다.
class PersonAnswer {
    // [필드 설명] 나이 정보를 외부에 공개하지 않도록 private으로 선언합니다.
    private int age;

    // [메서드 설명] 보호된 age 필드의 값을 읽어 반환하는 getter 메서드입니다.
    public int getAge() {
        return age;
    }

    // [메서드 설명] 외부에서 전달된 age 값이 유효한지 검사한 후 안전하게 설정하는 setter 메서드입니다.
    public void setAge(int age) {
        // [로직 설명] 나이가 0보다 작은 음수일 경우 에러 메시지를 출력하고 메서드를 종료시켜 데이터를 보호합니다.
        if (age < 0) {
            System.out.println("잘못된 입력입니다.");
            return;
        }
        // 검증을 통과한 정상적인 값만 필드에 저장합니다.
        this.age = age;
    }
}
