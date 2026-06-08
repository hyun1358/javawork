package week11.day1;

/**
 * [보충 문제 1_1] 싱글톤 패턴 캡슐화 강화
 *
 * 문제: 애플리케이션의 공통 로그를 기록하는 Logger 클래스를 싱글톤으로 구현하세요.
 * - 외부에서 new Logger()를 통한 인스턴스 생성이 불가능해야 합니다.
 * - 외부에서 Logger 내의 정적 인스턴스 변수에 직접 접근할 수 없도록 private으로 제한하세요.
 * - 오직 public static Logger getInstance() 메서드를 통해서만 유일한 인스턴스를 얻을 수 있어야 합니다.
 * - Logger 클래스 내부에 public void log(String message) 메서드를 구현하여 "LOG: [메시지]" 가 출력되도록 하세요.
 */
public class Problem1_1 {
    public static void main(String[] args)
    {
        // TODO: Logger의 인스턴스를 두 개 얻어와 동일한 인스턴스인지(==) 비교하고, log() 메서드를 호출해 보세요.
        Logger l1 = Logger.getInstance();
        Logger l2 = Logger.getInstance();
        System.out.println(l1==l2);
    }

    // TODO: Logger 클래스를 정적(static) 내부 클래스로 선언하고 싱글톤 규칙에 맞게 구현하세요.
    static class Logger
    {
        private static final Logger logger = new Logger();

        private Logger(){};

        public static Logger getInstance()
        {
            return logger;
        }

        public void log(String message)
        {
            System.out.println("[log]: "+message);
        }
    }
}
