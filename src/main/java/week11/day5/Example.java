package week11.day5;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * [학습 예제] Week 11 Day 5 — private 필드 강제 침투 및 동적 호출
 * 
 * [학습 핵심 이론: 캡슐화 장벽을 넘는 리플렉션]
 * 1. private 필드 강제 접근:
 *    - 외부에서 절대 볼 수 없도록 강력 캡슐화된 `private` 필드라 할지라도, 리플렉션의 `Field.setAccessible(true)`을 선언해 주면 캡슐화 장벽을 일시적으로 허물고 강제로 값을 주입하거나 탈취할 수 있습니다.
 * 
 * 2. 리플렉션 사용 시 주의사항 (실무 트레이드오프):
 *    - 컴파일러의 컴파일 에러 체크 혜택을 전혀 받지 못해 런타임 크래시 위험이 올라갑니다.
 *    - JVM 캐싱 최적화 등을 건너뛰며 직접 메모리를 해킹하듯 작동하므로 성능 오버헤드가 극심합니다. 꼭 필요한 프레임워크 공통 유틸리티 제작 시에만 정밀하게 사용해야 합니다.
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
