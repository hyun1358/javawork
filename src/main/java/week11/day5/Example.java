package week11.day5;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * [학습 예제] Week 11 Day 5 — private 필드 접근 및 리플렉션을 통한 동적 메서드 호출
 */
public class Example {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Lab 1: private 필드 무력화(접근) ===");
        SecretBox box = new SecretBox();

        Class<?> clazz = box.getClass();
        Field f = clazz.getDeclaredField("secretWord");

        // private 필드 접근 허용! (강력하지만 위험함)
        f.setAccessible(true);

        String word = (String) f.get(box);
        System.out.println("숨겨진 단어는: " + word);

        // 값 변경도 가능
        f.set(box, "해킹됨!");
        box.show();

        System.out.println("\n=== Lab 2: 리플렉션을 통한 동적 메서드 호출 ===");
        runDynamicMethodInvocation();
    }

    public static void runDynamicMethodInvocation() throws Exception {
        // Scanner와 리플렉션을 조합한 동적 메서드 호출 실습
        Scanner sc = new Scanner("Hello Reflection!\n");
        
        // 1. Scanner 클래스의 nextLine 메서드를 동적으로 가져옵니다.
        Method nextLineMethod = Scanner.class.getMethod("nextLine");
        
        // 2. 동적으로 가져온 메서드를 Scanner 객체 인스턴스에 적용하여 실행합니다.
        String result = (String) nextLineMethod.invoke(sc);
        System.out.println("동적 메서드 호출 결과: " + result);
        
        sc.close();
    }
}

class SecretBox {
    private String secretWord = "골드바";

    void show() {
        System.out.println("현재 상태: " + secretWord);
    }
}
