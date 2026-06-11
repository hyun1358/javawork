package week11.day4;

/**
 * [학습 예제 1] Week 11 Day 4 — Enum & 어노테이션 완전 정복
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 1] Enum 기초
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - 관련 있는 상수들의 집합을 정의하는 특별한 클래스
 *  - name(), ordinal(), values() 등 기본 메서드 제공
 *  - 생성자와 필드를 가질 수 있어 데이터와 로직을 묶기 좋음
 *
 * [문제별 학습 목표]
 * - 문제 1: Enum — 요일
 */
public class Example1 {
    public static void main(String[] args)
    {
        System.out.println("=== Lab 1: Enum — 요일 ===");
        for (DayOfWeek day : DayOfWeek.values()) {
            System.out.println(day.name() + " → " + day.getKoreanName());
        }

        DayOfWeek today = DayOfWeek.MONDAY;
        System.out.println("오늘: " + today + " (" + today.getKoreanName() + ")");
    }

    enum DayOfWeek
    {
        MONDAY("월요일"), TUESDAY("화요일"), WEDNESDAY("수요일"),
        THURSDAY("목요일"), FRIDAY("금요일"), SATURDAY("토요일"), SUNDAY("일요일");
        private final String koreanName;
        DayOfWeek(String koreanName) { this.koreanName = koreanName; }
        public String getKoreanName() { return koreanName; }
    }
}
