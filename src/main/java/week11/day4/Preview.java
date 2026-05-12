package week11.day4;

/**
 * [예습 파일] Week 11 Day 4 — Enum 심화
 */
public class Preview {
    public static void main(String[] args) {
        // Enum은 단순 상수가 아니라 클래스처럼 메서드와 필드를 가질 수 있습니다.
        OrderStatus status = OrderStatus.SHIPPED;
        System.out.println("상태: " + status.getDesc());
    }
}

enum OrderStatus {
    PENDING("대기 중"), PAID("결제 완료"), SHIPPED("배송 중");

    private String desc;

    OrderStatus(String desc) {
        this.desc = desc;
    } // Enum 생성자

    public String getDesc() {
        return desc;
    }
}
