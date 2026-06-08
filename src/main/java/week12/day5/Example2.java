package week12.day5;

/**
 * [학습 예제 2] Week 12 Day 5 — File 기반 Repository
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 2] 데이터 소스의 분리
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - 파일 시스템을 이용한 영속성(Persistence) 구현 예시
 */
public class Example2 {
    public static void main(String[] args) {
        System.out.println("=== Lab 2: File 기반 Repository ===");
        DataRepository fileRepo = new FileDataRepository();
        fileRepo.save("파일 데이터");
    }

    interface DataRepository {
        void save(String data);
    }

    static class FileDataRepository implements DataRepository {
        @Override public void save(String data) { System.out.println("[File] '" + data + "' 저장됨"); }
    }
}
