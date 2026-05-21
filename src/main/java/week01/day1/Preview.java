package week01.day1;

/**
 * [예습 파일] Week 01 Day 1 — 자바 기초 출력 (System.out)
 * 
 * 자바 프로그램이 우리와 대화하는 가장 첫 번째 방법은 '화면에 글자를 보여주는 것'입니다.
 * 
 * [핵심 포인트]
 * 1. System.out.println(): 괄호 안의 내용을 출력하고 한 줄을 띄웁니다. (Enter 효과)
 * 2. System.out.print(): 내용을 출력만 하고 줄을 바꾸지 않습니다. (옆에 붙어서 나옴)
 * 3. System.out.printf(): 'f'는 format(형식)을 의미합니다. 복잡한 내용을 예쁘게 정렬해서 보여줄 때 씁니다.
 * 
 * [출력 형식 기호]
 * - %s : 문자열(String)이 들어갈 자리
 * - %d : 정수(Decimal)가 들어갈 자리
 * - %.1f : 소수점 첫째 자리까지 표시할 실수(Float) 자리
 * - %n : 줄바꿈 (printf 전용 엔터)
 */
public class Preview {
    public static void main(String[] args) {
        // === 오늘 배울 것들 ===

        // 1. 화면에 글자 출력하기 (줄바꿈 포함)
        System.out.println("안녕하세요! 자바 입문을 환영합니다.");

        // 2. 화면에 글자 출력하기 (줄바꿈 없음)
        System.out.print("이것은 ");
        System.out.print("이어서 출력됩니다.\n"); // \n도 줄바꿈 기호입니다.

        // 3. 형식 맞춰 출력하기 (printf)
        // %s 자리에 "홍길동", %d 자리에 20, %.1f 자리에 175.5가 쏙 들어갑니다.
        System.out.printf("이름: %s, 나이: %d살, 키: %.1fcm%n", "홍길동", 20, 175.5);

        // 4. 주석(Comment) 사용법
        // 이것은 한 줄 주석입니다. (컴퓨터는 이 부분을 무시해요)
        /* 이것은 
           여러 줄 주석입니다. 
           긴 설명이 필요할 때 사용합니다. */

        System.out.println("--- 오늘 배울 내용 미리보기 끝 ---");
    }
}
