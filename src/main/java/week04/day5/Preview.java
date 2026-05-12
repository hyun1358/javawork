package week04.day5;

/**
 * [예습 파일] Week 04 Day 5 — 메서드로 구조화하기
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
