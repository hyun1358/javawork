package week04.day5;

/**
 * [예습 파일] Week 04 Day 5 — 메서드로 구조화하기
 * 
 * [핵심 개념: 모듈화와 클린 코드 정수]
 * 1. 절차적 코딩의 한계:
 *    - main 메서드 한곳에 수백 줄의 복잡한 로직을 나열하면 가독성이 훼손되고 특정 기능을 재사용하기 불가능해집니다.
 * 
 * 2. 기능별 모듈화 (Modularization):
 *    - 하나의 메서드는 "오직 하나의 기능(Single Responsibility)"만 책임지도록 쪼갭니다.
 *    - 입력값 검증, 연산 처리, 화면 출력 등으로 메서드를 나누면 유지보수가 매우 간단해집니다.
 * 
 * 3. 가독성 높은 메서드 네이밍:
 *    - 동사로 시작하고 메서드의 행위를 명확히 대변하도록 카멜 케이스(CamelCase)로 작성합니다.
 */
public class Preview {
    public static void main(String[] args) {
        // 프로그램 시작, 진행, 종료를 메서드로 분리합니다.
        init();
        run();
        end();
    }

    public static void init() {
        System.out.println("시스템 초기화...");
    }

    public static void run() {
        System.out.println("프로그램 실행 중...");
    }

    public static void end() {
        System.out.println("프로그램 종료.");
    }
}
