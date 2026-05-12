package week11.day1;

/**
 * [예습 파일] Week 11 Day 1 — 디자인 패턴 (싱글톤)
 */
public class Preview {
    public static void main(String[] args) {
        // AppConfig config = new AppConfig(); // 불가능 (private 생성자)
        AppConfig config1 = AppConfig.getInstance();
        AppConfig config2 = AppConfig.getInstance();

        // 두 객체는 완전히 동일한 객체입니다. (메모리 낭비 방지)
        System.out.println("같은 객체인가? " + (config1 == config2));
    }
}

class AppConfig {
    private static final AppConfig instance = new AppConfig();

    private AppConfig() {
    } // 외부 생성 막음

    public static AppConfig getInstance() {
        return instance;
    }
}
