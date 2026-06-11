package week11.day4;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

/**
 * [연습 문제 5] 어노테이션 필드 검사
 * 문제: Problem3의 @NotNull이 붙은 필드가 리플렉션으로 찾아지는지 확인하세요.
 */
public class Problem5 {
    public static void main(String[] args)
    {
        // TODO
        Member member = new Member(null,"test@ada.com");
        validateNotNull(member);
    }

    static void validateNotNull(Object obj)
    {
        Field[] field = obj.getClass().getDeclaredFields();
        for(Field f : field)
        {
            if(f.isAnnotationPresent(Notnull.class))
            {
                f.setAccessible(true);
                try
                {
                  if(f.get(obj) == null)
                  {
                      System.out.println("검증 실패: name 필드는 Null 불가 입니다.");
                  }
                  else
                  {
                      System.out.println("검증 통과: name필드 ");
                  }
                }
                catch(IllegalAccessException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    @interface Notnull {}

    static class Member
    {
        @Notnull private String name;
        private String email;

        Member(String name, String email) {this.name = name; this.email = email;}
    }
}
