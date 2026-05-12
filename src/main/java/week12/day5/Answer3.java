package week12.day5;

public class Answer3 {
    public static void main(String[] args) {
    }
}

class DbDataRepository implements DataRepository {
    public void save(String data) {
        System.out.println("DB에 저장: " + data);
    }

    public String get() {
        return "DB 데이터";
    }
}
