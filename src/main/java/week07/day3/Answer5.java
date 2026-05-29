package week07.day3;

import java.io.IOException;

/**
 * 예외 감싸기(Exception Wrapping)의 예제입니다. Checked 예외를 Unchecked 예외로 변경합니다.
 */
public class Answer5 {
    public static void main(String[] args) {
        try {
            wrapTest();
        } catch (RuntimeException e) {
            // RuntimeException으로 감싸진 원래 원인(IOException)을 getCause()로 가져와 출력합니다.
            System.out.println("원인 에러: " + e.getCause());
        }
    }

    public static void wrapTest() {
        try {
            // 강제로 Checked Exception인 IOException을 발생시킵니다.
            throw new IOException("파일 에러");
        } catch (IOException e) {
            // Checked Exception을 잡아서 Unchecked Exception인 RuntimeException으로 감싸서(Wrapping) 다시 던집니다.
            // 이로써 메서드 시그니처에 throws를 선언할 필요가 없어집니다.
            throw new RuntimeException("런타임 예외로 감싸기", e);
        }
    }
}
