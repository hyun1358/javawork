package week12.day5;

public class Answer5 {
    public static void main(String[] args) {
        AppService svc1 = new AppService(new FileDataRepository());
        svc1.process("홍길동");

        AppService svc2 = new AppService(new DbDataRepository());
        svc2.process("이순신");
    }
}
