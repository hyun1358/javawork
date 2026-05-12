package week12.day5;

/**
 * [학습 예제] Week 12 Day 5 — Repository 패턴
 */
public class Example {
    public static void main(String[] args) {
        UserRepository repo = new MemoryUserRepository();
        repo.save("홍길동");
        System.out.println("저장된 이름: " + repo.find());
    }
}

interface UserRepository {
    void save(String name);

    String find();
}

class MemoryUserRepository implements UserRepository {
    String data;

    public void save(String name) {
        data = name;
    }

    public String find() {
        return data;
    }
}
