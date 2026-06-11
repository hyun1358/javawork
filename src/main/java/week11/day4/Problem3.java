package week11.day4;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

/**
 * [연습 문제 3] @NotNull 어노테이션
 * 문제: 필드에 적용할 수 있는 @NotNull 이라는 커스텀 어노테이션을 선언하세요.
 */
public class Problem3 {
    public static void main(String[] args)
    {
        // TODO
        Field[] fields = Member.class.getDeclaredFields();
        for(Field f : fields)
        {
            if(f.isAnnotationPresent(NotNUll.class))
            {
                System.out.println(f.getName()+" / "+f.getType().getSimpleName());
            }
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    @interface NotNUll {}

    static class Member
    {
        @NotNUll private String name;
        String email;

        Member(String name, String email) {this.name = name; this.email = email;}
    }
}
