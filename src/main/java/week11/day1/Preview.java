package week11.day1;

/**
 * [예습 파일] Week 11 Day 1 — 디자인 패턴 (싱글톤 패턴)
 * 
 * 디자인 패턴은 선배 개발자들이 "이런 문제는 이렇게 해결하는 게 최고야!"라고 
 * 미리 만들어둔 검증된 코딩 설계 도면입니다.
 * 
 * [싱글톤(Singleton) 패턴]
 * - 정의: 프로그램 전체에서 이 클래스의 객체를 딱 '하나'만 만들어서 돌려쓰는 것.
 * - 왜 쓰나요?
 *   1. 메모리 절약: 똑같은 객체를 수천 개 만들 필요가 없을 때. (예: 설정 정보, 데이터베이스 연결 도구)
 *   2. 데이터 공유: 여러 곳에서 똑같은 데이터를 참조해야 할 때.
 */
public class Preview {
    public static void main(String[] args) {
        // [사용법] new를 쓸 수 없습니다! getInstance()로 가져옵니다.
        // AppConfig config = new AppConfig(); // 에러 발생!
        
        AppConfig config1 = AppConfig.getInstance();
        AppConfig config2 = AppConfig.getInstance();

        // config1과 config2는 이름만 다를 뿐, 주소값이 같은 '똑같은 놈'입니다.
        System.out.println("config1의 주소: " + config1);
        System.out.println("config2의 주소: " + config2);
        System.out.println("둘이 같은 객체인가요? " + (config1 == config2));
    }
}

/**
 * 싱글톤 공식
 */
class AppConfig {
    // 1. 딱 하나만 존재할 객체를 미리 하나 만들어둡니다. (static)
    private static final AppConfig instance = new AppConfig();

    // 2. 생성자를 private으로 막아서 외부에서 new를 못 하게 합니다.
    private AppConfig() { } 

    // 3. 외부에서는 오직 이 메서드를 통해서만 객체를 받아가게 합니다.
    public static AppConfig getInstance() {
        return instance;
    }
}
