package week11.day4;

import java.lang.annotation.*;

/**
 * [학습 예제] Week 11 Day 4 — 커스텀 어노테이션 만들기
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Lab: 어노테이션과 리플렉션 ===");
        // Item 클래스의 메서드 중 @Important가 붙은 메서드 찾기
        java.lang.reflect.Method[] methods = Item.class.getDeclaredMethods();
        for (java.lang.reflect.Method m : methods) {
            if (m.isAnnotationPresent(Important.class)) {
                System.out.println("중요한 메서드 발견: " + m.getName());
            }
        }
    }
}

// 나만의 어노테이션 정의
@Retention(RetentionPolicy.RUNTIME) // 런타임까지 살아남음
@Target(ElementType.METHOD) // 메서드에만 붙일 수 있음
@interface Important {
}

class Item {
    public void normalMethod() {
    }

    @Important
    public void criticalMethod() {
    }
}
