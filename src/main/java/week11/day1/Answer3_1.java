package week11.day1;

public class Answer3_1 {
    public static void main(String[] args) {
        // 1. Enum 싱글톤의 유일한 인스턴스를 가져옵니다.
        AppConfig config = AppConfig.INSTANCE;

        // 2. 초기 기본 설정을 출력해 봅니다.
        config.printSettings();

        // 3. 설정을 변경해 봅니다.
        config.setSettings("MySpringApp", 50);

        // 4. 변경된 설정이 적용되었는지 확인합니다.
        config.printSettings();
        
        // 5. 또 다른 참조를 통해서도 설정이 공유되는지 확인합니다.
        AppConfig anotherConfig = AppConfig.INSTANCE;
        anotherConfig.printSettings(); // MySpringApp, 50 이 동일하게 출력되어야 함 (싱글톤)
    }

    enum AppConfig {
        INSTANCE; // JVM에 의해 유일하게 인스턴스가 관리됨

        // 설정값을 담을 필드 (초기값 지정 가능)
        private String appName = "DefaultApp";
        private int maxConnections = 10;

        // 설정을 갱신하는 메서드
        public void setSettings(String appName, int maxConnections) {
            this.appName = appName;
            this.maxConnections = maxConnections;
        }

        // 설정을 출력하는 메서드
        public void printSettings() {
            System.out.println("App Name: " + appName + ", Max Connections: " + maxConnections);
        }
    }
}
