package week11.day4;

import java.lang.reflect.Field;

public class Answer5 {
    public static void main(String[] args) {
        for (Field f : TestClass.class.getDeclaredFields()) {
            if (f.isAnnotationPresent(NotNull.class)) {
                System.out.println("널 금지 필드: " + f.getName());
            }
        }
    }
}

class TestClass {
    @NotNull
    String name;
    int age;
}
