package week11.day1;

// Enum을 사용하여 스레드 안전성과 직렬화 안전성을 보장하는 싱글톤 예제입니다.
public class Answer3 {
    // 메인 메서드: 프로그램의 시작점
    public static void main(String[] args) {
        // Enum을 통해 선언된 단일 인스턴스(INSTANCE)를 가져옵니다.
        Configuration config = Configuration.INSTANCE;
        // 싱글톤 객체 내부의 메서드를 실행하여 로직을 처리합니다.
        config.printSettings();
    }

    // 가장 권장되는 싱글톤 구현 방법 중 하나인 Enum 타입
    enum Configuration {
        INSTANCE; // JVM에 의해 단 하나의 인스턴스만 생성됨이 보장됩니다.
        
        // 비즈니스 로직을 수행하는 메서드
        public void printSettings() {
            System.out.println("설정 로드됨");
        }
    }
}
