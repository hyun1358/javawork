package week11.day1;

/**
 * [학습 예제] Week 11 Day 1 — 싱글톤 패턴 & 팩토리 패턴 완전 정복
 *
 * ★ 이 파일은 오늘 풀어야 할 연습 문제 5개의 핵심 기술을 모두 담고 있습니다.
 *
 * [문제별 학습 목표]
 * - 문제 1: 기본 Eager 싱글톤 — DBConnection 클래스, 두 참조가 같은지 확인
 * - 문제 2: Lazy Initialization 싱글톤 — getInstance() 첫 호출 시 객체 생성
 * - 문제 3: Enum 싱글톤 — 가장 안전한 싱글톤 구현 방법
 * - 문제 4: 팩토리 패턴 — ShapeFactory("circle"/"rectangle") → Shape 객체 반환
 * - 문제 5: 정적 팩토리 메서드 — User.createAdmin("1234") 방식 설계
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 1] Eager(이른) 초기화 싱글톤
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - 클래스 로딩 시점에 인스턴스를 미리 만들어두는 방식
 *  - private static final 인스턴스 → 외부에서 new 불가
 *  - private 생성자 → 외부에서 new DBConnection() 불가
 *  - public static getInstance() → 외부가 접근하는 유일한 통로
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 2] Lazy(게으른) 초기화 싱글톤
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - getInstance()가 처음 호출될 때만 객체를 만드는 방식
 *  - 멀티스레드 환경에서 안전하려면 synchronized 필요
 *  - 장점: 처음부터 메모리를 차지하지 않음 (필요할 때만 생성)
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 3] Enum 싱글톤 (가장 안전)
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - Enum 상수는 JVM이 하나만 생성하는 것을 보장
 *  - 직렬화, 리플렉션 공격에도 안전
 *  - Joshua Bloch가 권장하는 최선의 싱글톤 방법
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 4] 팩토리 패턴 (Factory Pattern)
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - 객체 생성(new)을 팩토리 클래스/메서드에 위임
 *  - 클라이언트는 어떤 구체 클래스인지 몰라도 됨
 *  - 문자열 등 조건에 따라 다형적으로 객체를 반환
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 5] 정적 팩토리 메서드 (Static Factory Method)
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - new User("admin", "1234") 대신 User.createAdmin("1234") 처럼
 *    목적을 이름으로 표현하는 메서드로 객체를 생성
 *  - 장점: 이름으로 의미 전달, 캐싱/조건부 생성 가능
 */
public class Example {
    public static void main(String[] args) {

        // ─────────────────────────────────────────────
        // Lab 1: Eager 싱글톤 — DBConnection (→ 문제 1 참고)
        // ─────────────────────────────────────────────
        System.out.println("=== Lab 1: Eager 싱글톤 (DBConnection) ===");
        DBConnection db1 = DBConnection.getInstance();
        DBConnection db2 = DBConnection.getInstance();
        System.out.println("db1 == db2 ? " + (db1 == db2)); // 반드시 true
        db1.connect();

        // ─────────────────────────────────────────────
        // Lab 2: Lazy 싱글톤 (→ 문제 2 참고)
        // ─────────────────────────────────────────────
        System.out.println("\n=== Lab 2: Lazy 싱글톤 ===");
        LazySingleton lazy1 = LazySingleton.getInstance();
        LazySingleton lazy2 = LazySingleton.getInstance();
        System.out.println("lazy1 == lazy2 ? " + (lazy1 == lazy2)); // true
        System.out.println("처음 호출 시에만 '인스턴스 생성' 메시지가 출력됐어야 함");

        // ─────────────────────────────────────────────
        // Lab 3: Enum 싱글톤 (→ 문제 3 참고)
        // ─────────────────────────────────────────────
        System.out.println("\n=== Lab 3: Enum 싱글톤 (Configuration) ===");
        Configuration cfg1 = Configuration.INSTANCE;
        Configuration cfg2 = Configuration.INSTANCE;
        System.out.println("cfg1 == cfg2 ? " + (cfg1 == cfg2)); // true (JVM 보장)
        cfg1.printVersion();

        // ─────────────────────────────────────────────
        // Lab 4: 팩토리 패턴 — ShapeFactory (→ 문제 4 참고)
        // ─────────────────────────────────────────────
        System.out.println("\n=== Lab 4: ShapeFactory 패턴 ===");
        Shape circle = ShapeFactory.create("circle");
        Shape rect   = ShapeFactory.create("rectangle");
        circle.draw();   // 원 그리기
        rect.draw();     // 사각형 그리기

        // ─────────────────────────────────────────────
        // Lab 5: 정적 팩토리 메서드 (→ 문제 5 참고)
        // ─────────────────────────────────────────────
        System.out.println("\n=== Lab 5: 정적 팩토리 메서드 (User) ===");
        // new User("admin", "1234") 대신 목적이 명확한 메서드명으로 생성
        ExUser admin = ExUser.createAdmin("admin123");
        ExUser guest = ExUser.createGuest();

        System.out.println("admin: " + admin.role + " / " + admin.name);
        System.out.println("guest: " + guest.role + " / " + guest.name);
    }
}

// ─── Lab 1: Eager 싱글톤 ───────────────────────────────
class DBConnection {
    // 클래스 로딩 시 즉시 생성 (Eager)
    private static final DBConnection instance = new DBConnection();

    // private 생성자 → 외부에서 new 불가
    private DBConnection() {}

    // 외부가 접근하는 유일한 통로
    public static DBConnection getInstance() {
        return instance;
    }

    public void connect() {
        System.out.println("DB 연결 완료 (객체 하나를 공유 중)");
    }
}

// ─── Lab 2: Lazy 싱글톤 ───────────────────────────────
class LazySingleton {
    private static LazySingleton instance; // 처음엔 null

    private LazySingleton() {
        System.out.println("LazySingleton 인스턴스 생성 (최초 1회)");
    }

    // synchronized: 멀티스레드 환경에서 동시 생성 방지
    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}

// ─── Lab 3: Enum 싱글톤 ───────────────────────────────
enum Configuration {
    INSTANCE; // JVM이 이 상수를 딱 하나만 생성함을 보장

    private final String version = "v1.0.0";

    public void printVersion() {
        System.out.println("앱 버전: " + version);
    }
}

// ─── Lab 4: 팩토리 패턴 ───────────────────────────────
interface Shape {
    void draw();
}

class Circle implements Shape {
    public void draw() { System.out.println("원(Circle) 그리기"); }
}

class Rectangle implements Shape {
    public void draw() { System.out.println("사각형(Rectangle) 그리기"); }
}

class ShapeFactory {
    public static Shape create(String type) {
        if ("circle".equalsIgnoreCase(type))    return new Circle();
        if ("rectangle".equalsIgnoreCase(type)) return new Rectangle();
        throw new IllegalArgumentException("알 수 없는 도형: " + type);
    }
}

// ─── Lab 5: 정적 팩토리 메서드 ───────────────────────
class ExUser {
    String name;
    String role;

    // private 생성자 → 직접 new 불가
    private ExUser(String name, String role) {
        this.name = name;
        this.role = role;
    }

    // 목적이 명확한 정적 팩토리 메서드들
    public static ExUser createAdmin(String name) {
        return new ExUser(name, "ADMIN");
    }

    public static ExUser createGuest() {
        return new ExUser("guest", "GUEST");
    }
}
