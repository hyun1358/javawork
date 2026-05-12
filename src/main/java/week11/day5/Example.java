package week11.day5;

import java.lang.reflect.Field;

/**
 * [학습 예제] Week 11 Day 5 — private 필드 무력화(접근)
 */
public class Example {
    public static void main(String[] args) throws Exception {
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
    }
}

class SecretBox {
    private String secretWord = "골드바";

    void show() {
        System.out.println("현재 상태: " + secretWord);
    }
}
