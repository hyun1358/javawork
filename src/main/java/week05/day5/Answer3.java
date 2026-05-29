package week05.day5;

public class Answer3 {
    public static void main(String[] args) {
        // 클래스 이름을 통해 설정 정보를 담고 있는 전역 상수에 직접 접근하여 값을 출력합니다.
        System.out.println("최대 유저: " + AppConfig.MAX_USERS);
    }
}

// [클래스 설명] 애플리케이션 전역에서 사용될 설정용 상수들을 모아두는 설정 클래스입니다.
class AppConfig {
    // [필드 설명] static final을 결합하여 메모리에 하나만 존재하고 절대 변하지 않는 전역 상수를 정의합니다.
    static final int MAX_USERS = 1000; // 최대 동시 접속 유저 수
    static final String VERSION = "1.0.0"; // 애플리케이션 버전
}
