package week05.day4;

/**
 * [연습 문제 3] static의 제약
 * 문제: static 메서드 안에서 인스턴스 변수를 사용하려고 하면
 * 어떤 에러가 나는지 확인하고, 해결 방법을 주석으로 적으세요.
 */
public class Problem3 {
    int value = 10;

    public static void main(String[] args) {
        // System.out.println(value); // 여기서 에러 발생

        // static은 인스턴스를 안해도 빌드한떄 jvm에서 빌드되는데 그위에있는 proble3객체가 아직 안만들어져있는 상태에서 int value
        // 라는 객체가 뭔지를 몰라서 오류가 나는걸로 알음
    }
}
