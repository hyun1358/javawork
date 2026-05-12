package week07.day2;

import java.util.Scanner;

/**
 * [예습 파일] Week 07 Day 2 — finally와 리소스 정리
 */
public class Preview {
    public static void main(String[] args) {
        Scanner sc = null;
        try {
            sc = new Scanner(System.in);
            System.out.println("try 블록 실행");
            // 에러가 나든 안 나든!
        } finally {
            System.out.println("finally 블록은 무조건 실행됩니다!");
            if (sc != null) sc.close();
        }
    }
}
