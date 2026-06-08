package week11.day3;

/**
 * [학습 예제 4] Week 11 Day 3 — 빌더/데코레이터/커맨드 패턴 완전 정복
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 4] 커맨드 패턴 (Command Pattern)
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - 요청(명령)을 객체로 캡슐화하여 나중에 실행하거나 취소 가능
 *  - Command 인터페이스 of execute() 메서드로 통일
 *  - Invoker(리모컨)가 Command 객체만 알면 됨 → 느슨한 결합
 *
 * [문제별 학습 목표]
 * - 문제 4: 커맨드 패턴 — Command 인터페이스 + LightOnCommand
 */
public class Example4 {
    public static void main(String[] args) {
        // ─────────────────────────────────────────────
        // Lab 4: 커맨드 패턴 (→ 문제 4 참고)
        // ─────────────────────────────────────────────
        System.out.println("\n=== Lab 4: 커맨드 패턴 — 조명 제어 ===");
        Light light = new Light();

        // 커맨드 객체 생성 (명령을 객체로 캡슐화)
        Command lightOn  = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);

        // Invoker(리모컨)는 어떤 기기인지 몰라도 됨
        RemoteControl remote = new RemoteControl();
        remote.setCommand(lightOn);
        remote.pressButton(); // 조명 켜기

        remote.setCommand(lightOff);
        remote.pressButton(); // 조명 끄기
    }

    // ─── 커맨드 패턴 ─────────────────────────────────────
    interface Command {
        void execute();
    }

    static class Light {
        public void on()  { System.out.println("조명이 켜졌습니다!"); }
        public void off() { System.out.println("조명이 꺼졌습니다!"); }
    }

    static class LightOnCommand implements Command {
        private Light light;
        LightOnCommand(Light l) { this.light = l; }
        public void execute() { light.on(); }
    }

    static class LightOffCommand implements Command {
        private Light light;
        LightOffCommand(Light l) { this.light = l; }
        public void execute() { light.off(); }
    }

    static class RemoteControl {
        private Command command;
        public void setCommand(Command c) { this.command = c; }
        public void pressButton() { command.execute(); }
    }
}
