package week12.day5;

// 인터페이스를 의존성으로 가져서(의존성 주입) 결합도를 낮춘 서비스 클래스 예제입니다.
public class Answer4 {
    // 메인 메서드
    public static void main(String[] args) {
    }

    // 의존할 저장소 인터페이스
    interface DataRepository {
        void save(String data);
        String get();
    }

    // 비즈니스 로직을 담당하는 애플리케이션 서비스 클래스
    static class AppService {
        // 구체적인 클래스(FileDataRepository 등)가 아닌 추상적인 인터페이스에 의존합니다.
        private DataRepository repo;

        // 생성자를 통해 외부에서 구현체를 주입(Injection)받습니다.
        // 이를 의존성 주입(Dependency Injection, DI)이라고 합니다.
        AppService(DataRepository repo) {
            this.repo = repo;
        }

        // 비즈니스 로직 수행 후, 주입받은 객체에 데이터 저장을 위임합니다.
        void process(String data) {
            System.out.println("데이터 가공 중...");
            repo.save(data); // 어떤 저장소인지 몰라도 인터페이스에 맞춰 다형성으로 동작합니다.
        }
    }
}
