package week11.day5;

import java.lang.reflect.Method;

/**
 * [예습 파일] Week 11 Day 5 — 리플렉션 (Reflection)
 * 
 * [핵심 개념: 거울에 비춰보듯 클래스 메타정보 동적 분석]
 * 1. 리플렉션 (Reflection)이란:
 *    - 구체적인 클래스 타입을 런타임 시점까지 전혀 모르더라도, 컴파일이 완료된 JVM 로드 클래스 파일 정보(`Class<?>` 객체)를 거울 보듯 샅샅이 투과 분석하여 클래스의 이름, 속한 필드 리스트, 메서드 명세서 등을 실시간으로 추출해 내는 마법의 고난도 API입니다.
 * 
 * 2. 리플렉션의 주요 용도:
 *    - 우리가 매일 쓰는 Spring Framework(DI 컨테이너), Jackson(JSON 파서), JUnit(테스트 도구) 등이 개발자가 만든 클래스 형태를 모르면서도 어노테이션을 파악해 객체를 대신 띄우고 동작시키는 핵심 비법이 바로 이 리플렉션입니다.
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
