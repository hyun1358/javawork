package week06.day3;

/**
 * [연습 문제 3] instanceof 활용
 * 문제: instanceof 키워드로 타입을 판별하여 다운캐스팅 후 자식 전용 메서드를 실행하세요.
 */
public class Problem3 {
    public static void main(String[] args)
    {
        // TODO
        Parents p = new Child();
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
        if(obj instanceof Child)
        {
            Child c = (Child)obj;
            c.info();
        }
        else
        {
            System.out.println("부모 자식 관계가 아닙니다.");
        }
    }
}
