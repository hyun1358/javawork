package week12.day5;

// 의존성 주입(DI)과 다형성을 활용하여 서비스 코드를 수정하지 않고 저장 방식을 유연하게 변경하는 예제입니다.
public class Answer5 {
    // 메인 메서드
    public static void main(String[] args) {
        // AppService를 생성할 때 FileDataRepository 객체를 주입합니다.
        AppService svc1 = new AppService(new FileDataRepository());
        // 파일에 저장됩니다.
        svc1.process("홍길동");

        // 이번에는 DbDataRepository 객체를 주입합니다. AppService 내부 코드는 전혀 변경되지 않았습니다.
        AppService svc2 = new AppService(new DbDataRepository());
        // DB에 저장됩니다. (다형성 활용)
        svc2.process("이순신");
    }

    // 공통 저장소 인터페이스
    interface DataRepository {
        void save(String data);
        String get();
    }

    // 파일 기반 저장소 구현체
    static class FileDataRepository implements DataRepository {
        public void save(String data) { System.out.println("파일에 저장: " + data); }
        public String get() { return "파일 데이터"; }
    }

    // DB 기반 저장소 구현체
    static class DbDataRepository implements DataRepository {
        public void save(String data) { System.out.println("DB에 저장: " + data); }
        public String get() { return "DB 데이터"; }
    }

    // 비즈니스 로직 처리 서비스
    static class AppService {
        // 인터페이스에 의존
        private DataRepository repo;
        
        // 생성자를 통한 의존성 주입(DI)
        AppService(DataRepository repo) { this.repo = repo; }
        
        // 데이터 처리 및 저장
        void process(String data) {
            System.out.println("데이터 가공 중...");
            repo.save(data); // 주입된 객체의 오버라이딩된 메서드가 다형성에 의해 호출됩니다.
        }
    }
}
