package week12.day5;

public class Answer2 {
    public static void main(String[] args) {
    }
}

class FileDataRepository implements DataRepository {
    public void save(String data) {
        System.out.println("파일에 저장: " + data);
    }

    public String get() {
        return "파일 데이터";
    }
}
