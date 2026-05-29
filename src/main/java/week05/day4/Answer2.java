package week05.day4;

public class Answer2 {
    public static void main(String[] args) {
        // 객체 생성 없이 클래스 이름을 통해 직접 정적 메서드(static method)를 호출합니다.
        System.out.println(MyMath.abs(-10));
    }
}

// [클래스 설명] MyMath 클래스는 상태를 저장하지 않고 기능만 제공하는 정적 메서드 예제입니다.
class MyMath {
    // [메서드 설명] static 키워드를 사용하여 객체 생성 없이 호출할 수 있는 절댓값 계산 메서드입니다.
    static int abs(int n) {
        // 삼항 연산자를 활용하여 n이 음수면 부호를 반전시키고, 양수면 그대로 반환합니다.
        return n < 0 ? -n : n;
    }
}
