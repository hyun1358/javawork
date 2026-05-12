package week12.day5;

public class Answer4 {
    public static void main(String[] args) {
    }
}

class AppService {
    private DataRepository repo;

    AppService(DataRepository repo) {
        this.repo = repo;
    }

    void process(String data) {
        System.out.println("데이터 가공 중...");
        repo.save(data);
    }
}
