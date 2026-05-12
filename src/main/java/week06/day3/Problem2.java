package week06.day3;

/**
 * [연습 문제 2] 부모 타입으로 자식 오버라이딩 메서드 호출
 * 문제: 부모 타입 변수를 통해 호출해도 오버라이딩된 자식 메서드가 실행됨을 확인하세요.
 */
public class Problem2 {
    public static void main(String[] args)
    {
        // TODO
        Parents p = new child();
        p.print();
    }

    static class Parents
    {
        void print() {
            System.out.println("나는 부모");
        }
    }

    static class child extends Parents
    {

        @Override
        void print()
        {
            System.out.println("나는 자식");
        }
    }
}
