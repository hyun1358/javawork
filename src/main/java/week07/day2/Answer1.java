package week07.day2;

import java.util.Scanner;

/**
 * try-catch-finally 구문을 이용한 예외 처리 및 자원 해제 예제입니다.
 */
public class Answer1 {
    public static void main(String[] args) {
        Scanner sc = null;
        try {
            // 입력을 받기 위해 Scanner 객체를 생성합니다.
            sc = new Scanner(System.in);
        } catch (Exception e) {
            // 예외 발생 시 에러의 스택 트레이스를 출력합니다.
            e.printStackTrace();
        } finally {
            // 예외 발생 여부와 상관없이 Scanner가 초기화되었다면 닫아주어 자원을 해제합니다.
            if (sc != null) sc.close();
            System.out.println("스캐너 닫힘");
        }
    }
}
