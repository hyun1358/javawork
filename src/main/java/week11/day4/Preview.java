package week11.day4;

/**
 * [예습 파일] Week 11 Day 4 — Enum 심화
 * 
 * [핵심 개념: 타입 안전 상수의 집합 객체]
 * 1. 열거형(Enum)의 진실:
 *    - 자바의 Enum은 단순한 정수형 상수의 모음집인 C계열과 격이 다른, 내부에 멤버변수와 독립 메서드 및 커스텀 생성자까지 마음대로 탑재할 수 있는 완전한 특수 클래스 객체입니다.
 * 
 * 2. 타입 세이프(Type-Safe) 보장:
 *    - 문자열이나 단순 정수 상수를 쓰면 오타 등의 잘못된 데이터가 들어가도 컴파일 시점에 막지 못하지만, Enum은 사전에 한정 정의된 열거 상수 인스턴스 이외의 다른 값은 컴파일러가 강력 차단하므로 비즈니스 도메인의 오류율을 0으로 좁혀 줍니다.
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
