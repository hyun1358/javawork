package week11.day5;

import java.lang.reflect.Method;

/**
 * [예습 파일] Week 11 Day 5 — 리플렉션 (Reflection)
 */
public class Preview {
    public static void main(String[] args) throws Exception {
        // 클래스 정보 얻기
        Class<?> clazz = Class.forName("week11.day5.TargetObj");
        Object obj = clazz.getDeclaredConstructor().newInstance();

        // 런타임에 동적으로 메서드 이름으로 호출하기
        Method m = clazz.getMethod("hello");
        m.invoke(obj);
    }
}

class TargetObj {
    public void hello() {
        System.out.println("리플렉션으로 호출되었습니다.");
    }
}
