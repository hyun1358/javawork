package week11.day4;

/**
 * [학습 예제 4] Week 11 Day 4 — Enum & 어노테이션 완전 정복
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 4] 표준 어노테이션
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - @Override: 메서드 재정의 확인
 *  - @Deprecated: 더 이상 사용되지 않음을 경고
 *  - @SuppressWarnings: 컴파일 경고 무시
 *
 * [문제별 학습 목표]
 * - 문제 4: @Deprecated
 */
public class Example4 {
    public static void main(String[] args) {
        System.out.println("\n=== Lab 4: @Deprecated ===");
        LegacyService service = new LegacyService();
        service.newMethod(); 

        @SuppressWarnings("deprecation")
        String result = service.oldMethod();
        System.out.println("구형 메서드 결과: " + result);
    }

    static class LegacyService {
        @Deprecated public String oldMethod() { return "구형 방식으로 처리됨"; }
        public void newMethod() { System.out.println("새로운 방식으로 처리됨 (권장)"); }
    }
}
