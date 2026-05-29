package week07.day3;

import java.io.IOException;

/**
 * throws 키워드를 사용하여 예외를 메서드 호출자에게 던지는 예제입니다.
 */
public class Answer2 {
    public static void main(String[] args) {
        try {
            // doTask 메서드는 IOException을 던질 수 있으므로 try-catch로 감싸서 호출합니다.
            doTask();
        } catch (IOException e) {
            System.out.println("잡음!");
        }
    }

    // throws 키워드를 사용하여 메서드 내부에서 발생하는 IOException을 호출한 곳으로 떠넘깁니다.
    public static void doTask() throws IOException {
        throw new IOException();
    }
}
