package week11.day4;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * [학습 예제 3] Week 11 Day 4 — Enum & 어노테이션 완전 정복
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 3] 사용자 정의 어노테이션
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - @interface 키워드로 정의
 *  - @Retention(RUNTIME): 실행 시점에도 어노테이션 정보 유지
 *  - @Target(FIELD): 필드에만 붙일 수 있게 제한
 *
 * [문제별 학습 목표]
 * - 문제 3: @NotNull 어노테이션 (필드 정보 출력)
 */
public class Example3 {
    public static void main(String[] args) {
        System.out.println("\n=== Lab 3: @NotNull 어노테이션 필드 검사 ===");
        Field[] fields = Member.class.getDeclaredFields();
        System.out.println("Member 클래스의 @NotNull 필드:");
        for (Field f : fields) {
            if (f.isAnnotationPresent(NotNull.class)) {
                System.out.println("  → @NotNull 필드: " + f.getName() + " (타입: " + f.getType().getSimpleName() + ")");
            }
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    @interface NotNull {}

    static class Member {
        @NotNull private String name;
        private String email;
        Member(String name, String email) {
            this.name  = name;
            this.email = email;
        }
    }
}
