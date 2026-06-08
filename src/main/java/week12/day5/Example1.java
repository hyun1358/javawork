package week12.day5;

/**
 * [학습 예제 1] Week 12 Day 5 — Repository 패턴 기초
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 1] Repository 패턴
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - 데이터 소스(DB, File, Memory)에 상관없이 동일한 인터페이스로 데이터에 접근
 *  - 객체 지향적인 관점에서 데이터 계층을 분리
 */
public class Example1 {
    public static void main(String[] args) {
        System.out.println("=== Lab 1: Repository 패턴 기초 ===");
        DataRepository repo = new MemoryDataRepository();
        repo.save("데이터 1");
        System.out.println("가져온 데이터: " + repo.get());
    }

    interface DataRepository {
        void save(String data);
        String get();
    }

    static class MemoryDataRepository implements DataRepository {
        private String store;
        @Override public void save(String data) { this.store = data; }
        @Override public String get() { return store; }
    }
}
