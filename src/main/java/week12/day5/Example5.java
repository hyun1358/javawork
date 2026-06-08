package week12.day5;

/**
 * [학습 예제 5] Week 12 Day 5 — Dependency Injection (DI)
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 5] 의존성 주입 (Dependency Injection)
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - 클래스 내부에서 구체 클래스를 생성(new)하지 않고 외부에서 주입받는 방식
 *  - 코드 변경 없이 실행 시점에 기능을 교체 가능 (유연성)
 */
public class Example5 {
    public static void main(String[] args) {
        System.out.println("\n=== Lab 5: DI — 여러 버전 실행 ===");
        
        DataRepository fileRepo = new FileDataRepository();
        DataService serviceWithFile = new DataService(fileRepo); 
        serviceWithFile.process("파일 저장!");

        DataRepository dbRepo = new DbDataRepository();
        DataService serviceWithDb = new DataService(dbRepo); 
        serviceWithDb.process("DB 저장!");
    }

    interface DataRepository {
        void save(String data);
        String get();
    }

    static class FileDataRepository implements DataRepository {
        private String store;
        @Override public void save(String data) { store = data; System.out.println("[File] 저장: " + data); }
        @Override public String get() { return store; }
    }

    static class DbDataRepository implements DataRepository {
        private String store;
        @Override public void save(String data) { store = data; System.out.println("[DB] 저장: " + data); }
        @Override public String get() { return store; }
    }

    static class DataService {
        private final DataRepository repository;
        DataService(DataRepository repository) { this.repository = repository; }
        public void process(String input) {
            repository.save(input);
            System.out.println("  Service 완료");
        }
    }
}
