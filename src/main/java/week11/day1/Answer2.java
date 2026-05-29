package week11.day1;

// Lazy Initialization과 동기화를 이용한 싱글톤 패턴 예제입니다.
public class Answer2 {
    // 메인 메서드: 프로그램의 진입점입니다.
    public static void main(String[] args) {
        // 처음으로 getInstance()를 호출할 때 인스턴스가 생성됩니다.
        LazySingleton s1 = LazySingleton.getInstance();
    }

    // 필요할 때까지 객체 생성을 미루는(지연 초기화) 싱글톤 클래스
    static class LazySingleton {
        private static LazySingleton instance; // 생성된 인스턴스를 담을 정적 변수

        // 외부 객체 생성을 차단하는 private 생성자
        private LazySingleton() {}

        // 멀티스레드 환경에서 여러 스레드가 동시에 접근해 객체가 여러 개 생성되는 것을 방지하기 위한 synchronized 동기화
        public static synchronized LazySingleton getInstance() {
            // 인스턴스가 아직 생성되지 않은 경우에만 생성합니다.
            if (instance == null) {
                instance = new LazySingleton();
            }
            return instance; // 생성된 혹은 기존의 인스턴스를 반환합니다.
        }
    }
}
