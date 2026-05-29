package week07.day2;

/**
 * try 블록 내부에 return이 있을 때 finally 블록이 어떻게 동작하는지 보여주는 예제입니다.
 */
public class Answer2 {
    public static void main(String[] args) {
        check();
    }

    public static void check() {
        try {
            System.out.println("try 블록 실행 중. 곧 return 합니다.");
            // return문을 만나더라도 finally 블록이 먼저 실행된 후 메서드를 빠져나갑니다.
            return;
        } finally {
            // try 블록에서 return, break, continue 등이 호출되어도 무조건 실행되는 영역입니다.
            System.out.println("return 이전에 finally가 무조건 실행됨!");
        }
    }
}
