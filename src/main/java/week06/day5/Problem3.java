package week06.day5;

/**
 * [연습 문제 3] Printable 인터페이스
 * 문제: Printable을 구현하는 다양한 객체들을 통일된 방식으로 출력하게 해보세요.
 */
public class Problem3 {
    public static void main(String[] args)
    {
        // TODO
        Printable[] p = {new Document(), new Photo() };
        for(Printable printable : p)
            printable.print();
    }

    interface Printable
    {
        void print();
    }

    static class Document implements Printable
    {
        @Override
        public void print()
        {
            System.out.println("문서를 출력합니다.");
        }
    }

    static class Photo implements Printable
    {
        @Override
        public void print()
        {
            System.out.println("사진을 출력합니다.");
        }
    }
}
