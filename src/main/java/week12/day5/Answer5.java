package week12.day5;

public class Answer5 {
    public static void main(String[] args) {
        AppService svc1 = new AppService(new FileDataRepository());
        svc1.process("홍길동");

        AppService svc2 = new AppService(new DbDataRepository());
        svc2.process("이순신");
    }

    interface DataRepository {
        void save(String data);
        String get();
    }

    static class FileDataRepository implements DataRepository {
        public void save(String data) { System.out.println("파일에 저장: " + data); }
        public String get() { return "파일 데이터"; }
    }

    static class DbDataRepository implements DataRepository {
        public void save(String data) { System.out.println("DB에 저장: " + data); }
        public String get() { return "DB 데이터"; }
    }

    static class AppService {
        private DataRepository repo;
        AppService(DataRepository repo) { this.repo = repo; }
        void process(String data) {
            System.out.println("데이터 가공 중...");
            repo.save(data);
        }
    }
}
