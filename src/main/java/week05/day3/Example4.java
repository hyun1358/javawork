package week05.day3;

/**
 * [학습 예제 4] Week 05 Day 3 — 접근 제어자와 캡슐화
 * 
 * [학습 핵심 이론: 객체의 자율성과 정보 은닉]
 * 2. 접근 제어자 4단계 (Access Modifiers):
 *    - private: 동일 클래스 내부에서만 독점 사용 가능 (필드는 대부분 private 권장).
 * 
 * [문제별 학습 목표]
 * - Lab4: Product 클래스의 문자열 null/공백 유효성 검증 (Problem 4 연계)
 */
public class Example4 {
    public static void main(String[] args) {
        Product prod = new Product();
        prod.setName("노트북");
        System.out.println("정상 제품명: " + prod.getName());

        prod.setName(""); // 빈 문자열 입력 시도
        System.out.println("빈 문자열 입력 시도 후 제품명: " + prod.getName() + " [이름 없음으로 자동 변환]");
    }

    // Problem 4: Product 클래스 문자열 검증
    static class Product {
        private String name;

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            // null 체크 및 빈 문자열 ""을 동시 체크하여 "이름 없음" 기본값 처리
            if (name == null || name.trim().isEmpty()) {
                this.name = "이름 없음";
            } else {
                this.name = name;
            }
        }
    }
}
