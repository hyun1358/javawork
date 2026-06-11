package week11.day4;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

/**
 * [보충 문제 5_1] 어노테이션 속성 읽기 및 길이 검증
 * 
 * 문제:
 * 1. 필드 전용 어노테이션 `@Length`를 정의하세요.
 *    - 이 어노테이션은 `min` (최소 길이, 기본값 0)과 `max` (최대 길이, 기본값 Integer.MAX_VALUE) 속성을 가집니다.
 *    - 프로그램 실행 시점에 리플렉션으로 읽을 수 있도록 설정하세요.
 * 2. `validateLength(Object obj)` 메서드를 구현하여, `@Length`가 붙은 String 타입 필드의 문자열 길이를 검증하세요.
 *    - 필드 값이 null인 경우는 무시하고 넘어갑니다.
 *    - 필드 값(문자열)의 길이가 설정된 `min`보다 작거나 `max`보다 크면 검증 실패 메시지를 출력하고, 범위 내에 있으면 검증 통과 메시지를 출력하세요.
 */
public class Problem5_1
{
    public static void main(String[] args)
    {
        User user1 = new User("Kim", "12345"); // 정상
        User user2 = new User("A", "password12345678"); // name 최소 미달, password 최대 초과
        
        System.out.println("--- user1 검증 ---");
        validateLength(user1);
        
        System.out.println("\n--- user2 검증 ---");
        validateLength(user2);
    }

    static void validateLength(Object obj)
    {
        // TODO: 리플렉션을 이용해 @Length 어노테이션 속성을 읽고 문자열 길이를 검증하세요.
        // 출력 예시:
        // - 실패 시: "검증 실패: '{필드명}' 필드의 길이는 {min}~{max}자 사이여야 합니다. (현재 길이: {현재길이})"
        // - 성공 시: "검증 통과: '{필드명}' = {값}"
        Field[] field = obj.getClass().getDeclaredFields();
        for(Field f : field)
        {
            f.setAccessible(true);
            if(f.isAnnotationPresent(Length.class))
            {
                try
                {
                    Length lengthAnno = f.getAnnotation(Length.class);
                    int min = lengthAnno.min();
                    int max = lengthAnno.max();

                    String s = (String) f.get(obj);
                    if (s == null) continue;

                    if (s.length() < min || s.length() > max) {
                        System.out.println("검증 실패: " + f.getName() + " 필드의 길이는 {" + min + "~" + max + "}자 사이여야 합니다. 현재 길이: {" + s.length() + "}");
                    } else {
                        System.out.println("검증 통과 : " + f.getName() + " = " + s);
                    }
                }//try
                catch(IllegalAccessException e)
                {
                    e.printStackTrace();
                }//catch

            }//if
        }//for
    }

    // TODO: @Length 어노테이션 정의 (min, max 속성 포함)
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    @interface Length
    {
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