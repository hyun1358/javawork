package week05.day5;

/**
 * [학습 예제 3] Week 05 Day 5 — final 키워드와 불변 설계
 * 
 * [문제별 학습 목표]
 * - Lab3: 전역 설정을 상수로 모아 관리하는 AppConfig 클래스 (Problem 3 연계)
 */
public class Example3 {
    public static void main(String[] args) {
        System.out.println("AppConfig 최댓값 설정: " + AppConfig.MAX_USERS);
        System.out.println("AppConfig 버전 정보: " + AppConfig.VERSION);
    }

    // Problem 3: 설정 상수 클래스
    static class AppConfig {
        public static final int MAX_USERS = 1000;
        public static final String VERSION = "1.0.0";
        public static final String OS_ENV = "Linux";

        // 인스턴스화 방지를 위해 기본 생성자를 private으로 잠금
        private AppConfig() {
            throw new AssertionError("상수 전용 클래스이므로 객체를 생성할 수 없습니다.");
        }
    }
}
