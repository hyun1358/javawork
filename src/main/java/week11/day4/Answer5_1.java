package week11.day4;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

/**
 * [보충 문제 5_1 정답] 어노테이션 속성 읽기 및 길이 검증
 */
public class Answer5_1 {
    public static void main(String[] args) {
        User user1 = new User("Kim", "12345"); // 정상
        User user2 = new User("A", "password12345678"); // name 최소 미달, password 최대 초과
        
        System.out.println("--- user1 검증 ---");
        validateLength(user1);
        
        System.out.println("\n--- user2 검증 ---");
        validateLength(user2);
    }

    static void validateLength(Object obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field f : fields) {
            // @Length 어노테이션이 붙어 있는지 확인
            if (f.isAnnotationPresent(Length.class)) {
                f.setAccessible(true);
                try {
                    Object val = f.get(obj);
                    // String 타입 필드인 경우에만 검증 수행
                    if (val instanceof String) {
                        String str = (String) val;
                        // 어노테이션 정보 객체 획득
                        Length lengthAnno = f.getAnnotation(Length.class);
                        int min = lengthAnno.min();
                        int max = lengthAnno.max();
                        int currentLen = str.length();

                        if (currentLen < min || currentLen > max) {
                            System.out.println("검증 실패: '" + f.getName() + "' 필드의 길이는 " + min + "~" + max + "자 사이여야 합니다. (현재 길이: " + currentLen + ")");
                        } else {
                            System.out.println("검증 통과: '" + f.getName() + "' = " + str);
                        }
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // @Length 어노테이션 정의 (min, max 속성 포함)
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    @interface Length {
        int min() default 0;
        int max() default Integer.MAX_VALUE;
    }

    static class User {
        @Length(min = 2, max = 5)
        private String name;
        
        @Length(min = 4, max = 10)
        private String password;

        User(String name, String password) {
            this.name = name;
            this.password = password;
        }
    }
}
