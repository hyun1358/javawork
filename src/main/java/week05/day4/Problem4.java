package week05.day4;

/**
 * [연습 문제 4] static 초기화 블록
 * 문제: static { } 블록을 사용하여 클래스가 로드될 때
 * "클래스 로딩 완료"라는 문구를 한 번만 출력하게 하세요.
 */
public class Problem4 {
    public static void main(String[] args) {
        // 객체 생성 시가 아니라 클래스 참조 시 출력됨을 확인
        Test t = new Test();
    }

    static class Test {
        static {
            System.out.println("클래스 로딩 완료");
        }
    }
}
