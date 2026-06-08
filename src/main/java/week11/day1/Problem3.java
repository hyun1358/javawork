package week11.day1;

/**
 * [연습 문제 3] Enum 싱글톤
 * 문제: Enum을 사용하면 가장 안전한 싱글톤을 만들 수 있습니다.
 * Configuration 이라는 enum 싱글톤을 구현하세요.
 */
public class Problem3 {
    public static void main(String[] args)
    {
        // TODO
        Configuration c1 = Configuration.INSTENS;
        Configuration c2 = Configuration.INSTENS;

        System.out.println(c1==c2);
        c1.getVersion();
    }

    enum Configuration
    {
        INSTENS;

        private static final String version = "v1.0.0";

        public void getVersion() {
            System.out.println("버전: " + version);
        }
    }
}
