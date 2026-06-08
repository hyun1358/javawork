package week11.day4;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * [학습 예제 5] Week 11 Day 4 — Enum & 어노테이션 완전 정복
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 5] 어노테이션 + 리플렉션
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - 어노테이션 그 자체는 코드 로직이 없음
 *  - 리플렉션을 통해 어노테이션이 붙었는지 확인하고 실제 로직(검증 등) 처리
 *
 * [문제별 학습 목표]
 * - 문제 5: 리플렉션 검사 (NotNull 필드 검증 로직)
 */
public class Example5 {
    public static void main(String[] args) {
        System.out.println("\n=== Lab 5: @NotNull 어노테이션 + 리플렉션 검사 ===");
        Member m = new Member(null, "test@test.com");
        validateNotNull(m);
    }

    static void validateNotNull(Object obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field f : fields) {
            if (f.isAnnotationPresent(NotNull.class)) {
                f.setAccessible(true);
                try {
                    if (f.get(obj) == null) {
                        System.out.println("검증 실패: '" + f.getName() + "' 필드는 null이면 안 됩니다!");
                    } else {
                        System.out.println("검증 통과: '" + f.getName() + "' = " + f.get(obj));
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
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
