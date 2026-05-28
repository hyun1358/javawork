package week11.day3;

/**
 * [학습 예제] Week 11 Day 3 — 빌더/데코레이터/커맨드 패턴 완전 정복
 *
 * ★ 이 파일은 오늘 풀어야 할 연습 문제 5개의 핵심 기술을 모두 담고 있습니다.
 *
 * [문제별 학습 목표]
 * - 문제 1: 빌더 패턴 — Computer 빌더 (메서드 체이닝)
 * - 문제 2: 빌더 패턴 — SqlBuilder (SELECT / FROM / WHERE)
 * - 문제 3: 데코레이터 패턴 — BasicPizza + 치즈/페퍼로니 데코레이터
 * - 문제 4: 커맨드 패턴 — Command 인터페이스 + LightOnCommand
 * - 문제 5: 패턴 선택 기준 — 빌더 vs 팩토리 차이 정리
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 1 & 2] 빌더 패턴 (Builder Pattern)
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - 생성자 인자가 많을 때, 메서드 체이닝으로 가독성 좋게 객체를 조립
 *  - 각 setter 메서드가 this를 반환 → .cpu().ram().build() 체이닝 가능
 *  - build() 마지막에 실제 객체 생성
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 3] 데코레이터 패턴 (Decorator Pattern)
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - 기존 객체를 감싸서(wrap) 기능을 동적으로 추가
 *  - 기본 객체 + 데코레이터들을 겹겹이 포장
 *  - 상속 없이 기능 확장 → 개방-폐쇄 원칙(OCP) 준수
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 4] 커맨드 패턴 (Command Pattern)
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - 요청(명령)을 객체로 캡슐화하여 나중에 실행하거나 취소 가능
 *  - Command 인터페이스의 execute() 메서드로 통일
 *  - Invoker(리모컨)가 Command 객체만 알면 됨 → 느슨한 결합
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 5] 패턴 선택 기준
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - 팩토리: 어떤 타입의 객체를 만들지가 관심사 (타입 선택)
 *    예) "circle" → Circle 객체 반환
 *  - 빌더: 하나의 복잡한 객체를 단계적으로 조립이 관심사 (속성 조립)
 *    예) cpu().ram().ssd().build() → Computer 객체 반환
 */
public class Example {
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

        // ─────────────────────────────────────────────
        // Lab 2: 빌더 패턴 — SqlBuilder (→ 문제 2 참고)
        // ─────────────────────────────────────────────
        System.out.println("\n=== Lab 2: 빌더 패턴 — SqlBuilder ===");
        String query1 = new SqlBuilder()
                .select("id, name, email")
                .from("users")
                .where("age > 20")
                .build();
        System.out.println("SQL: " + query1);

        String query2 = new SqlBuilder()
                .select("*")
                .from("orders")
                .build(); // WHERE 없이도 가능
        System.out.println("SQL: " + query2);

        // ─────────────────────────────────────────────
        // Lab 3: 데코레이터 패턴 — 피자 (→ 문제 3 참고)
        // ─────────────────────────────────────────────
        System.out.println("\n=== Lab 3: 데코레이터 패턴 — 피자 ===");
        Pizza pizza = new BasicPizza();
        System.out.println(pizza.getDescription() + " / 가격: " + pizza.getPrice() + "원");

        pizza = new CheeseDecorator(pizza); // 치즈 추가
        System.out.println(pizza.getDescription() + " / 가격: " + pizza.getPrice() + "원");

        pizza = new PepperoniDecorator(pizza); // 페퍼로니 추가
        System.out.println(pizza.getDescription() + " / 가격: " + pizza.getPrice() + "원");

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

// ─── 빌더 패턴: Computer ──────────────────────────────
class Computer {
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

// ─── 빌더 패턴: SqlBuilder ────────────────────────────
class SqlBuilder {
    private StringBuilder sb = new StringBuilder();

    public SqlBuilder select(String cols)  { sb.append("SELECT ").append(cols).append(" "); return this; }
    public SqlBuilder from(String table)   { sb.append("FROM ").append(table).append(" ");  return this; }
    public SqlBuilder where(String cond)   { sb.append("WHERE ").append(cond).append(" ");  return this; }

    public String build() { return sb.toString().trim(); }
}

// ─── 데코레이터 패턴: 피자 ────────────────────────────
interface Pizza {
    String getDescription();
    int getPrice();
}

class BasicPizza implements Pizza {
    public String getDescription() { return "기본 피자"; }
    public int getPrice() { return 8000; }
}

abstract class PizzaDecorator implements Pizza {
    protected Pizza pizza;
    PizzaDecorator(Pizza p) { this.pizza = p; }
}

class CheeseDecorator extends PizzaDecorator {
    CheeseDecorator(Pizza p) { super(p); }
    public String getDescription() { return pizza.getDescription() + " + 치즈"; }
    public int getPrice() { return pizza.getPrice() + 1500; }
}

class PepperoniDecorator extends PizzaDecorator {
    PepperoniDecorator(Pizza p) { super(p); }
    public String getDescription() { return pizza.getDescription() + " + 페퍼로니"; }
    public int getPrice() { return pizza.getPrice() + 2000; }
}

// ─── 커맨드 패턴 ─────────────────────────────────────
interface Command {
    void execute();
}

class Light {
    public void on()  { System.out.println("조명이 켜졌습니다!"); }
    public void off() { System.out.println("조명이 꺼졌습니다!"); }
}

class LightOnCommand implements Command {
    private Light light;
    LightOnCommand(Light l) { this.light = l; }
    public void execute() { light.on(); }
}

class LightOffCommand implements Command {
    private Light light;
    LightOffCommand(Light l) { this.light = l; }
    public void execute() { light.off(); }
}

class RemoteControl {
    private Command command;
    public void setCommand(Command c) { this.command = c; }
    public void pressButton() { command.execute(); }
}
