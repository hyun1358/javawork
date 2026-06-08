package week11.day1;

public class Answer1_1 {
    public static void main(String[] args) {
        // 싱글톤 인스턴스 2개를 얻어옴
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // 두 레퍼런스가 동일한 인스턴스를 가리키는지 검증
        System.out.println("logger1 == logger2 : " + (logger1 == logger2)); // true 예상

        // 로그 기록 기능 테스트
        logger1.log("시스템을 시작합니다.");
        logger2.log("사용자가 로그인했습니다.");
    }

    static class Logger {
        // 1. 단 하나의 인스턴스를 유지할 private static final 변수
        private static final Logger instance = new Logger();

        // 2. 외부 생성을 차단하는 private 생성자
        private Logger() {}

        // 3. 외부에서 유일한 객체를 얻을 수 있는 정적 팩토리 메서드
        public static Logger getInstance() {
            return instance;
        }

        // 4. 로그 출력을 담당하는 인스턴스 메서드
        public void log(String message) {
            System.out.println("LOG: " + message);
        }
    }
}
