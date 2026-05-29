package week05.day3;

public class Answer4 {
    public static void main(String[] args) {
        // Product 객체를 생성합니다.
        Product p = new Product();
        
        // 빈 문자열("")을 이름으로 설정하려고 시도합니다.
        p.setName("");
        
        // setter 내부의 방어 로직에 의해 "이름 없음"으로 대체되어 출력되는 것을 확인합니다.
        System.out.println("상품명: " + p.getName());
    }
}

// [클래스 설명] Product 클래스는 빈 문자열과 null 값을 방어하는 방어적 복사/설정 로직을 포함합니다.
class Product {
    // [필드 설명] 상품명을 직접 변경하지 못하도록 private으로 설정합니다.
    private String name;

    // [메서드 설명] 설정된 상품명을 외부로 반환하는 getter 메서드입니다.
    public String getName() {
        return name;
    }

    // [메서드 설명] 전달된 이름이 유효한지 검사한 후 상품명을 설정하는 setter 메서드입니다.
    public void setName(String name) {
        // [로직 설명] 입력값이 null이거나 빈 문자열인지 확인하여 기본값으로 대체하는 방어 코드를 작성합니다.
        if (name == null || name.isEmpty()) {
            this.name = "이름 없음";
        } else {
            this.name = name; // 유효한 문자열일 경우 그대로 설정합니다.
        }
    }
}
