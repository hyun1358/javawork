package week12.day5;

/**
 * [학습 예제 3] Week 12 Day 5 — DB 기반 Repository
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 3] 데이터 소스의 분리
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - 데이터베이스를 이용한 영속성(Persistence) 구현 예시
 */
public class Example3 {
    public static void main(String[] args) {
        System.out.println("=== Lab 3: DB 기반 Repository ===");
        DataRepository dbRepo = new DbDataRepository();
        dbRepo.save("DB 데이터");
    }

    interface DataRepository {
        void save(String data);
    }

    static class DbDataRepository implements DataRepository {
        @Override public void save(String data) { System.out.println("[DB] '" + data + "' 저장됨"); }
    }
}
