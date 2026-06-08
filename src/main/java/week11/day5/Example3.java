package week11.day5;

import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * [학습 예제 3] Week 11 Day 5 — 리플렉션(Reflection) 완전 정복
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 3] 동적 메서드 호출
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - getMethod("메서드명", 파라미터타입...): public 메서드 가져옴
 *  - method.invoke(obj, 인자...): 해당 객체에 메서드 실행
 *  - 메서드 이름을 문자열로 런타임에 결정 가능 (동적)
 *
 * [문제별 학습 목표]
 * - 문제 3: 동적 메서드 호출 — getMethod() + invoke()
 */
public class Example3 {
    public static void main(String[] args) throws Exception {
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
        Person person = new Person("홍길동", 25);
        Method greetMethod = Person.class.getDeclaredMethod("greet");
        greetMethod.invoke(person);
    }

    // ─── 예제 클래스 ──────────────────────────────────────
    static class Person {
        private String name;
        private int age;

        Person(String name, int age) {
            this.name = name;
            this.age  = age;
        }

        public void greet() {
            System.out.println("안녕하세요, 저는 " + name + "이고 " + age + "살입니다.");
        }
    }
}
