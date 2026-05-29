package week11.day4;

import java.lang.reflect.Field;
import java.lang.annotation.*;

// 리플렉션(Reflection)을 사용하여 런타임에 커스텀 어노테이션 정보를 읽어오는 예제입니다.
public class Answer5 {
    // 메인 메서드
    public static void main(String[] args) {
        // TestClass의 선언된 모든 필드(멤버 변수)를 순회합니다.
        for (Field f : TestClass.class.getDeclaredFields()) {
            // 해당 필드에 @NotNull 어노테이션이 붙어 있는지 확인합니다.
            if (f.isAnnotationPresent(NotNull.class)) {
                System.out.println("널 금지 필드: " + f.getName());
            }
        }
    }

    // 런타임까지 유지되며 필드에만 적용할 수 있는 커스텀 어노테이션 정의
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    @interface NotNull {
    }

    // 어노테이션 적용 테스트를 위한 클래스
    static class TestClass {
        @NotNull
        String name; // 이 필드에는 @NotNull 어노테이션이 적용되어 있습니다.
        
        int age; // 이 필드는 어노테이션이 없습니다.
    }
}
