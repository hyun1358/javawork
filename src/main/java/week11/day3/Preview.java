package week11.day3;

/**
 * [예습 파일] Week 11 Day 3 — 빌더 패턴 (Builder Pattern)
 * 
 * [핵심 개념: 점진적인 복합 객체 생성]
 * 1. 빌더 패턴 (Builder Pattern):
 *    - 복잡하고 멤버변수가 10개 이상으로 너무 많은 객체를 생성할 때, 인자 개수를 헷갈려 잘못 넣을 위험이 크거나 원하지 않는 필드에 null을 억지로 채워넣는 끔찍한 점토 생성자(Telescoping Constructor)의 재앙을 제거합니다.
 *    - 객체 내부의 정적 멤버 클래스로 Builder를 정의하고, 각 변수명을 메서드명 삼아 `.name("홍길동").age(20).build()`와 같이 점진적으로 필드를 체인식으로 담아 가독성 높게 최종 완성 객체를 빚어내는 모던 아키텍처 패턴입니다.
 */
public class Preview {
    public static void main(String[] args) {
        // 생성자에 인자가 많을 때, 이름을 명시적으로 알면서 객체를 생성할 수 있음.
        User user = new User.Builder()
                .name("홍길동")
                .age(20)
                .address("서울")
                .build();

        System.out.println("생성된 유저: " + user.name + ", " + user.address);
    }
}

class User {
    String name;
    int age;
    String address;

    private User(Builder b) {
        this.name = b.name;
        this.age = b.age;
        this.address = b.address;
    }

    // 내부 정적 클래스로 빌더 구성
    public static class Builder {
        String name;
        int age;
        String address;

        public Builder name(String n) {
            this.name = n;
            return this;
        }

        public Builder age(int a) {
            this.age = a;
            return this;
        }

        public Builder address(String addr) {
            this.address = addr;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
