package week12.day5;

/**
 * [학습 예제] Week 12 Day 5 — Repository 패턴 실무 구현
 * 
 * [학습 핵심 이론: 영속성 저장 메커니즘 추상화]
 * 1. Repository 패턴:
 *    - 데이터 저장소의 구체적인 세부 구현(예: 메모리 맵에 저장하는지, 실제 MySQL에 접속하는지 등)을 비즈니스 로직(Service)에서 눈치채지 못하게 철저히 은닉하고, 인터페이스 뒤로 물리적 DB를 완전히 추상화하여 분리해내는 뛰어난 아키텍처 패턴입니다.
 *    - 메모리 맵 레포지토리와 실제 JDBC 레포지토리로의 유연한 부품 갈아끼우기 마법을 구현하고 그 강력한 유연성을 확인합니다.
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
