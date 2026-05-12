package week07.day4;

public class Answer2 {
    public static void main(String[] args) {
        throw new MyUncheckedException("언체크드 예외");
    }
}

class MyUncheckedException extends RuntimeException {
    public MyUncheckedException(String m) {
        super(m);
    }
}
