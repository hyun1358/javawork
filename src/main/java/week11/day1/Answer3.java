package week11.day1;

public class Answer3 {
    public static void main(String[] args) {
        Configuration config = Configuration.INSTANCE;
        config.printSettings();
    }

    enum Configuration {
        INSTANCE;
        public void printSettings() {
            System.out.println("설정 로드됨");
        }
    }
}
