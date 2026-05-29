package week12.day5;

// 의존성 주입(DI)과 다형성의 기반이 되는 인터페이스를 정의하는 예제입니다.
public class Answer1 {
    // 메인 메서드
    public static void main(String[] args) {
    }

    // 데이터를 저장하고 불러오는 기능을 명세한 공통 인터페이스입니다.
    // 구체적인 저장 방식(파일, DB 등)은 구현 클래스에 위임합니다.
    interface DataRepository {
        void save(String data); // 데이터를 저장하는 메서드
        String get();           // 데이터를 불러오는 메서드
    }
}
