package week05.day4;

// [클래스 설명] 정적 초기화 블록(static block)의 실행 시점을 확인하는 예제입니다.
public class Answer4 {
    // [블록 설명] 클래스가 처음 메모리에 로드될 때 단 한 번만 자동으로 실행되는 정적 초기화 블록입니다.
    static {
        System.out.println("클래스 로딩 완료! (딱 한 번만 실행됨)");
    }

    // [메서드 설명] 자바 프로그램이 실행될 때 호출되는 메인 메서드입니다. 정적 블록 이후에 실행됩니다.
    public static void main(String[] args) {
        System.out.println("메인 실행");
    }
}
