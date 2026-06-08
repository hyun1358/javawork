package week11.day3;

/**
 * [학습 예제 1] Week 11 Day 3 — 빌더/데코레이터/커맨드 패턴 완전 정복
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 1] 빌더 패턴 (Builder Pattern)
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - 생성자 인자가 많을 때, 메서드 체이닝으로 가독성 좋게 객체를 조립
 *  - 각 setter 메서드가 this를 반환 → .cpu().ram().build() 체이닝 가능
 *  - build() 마지막에 실제 객체 생성
 *
 * [문제별 학습 목표]
 * - 문제 1: 빌더 패턴 — Computer 빌더 (메서드 체이닝)
 */
public class Example1 {
    public static void main(String[] args) {
        // ─────────────────────────────────────────────
        // Lab 1: 빌더 패턴 — Computer (→ 문제 1 참고)
        // ─────────────────────────────────────────────
        System.out.println("=== Lab 1: 빌더 패턴 — Computer ===");
        Computer myPc = new Computer.Builder()
                .cpu("Intel i9")
                .ram(32)
                .ssd(1024)
                .build();
        System.out.println("조립된 컴퓨터: " + myPc);

        // 일부 옵션만 설정해도 됨 (필수 항목 외 선택 항목은 기본값 사용)
        Computer basicPc = new Computer.Builder()
                .cpu("AMD Ryzen 5")
                .ram(16)
                .build();
        System.out.println("기본형 컴퓨터: " + basicPc);
    }

    // ─── 빌더 패턴: Computer ──────────────────────────────
    static class Computer {
        private String cpu;
        private int ramGb;
        private int ssdGb;

        private Computer(Builder b) {
            this.cpu   = b.cpu;
            this.ramGb = b.ram;
            this.ssdGb = b.ssd;
        }

        @Override
        public String toString() {
            return "Computer{CPU=" + cpu + ", RAM=" + ramGb + "GB, SSD=" + ssdGb + "GB}";
        }

        // 빌더 내부 클래스
        static class Builder {
            private String cpu  = "기본 CPU";
            private int    ram  = 8;
            private int    ssd  = 256; // 기본값

            public Builder cpu(String cpu) { this.cpu = cpu; return this; }
            public Builder ram(int gb)     { this.ram = gb;  return this; }
            public Builder ssd(int gb)     { this.ssd = gb;  return this; }

            public Computer build() { return new Computer(this); }
        }
    }
}
