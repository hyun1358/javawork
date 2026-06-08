package week01.day2;

/**
 * [학습 예제 3] Week 01 Day 2 — 변수와 기본 자료형 및 데이터 특징
 * 
 * [학습 핵심 이론: 변수 선언과 메모리 자료형]
 * 3. 실수 정밀도 (Precision):
 *    - float는 소수점 이하 약 7자리까지 정밀도를 보장합니다.
 *    - double은 소수점 이하 약 15자리까지 높은 정밀도를 보장하여 실무 연산에 기본 채택됩니다.
 * 
 * [문제별 학습 목표]
 * - Lab3: 실수 정밀도 차이 (double vs float)
 */
public class Example3 {
    public static void main(String[] args) {
        System.out.println("--- Lab3: 실수 정밀도 차이 (double vs float) ---");
        Lab3.run();
        System.out.println("\n[해설] double은 float보다 두 배 가량 더 세밀하게 소수점 이하 자리(정밀도)를 유실 없이 표현합니다.");
    }

    static class Lab3 {
        static void run() {
            double piDouble = 3.141592653589793;
            float piFloat = 3.141592653589793f; // f 접미사 필수
            System.out.println("double 정밀도: " + piDouble); // 원본 그대로 소수점 다량 출력
            System.out.println("float 정밀도: " + piFloat); // 중간에 정밀도가 깨지거나 잘림
        }
    }
}
