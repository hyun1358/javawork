package week11.day4;

import java.lang.reflect.Field;
import java.lang.annotation.*;

public class Answer5 {
    public static void main(String[] args) {
        for (Field f : TestClass.class.getDeclaredFields()) {
            if (f.isAnnotationPresent(NotNull.class)) {
                System.out.println("널 금지 필드: " + f.getName());
            }
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    @interface NotNull {
    }

    static class TestClass {
        @NotNull
        String name;
        int age;
    }
}
