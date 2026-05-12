package week11.day3;

/**
 * [예습 파일] Week 11 Day 3 — 빌더 패턴 (Builder Pattern)
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
