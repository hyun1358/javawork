package week11.day5;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * [학습 예제] Week 11 Day 5 — 리플렉션(Reflection) 완전 정복
 *
 * ★ 이 파일은 오늘 풀어야 할 연습 문제 5개의 핵심 기술을 모두 담고 있습니다.
 *
 * [문제별 학습 목표]
 * - 문제 1: 클래스 정보 출력 — String.class 의 필드 개수 / 메서드 개수
 * - 문제 2: private 필드 읽기 — setAccessible(true) 로 캡슐화 우회
 * - 문제 3: 동적 메서드 호출 — getMethod() + invoke()
 * - 문제 4: 객체 복사 (Shallow Copy) — 모든 필드 값을 다른 객체로 복사
 * - 문제 5: 리플렉션 주의사항 — 성능/보안 문제 주석 설명
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 1] 클래스 메타데이터 조회
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - 모든 클래스는 Class<?> 객체를 가짐
 *  - Class.getDeclaredFields(): 해당 클래스에서 선언된 모든 필드
 *  - Class.getDeclaredMethods(): 해당 클래스에서 선언된 모든 메서드
 *  - Class.getFields() / getMethods(): public 필드/메서드 (상속 포함)
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 2] private 필드 강제 접근
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - getDeclaredField("필드명"): 해당 클래스의 필드 객체 가져옴
 *  - field.setAccessible(true): private 접근 제한 해제
 *  - field.get(obj): 필드 값 읽기
 *  - field.set(obj, value): 필드 값 쓰기
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 3] 동적 메서드 호출
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - getMethod("메서드명", 파라미터타입...): public 메서드 가져옴
 *  - method.invoke(obj, 인자...): 해당 객체에 메서드 실행
 *  - 메서드 이름을 문자열로 런타임에 결정 가능 (동적)
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 5] 리플렉션 주의사항
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - 성능: 일반 메서드 호출보다 훨씬 느림 (JVM 최적화 불가)
 *  - 보안: private 접근 제한 우회 → 캡슐화 위반
 *  - 타입 안전성 없음: 컴파일 시점에 오류를 잡을 수 없음
 *  - 권장 용도: 프레임워크 내부(Spring, JPA 등)에서만 사용
 */
public class Example {
    public static void main(String[] args) throws Exception {

        // ─────────────────────────────────────────────
        // Lab 1: 클래스 정보 출력 (→ 문제 1 참고)
        // ─────────────────────────────────────────────
        System.out.println("=== Lab 1: 클래스 정보 출력 ===");
        // String.class 를 통해 String 클래스 메타정보 조회
        Class<?> strClass = String.class;
        System.out.println("클래스명: " + strClass.getName());
        System.out.println("선언된 필드 수: " + strClass.getDeclaredFields().length);
        System.out.println("선언된 메서드 수: " + strClass.getDeclaredMethods().length);

        // 사용자 정의 클래스 정보 출력
        Class<?> personClass = Person.class;
        System.out.println("\nPerson 클래스 필드들:");
        for (Field f : personClass.getDeclaredFields()) {
            System.out.println("  - " + f.getName() + " (" + f.getType().getSimpleName() + ")");
        }
        System.out.println("Person 클래스 메서드들:");
        for (Method m : personClass.getDeclaredMethods()) {
            System.out.println("  - " + m.getName() + "()");
        }

        // ─────────────────────────────────────────────
        // Lab 2: private 필드 읽기 (→ 문제 2 참고)
        // ─────────────────────────────────────────────
        System.out.println("\n=== Lab 2: private 필드 읽기 ===");
        Person person = new Person("홍길동", 25);

        Field ageField = Person.class.getDeclaredField("age");
        ageField.setAccessible(true); // private 접근 제한 해제

        int age = (int) ageField.get(person);
        System.out.println("리플렉션으로 읽은 private age: " + age);

        // private 필드 값 변경도 가능
        ageField.set(person, 99);
        System.out.println("리플렉션으로 변경 후 age: " + ageField.get(person));

        // ─────────────────────────────────────────────
        // Lab 3: 동적 메서드 호출 (→ 문제 3 참고)
        // ─────────────────────────────────────────────
        System.out.println("\n=== Lab 3: 동적 메서드 호출 ===");
        // Scanner 객체에서 nextLine 메서드를 이름으로 찾아서 실행
        Scanner sc = new Scanner("Hello Reflection!\n");
        Method nextLineMethod = Scanner.class.getMethod("nextLine");
        String result = (String) nextLineMethod.invoke(sc); // 동적 실행
        System.out.println("동적 호출 결과: " + result);
        sc.close();

        // Person의 greet() 메서드를 동적으로 호출
        Method greetMethod = Person.class.getDeclaredMethod("greet");
        greetMethod.invoke(person);

        // ─────────────────────────────────────────────
        // Lab 4: 객체 복사 (Shallow Copy) (→ 문제 4 참고)
        // ─────────────────────────────────────────────
        System.out.println("\n=== Lab 4: 리플렉션으로 객체 복사 (Shallow Copy) ===");
        Person original = new Person("김철수", 30);
        Person copy = new Person(null, 0);

        // 모든 필드를 리플렉션으로 순회하며 값 복사
        for (Field f : Person.class.getDeclaredFields()) {
            f.setAccessible(true);
            f.set(copy, f.get(original)); // 원본 → 복사본
        }

        System.out.println("원본: name=" + original.getName() + ", age=" + original.getAge());

        Field nameField = Person.class.getDeclaredField("name");
        nameField.setAccessible(true);
        Field copyAgeField = Person.class.getDeclaredField("age");
        copyAgeField.setAccessible(true);
        System.out.println("복사본: name=" + nameField.get(copy) + ", age=" + copyAgeField.get(copy));

        // ─────────────────────────────────────────────
        // Lab 5: 리플렉션 주의사항 (→ 문제 5 참고)
        // ─────────────────────────────────────────────
        System.out.println("\n=== Lab 5: 리플렉션 주의사항 ===");
        /*
         * [주의사항 1: 성능 (Performance)]
         *  - 리플렉션은 JVM의 내부 최적화(인라이닝, 바이트코드 최적화)를 건너뜀
         *  - 일반 메서드 호출 대비 수십~수백 배 느릴 수 있음
         *  - 반복 루프 안에서 리플렉션을 남발하면 심각한 성능 저하 유발
         *  → 해결책: 프레임워크에서는 한 번만 리플렉션 후 결과를 캐싱하여 재사용
         *
         * [주의사항 2: 보안 (Security)]
         *  - setAccessible(true)로 private/protected 접근 제한을 강제로 우회
         *  - 캡슐화 원칙 위반 → 의도하지 않은 내부 상태 노출 및 변경 가능
         *  - Java 9+ 모듈 시스템에서는 일부 setAccessible이 제한됨
         *  → 해결책: 꼭 필요한 프레임워크 공통 유틸리티 코드에서만 사용
         *
         * [주의사항 3: 타입 안전성 없음]
         *  - 컴파일 시점에 오류를 잡지 못함 (런타임 오류 발생)
         *  - ClassCastException, NoSuchFieldException 등 런타임 예외 위험
         */
        System.out.println("리플렉션 주의사항:");
        System.out.println("  1. 성능: JVM 최적화 불가 → 반복 사용 자제");
        System.out.println("  2. 보안: private 캡슐화 우회 → 내부 상태 노출 위험");
        System.out.println("  3. 타입 안전성: 컴파일 오류 감지 불가 → 런타임 에러 위험");
        System.out.println("  → 권장: Spring/JPA 같은 프레임워크 내부 코드에서만 활용");
    }
}

// ─── 예제 클래스 ──────────────────────────────────────
class Person {
    private String name;
    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age  = age;
    }

    public String getName() { return name; }
    public int getAge()     { return age; }

    public void greet() {
        System.out.println("안녕하세요, 저는 " + name + "이고 " + age + "살입니다.");
    }
}
