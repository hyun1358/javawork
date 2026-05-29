package week11.day4;

import java.lang.annotation.*;

// 커스텀 어노테이션(Annotation)을 직접 정의하는 예제입니다.
public class Answer3 {
    // 메인 메서드
    public static void main(String[] args) {
    }

    // 어노테이션이 유지되는 기간을 RUNTIME으로 지정하여 실행 중에도 리플렉션으로 읽을 수 있게 합니다.
    @Retention(RetentionPolicy.RUNTIME)
    // 이 어노테이션이 적용될 수 있는 대상을 FIELD(멤버 변수)로 한정합니다.
    @Target(ElementType.FIELD)
    // @interface 키워드를 사용하여 새로운 어노테이션 NotNull을 정의합니다.
    @interface NotNull {
    }
}
