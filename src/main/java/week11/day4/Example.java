package week11.day4;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * [학습 예제] Week 11 Day 4 — 커스텀 어노테이션과 Field 리플렉션
 * 
 * [학습 핵심 이론: 코드 위의 메타데이터와 자동 처리]
 * 1. 어노테이션 (Annotation):
 *    - 컴파일러나 프레임워크에게 이 코드(클래스, 메소드, 필드)가 어떤 용도인지, 런타임에 어떻게 처리해야 하는지 알려주는 골뱅이(`@`) 표식 메타데이터입니다.
 * 
 * 2. 커스텀 어노테이션과 리플렉션 시너지:
 *    - `@Retention(RetentionPolicy.RUNTIME)`을 사용하여 런타임까지 마크 정보를 보존합니다.
 *    - 리플렉션을 통해 객체 내부를 샅샅이 파고들어, 내가 만든 커스텀 어노테이션이 붙어 있는 필드들만 골라내 특수 유효성 검증을 일괄 자동 수행하는 스프링 프레임워크식 마법을 구현해 봅니다.
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
