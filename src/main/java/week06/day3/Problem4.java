package week06.day3;

/**
 * [연습 문제 4] ClassCastException 확인
 * 문제: 잘못된 타입으로 다운캐스팅했을 때 발생하는 에러를 실습하세요.
 */
public class Problem4 {
    public static void main(String[] args)
    {
        // TODO
        Parents p = new Parents();
        Instanceof(p);
    }

    static class Parents
    {
        void info() {
            System.out.println("나는 부모입니다.");
        }
    }

    static class Child extends Parents
    {
        @Override
        void info()
        {
            System.out.println("나는 자식");
        }
    }

    static void Instanceof(Object obj)
    {
        Child c = (Child)obj;
        c.info();
    }
}
