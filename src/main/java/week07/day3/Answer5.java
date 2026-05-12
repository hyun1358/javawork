package week07.day3;

import java.io.IOException;

public class Answer5 {
    public static void main(String[] args) {
        try {
            wrapTest();
        } catch (RuntimeException e) {
            System.out.println("원인 에러: " + e.getCause());
        }
    }

    public static void wrapTest() {
        try {
            throw new IOException("파일 에러");
        } catch (IOException e) {
            throw new RuntimeException("런타임 예외로 감싸기", e);
        }
    }
}
