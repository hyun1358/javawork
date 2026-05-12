package week05.day5;

/**
 * [예습 파일] Week 05 Day 5 — final과 상수
 */
public class Preview {
    public static void main(String[] args) {
        // 1. final 변수 (값 변경 불가)
        final int MAX_SCORE = 100;
        // MAX_SCORE = 200; // 에러!

        // 2. static final (진정한 의미의 상수)
        System.out.println("원주율: " + Constants.PI);

        // 3. 불변 객체
        ImmutablePerson p = new Student2("홍길동", 20).toImmutable();
        System.out.println("이름: " + p.name);
    }
}

class Constants {
    public static final double PI = 3.141592;
}

class ImmutablePerson {
    final String name; // 생성 시 할당 후 변경 불가

    ImmutablePerson(String name) {
        this.name = name;
    }
}

class Student2 {
    String n;
    int a;

    Student2(String n, int a) {
        this.n = n;
        this.a = a;
    }

    public ImmutablePerson toImmutable() {
        return new ImmutablePerson(n);
    }
}
