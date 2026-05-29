package week07.day2;

import java.util.Scanner;

/**
 * Java 7부터 지원하는 try-with-resources 구문을 사용하는 예제입니다.
 */
public class Answer3 {
    public static void main(String[] args) {
        // try-with-resources 구문을 사용하여 Scanner를 생성합니다.
        // 이 구문을 사용하면 try 블록이 끝날 때 자동으로 sc.close()가 호출되어 자원이 해제됩니다.
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("try-with-resources 사용");
        }
    }
}
