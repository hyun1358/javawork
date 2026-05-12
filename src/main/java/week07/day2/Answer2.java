package week07.day2;

public class Answer2 {
    public static void main(String[] args) {
        check();
    }

    public static void check() {
        try {
            System.out.println("try 블록 실행 중. 곧 return 합니다.");
            return;
        } finally {
            System.out.println("return 이전에 finally가 무조건 실행됨!");
        }
    }
}
