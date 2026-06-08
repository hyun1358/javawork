package week11.day1;

/**
 * [보충 문제 3_1] Enum 싱글톤의 활용
 *
 * 문제: 애플리케이션의 설정값을 관리하는 AppConfig 클래스를 Enum 싱글톤으로 구현하세요.
 * - 단 하나의 상수는 INSTANCE로 설정합니다.
 * - Enum 내부에 필드로 appName(String)과 maxConnections(int)를 가집니다.
 * - 설정값을 셋팅할 수 있는 public void setSettings(String name, int conns) 메서드를 구현하세요.
 * - 현재 설정값을 콘솔에 출력하는 public void printSettings() 메서드를 구현하세요.
 *   (형식: "App Name: [appName], Max Connections: [maxConnections]")
 */
public class Problem3_1 {
    public static void main(String[] args)
    {
        // TODO: AppConfig.INSTANCE를 받아와서 설정을 변경하고 출력해 보세요.
        AppConfig a1 = AppConfig.INSTANCE;

        a1.setSettings("Windown",10);

        a1.printSettings();

    }

    // TODO: AppConfig enum을 선언하고 필요한 필드와 메서드를 추가하세요.
    enum AppConfig
    {
        INSTANCE;

        String appName;
        int maxConnections;
        public void setSettings(String name, int conns)
        {
            this.appName = name;
            this.maxConnections=conns;
        }
        public void printSettings()
        {
            System.out.println("App name: ["+appName+"], Max Connections: ["+maxConnections+"]");
        }
    }
}
