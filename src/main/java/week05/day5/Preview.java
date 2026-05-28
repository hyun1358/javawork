package week05.day5;

/**
 * [예습 파일] Week 05 Day 5 — final과 상수
 * 
 * [핵심 개념: 변경 불가 및 재할당 금지]
 * 1. final 키워드의 다재다능한 역할:
 *    - final 변수: 선언 및 최초 1회 초기화 이후 절대로 값을 바꿀 수 없는 읽기 전용 변수입니다.
 *    - final 메서드: 자식 클래스에서 이 메서드를 재정의(Overriding)할 수 없도록 강제로 봉인합니다.
 *    - final 클래스: 상속(Inheritance)이 완전히 불가능하도록 차단하여 불변 객체의 안정성을 보존합니다. (예: java.lang.String)
 * 
 * 2. 상수 (Constant):
 *    - 자바에서는 `public static final` 키워드를 조합하여 단 하나의 메모리(static)만 할당되고 완전히 고정(final)된 불변 상수를 정의합니다.
 *    - 가독성과 식별을 위해 대문자 스네이크 케이스(`MAX_VALUE`)로 표기합니다.
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
