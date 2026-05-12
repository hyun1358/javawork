package week05.day3;

/**
 * [연습 문제 4] String 보호하기
 * 문제: Product 클래스의 setName 메서드에서
 * null이나 빈 문자열("")이 들어오면 "이름 없음"으로 저장되게 하세요.
 */
public class Problem4 {
    public static void main(String[] args) {
        // TODO: 빈 문자열 입력 시나리오 테스트
        Product product = new Product();
        product.setName("컴퓨터");
        System.out.println(product.getName());
        product.setName("");
        System.out.println(product.getName());
    }

    static class Product {
        String name;

        void setName(String name) {
            if (name == null || name == "") {
                this.name = "이름 없음";
            } else {
                this.name = name;
            }
        }

        String getName() {
            return this.name;
        }
    }
}
