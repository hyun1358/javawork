package week05.day5;

public class Answer4 {
    /*
     * [메서드 설명] final 매개변수: 메서드 내부에서 인자 값을 변경하지 못하게 함.
     * 실수를 방지하고 코드의 가독성을 높임.
     */
    static void print(final int n) {
        // [로직 설명] 매개변수 n에 final이 선언되었기 때문에, 메서드 내부에서 새로운 값을 재할당할 수 없습니다.
        // n = 20; // 주석 해제 시 컴파일 에러 발생 (변경 불가!)
        System.out.println(n); // 안전하게 전달받은 값을 출력합니다.
    }

    // [메서드 설명] 프로그램의 진입점으로, print 메서드에 값을 전달하여 실행합니다.
    public static void main(String[] args) {
        print(10);
    }
}
