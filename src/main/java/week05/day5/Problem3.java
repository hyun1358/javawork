package week05.day5;

/**
 * [연습 문제 3] 설정 상수 클래스
 * 문제: 앱의 최대 사용자 수(1000), 버전("1.0.0") 등을
 * 상수로 관리하는 AppConfig 클래스를 만드세요.
 */
public class Problem3 {
    public static void main(String[] args) {
        // AppConfig.MAX_USERS 출력
        System.out.println(AppConfig.MAX_USERS);

    }

    static class AppConfig {
        public static final int MAX_USERS = 1000;
        public static final String version = "1.0.0";

        private AppConfig() {
        }
    }
}
