package week12.day5;

/**
 * [학습 예제 4] Week 12 Day 5 — Service 계층 도입
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 4] 계층형 아키텍처 (Layered Architecture)
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - Service 계층: 비즈니스 로직 담당
 *  - Repository 계층: 데이터 접근 담당
 *  - 계층 간 분리를 통해 유지보수성 향상
 */
public class Example4 {
    public static void main(String[] args) {
        System.out.println("=== Lab 4: Service 계층 도입 ===");
        DataRepository repo = new MockDataRepository();
        DataService service = new DataService(repo);
        service.process("서비스 데이터");
    }

    interface DataRepository {
        void save(String data);
        String get();
    }

    static class MockDataRepository implements DataRepository {
        private String store;
        @Override public void save(String data) { store = data; }
        @Override public String get() { return store; }
    }

    static class DataService {
        private final DataRepository repository;
        DataService(DataRepository repository) { this.repository = repository; }
        public void process(String input) {
            repository.save(input);
            System.out.println("Service 처리 완료: " + repository.get());
        }
    }
}
