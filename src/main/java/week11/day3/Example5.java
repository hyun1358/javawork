package week11.day3;

/**
 * [학습 예제 5] Week 11 Day 3 — 빌더/데코레이터/커맨드 패턴 완전 정복
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 5] 패턴 선택 기준
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - 팩토리: 어떤 타입의 객체를 만들지가 관심사 (타입 선택)
 *    예) "circle" → Circle 객체 반환
 *  - 빌더: 하나의 복잡한 객체를 단계적으로 조립이 관심사 (속성 조립)
 *    예) cpu().ram().ssd().build() → Computer 객체 반환
 *
 * [문제별 학습 목표]
 * - 문제 5: 패턴 선택 기준 — 빌더 vs 팩토리 차이 정리
 */
public class Example5 {
    public static void main(String[] args) {
        // ─────────────────────────────────────────────
        // Lab 5: 패턴 선택 기준 (→ 문제 5 참고)
        // ─────────────────────────────────────────────
        System.out.println("\n=== Lab 5: 패턴 선택 기준 ===");
        /*
         * 팩토리 패턴을 선택해야 할 때:
         *  - 어떤 타입(종류)의 객체를 생성할지가 런타임에 결정될 때
         *  - 구체 클래스를 숨기고 인터페이스로 받아야 할 때
         *  예) ShapeFactory.create("circle") → Circle or Rectangle 반환
         *
         * 빌더 패턴을 선택해야 할 때:
         *  - 생성자 인자가 4개 이상으로 많을 때
         *  - 선택 항목(optional)이 많아 여러 생성자 조합이 필요할 때
         *  - 객체를 단계별로 조립하고 싶을 때
         *  예) Computer.Builder().cpu().ram().ssd().build()
         *
         * 요약:
         *  팩토리 = "무엇을 만들지" 결정
         *  빌더   = "어떻게 조립할지" 결정
         */
        System.out.println("팩토리: 어떤 타입을 만들지 → ShapeFactory.create(\"circle\")");
        System.out.println("빌더:   어떻게 조립할지   → Computer.Builder().cpu().ram().build()");
    }
}
