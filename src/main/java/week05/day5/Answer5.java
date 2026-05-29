package week05.day5;

public class Answer5 {
    public static void main(String[] args) {
        // 회원 객체를 생성하면서 불변 필드인 ID와 가변 필드인 비밀번호를 함께 초기화합니다.
        User user = new User("guest", "1234");
        
        // 생성된 객체의 getter를 통해 ID 값을 확인하여 출력합니다.
        System.out.println(user.getId());
    }
}

// [클래스 설명] 종합적인 접근 제어자와 final 키워드 활용을 보여주는 사용자 정보 클래스입니다.
class User {
    // [필드 설명] id는 객체 생성 시 한 번만 설정되며 이후 변경되지 않는 고유값이므로 final을 사용합니다.
    private final String id; // ID는 생성 후 변경 불가
    // [필드 설명] 비밀번호는 추후 변경될 수 있으므로 final 없이 일반 private 변수로 선언합니다.
    private String pw;
    // [필드 설명] 사이트 이름은 모든 사용자 객체가 공유하고 변하지 않으므로 public static final로 선언합니다.
    public static final String SITE_NAME = "MySite";

    // [생성자 설명] 객체 생성 시 id와 pw를 전달받아 필드를 초기화합니다. (final 필드인 id의 유일한 초기화 시점)
    public User(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }

    // [메서드 설명] 불변 필드인 id의 값을 반환하는 getter 메서드입니다. setter는 제공되지 않습니다.
    public String getId() {
        return id;
    }

    // [메서드 설명] 변경 가능한 pw 필드의 값을 수정할 수 있도록 제공되는 setter 메서드입니다.
    public void setPw(String pw) {
        this.pw = pw;
    }
}
