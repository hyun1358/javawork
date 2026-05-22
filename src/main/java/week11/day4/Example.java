package week11.day4;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * [학습 예제] Week 11 Day 4 — 커스텀 어노테이션과 Field 리플렉션
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Lab 1: 어노테이션과 메서드 리플렉션 ===");
        // Item 클래스의 메서드 중 @Important가 붙은 메서드 찾기
        java.lang.reflect.Method[] methods = Item.class.getDeclaredMethods();
        for (java.lang.reflect.Method m : methods) {
            if (m.isAnnotationPresent(Important.class)) {
                System.out.println("중요한 메서드 발견: " + m.getName());
            }
        }

        System.out.println("\n=== Lab 2: 어노테이션과 필드(Field) 리플렉션 ===");
        Field[] fields = Item.class.getDeclaredFields();
        for (Field f : fields) {
            if (f.isAnnotationPresent(Important.class)) {
                System.out.println("중요한 필드 발견: " + f.getName() + " (타입: " + f.getType().getSimpleName() + ")");
            }
        }
    }
}

// 나만의 어노테이션 정의 (메서드와 필드 둘 다 사용 가능하도록 설정)
@Retention(RetentionPolicy.RUNTIME) // 런타임까지 살아남음
@Target({ElementType.METHOD, ElementType.FIELD})
@interface Important {
}

class Item {
    @Important
    private String id;
    
    private int price;

    public void normalMethod() {
    }

    @Important
    public void criticalMethod() {
    }
}
