package week12.day5;

public class Example {
    public static void main(String[] args) {
        System.out.println("=== Lab 1~4: Repository 패턴 구조 ===");
        
        System.out.println("\n=== Lab 5: DI — File 버전으로 실행 ===");
        DataRepository fileRepo = new FileDataRepository();
        DataService serviceWithFile = new DataService(fileRepo); 
        serviceWithFile.process("안녕하세요, 파일 저장!");

        System.out.println("\n=== Lab 5: DI — DB 버전으로 교체하여 실행 ===");
        DataRepository dbRepo = new DbDataRepository();
        DataService serviceWithDb = new DataService(dbRepo); 
        serviceWithDb.process("안녕하세요, DB 저장!");

        System.out.println("\n=== Lab 5: DI — 테스트용 Mock 버전 ===");
        DataRepository mockRepo = new MockDataRepository();
        DataService serviceWithMock = new DataService(mockRepo); 
        serviceWithMock.process("테스트 데이터");
    }

    interface DataRepository {
        void save(String data);
        String get();
    }

    static class FileDataRepository implements DataRepository {
        private String store = null;
        @Override public void save(String data) { store = data; System.out.println("[File] '" + data + "' → 파일에 저장됨"); }
        @Override public String get() { System.out.println("[File] 파일에서 데이터 읽기"); return store; }
    }

    static class DbDataRepository implements DataRepository {
        private String store = null;
        @Override public void save(String data) { store = data; System.out.println("[DB] '" + data + "' → DB에 저장됨 (INSERT)"); }
        @Override public String get() { System.out.println("[DB] DB에서 데이터 읽기 (SELECT)"); return store; }
    }

    static class MockDataRepository implements DataRepository {
        private String store = null;
        @Override public void save(String data) { store = data; System.out.println("[Mock] '" + data + "' → 메모리에 저장 (테스트용)"); }
        @Override public String get() { System.out.println("[Mock] 메모리에서 데이터 읽기"); return store; }
    }

    static class DataService {
        private final DataRepository repository;
        DataService(DataRepository repository) { this.repository = repository; }
        public void process(String input) {
            repository.save(input);
            String result = repository.get();
            System.out.println("  Service 처리 결과: " + result);
        }
    }
}
