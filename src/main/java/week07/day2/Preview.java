package week07.day2;

import java.util.Scanner;

/**
 * [예습 파일] Week 07 Day 2 — finally와 리소스 정리
 * 
 * [핵심 개념: 자원 해제와 보장된 실행]
 * 1. finally 블록의 강력한 실행 보장:
 *    - try 블록 내부에서 예외가 성공적으로 처리되든, 예외 발생으로 프로그램이 크래시 직전에 있든, 심지어 return문을 만나 메서드가 조기 종료를 수행하더라도 **무조건 마지막에 100% 실행되는** 특수 제어 영역입니다.
 * 
 * 2. 시스템 리소스 누수(Memory/Resource Leak) 차이점:
 *    - 파일, 소켓, 데이터베이스 커넥션 등 자바 내부가 아닌 외부 OS 리소스를 제어하는 외부 객체들은 GC(Garbage Collector)가 알아서 즉각 회수해 주지 못하므로 강제로 닫는 작업(`.close()`)이 필요합니다.
 *    - 이 close() 호출을 finally에 보증함으로써 리소스 누수를 빈틈없이 방지합니다.
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
