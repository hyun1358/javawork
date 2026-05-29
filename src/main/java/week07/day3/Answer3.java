package week07.day3;

/*
 * Checked Exception과 Unchecked Exception의 차이점:
 * Checked Exception: 컴파일러가 예외 처리를 확인하는 예외입니다. 반드시 try-catch로 잡거나 throws로 선언해야 컴파일이 됩니다. (예: IOException, SQLException 등 - Exception의 하위 클래스들 중 RuntimeException 제외)
 * Unchecked Exception: 컴파일러가 예외 처리를 강제하지 않는 예외입니다. 실행 도중 발생할 수 있으며 보통 프로그래머의 실수로 발생합니다. (예: NullPointerException 등 - RuntimeException 및 그 하위 클래스들)
 */
public class Answer3 {
    public static void main(String[] args) {
        System.out.println("주석 참조");
    }
}
