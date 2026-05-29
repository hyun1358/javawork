package week07.day2;

/**
 * finally 블록의 역할에 대해 설명하는 예제입니다.
 */
public class Answer4 {
    public static void main(String[] args) {
        /*
         * finally 블록의 역할:
         * 예외가 발생하면 catch 블록을 거쳐 finally 블록이 실행되고,
         * 예외가 발생하지 않으면 바로 finally 블록이 실행됩니다.
         * 즉, 어떤 상황에서도 리소스를 해제하거나 정리할 때 유용합니다. (예: 파일 닫기, DB 연결 종료 등)
         */
        System.out.println("설명 확인");
    }
}
