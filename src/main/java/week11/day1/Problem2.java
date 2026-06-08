package week11.day1;

/**
 * [연습 문제 2] 게으른 초기화 (Lazy Initialization)
 * 문제: 객체를 미리 만들지 않고, getInstance()가 처음 호출될 때 객체를 생성하는
 * 싱글톤 코드를 작성하세요.
 */
public class Problem2 {
    public static void main(String[] args)
    {
        // TODO
        LaySington l1 = LaySington.getLaySington();
        LaySington l2 = LaySington.getLaySington();
        System.out.println(l1==l2);
    }

    static class LaySington
    {
        private static LaySington laySington;

        private LaySington()
        {
            System.out.println("최초 1회 실행");
        }

        public static synchronized LaySington getLaySington()
        {
            if(laySington == null)
            {
                return laySington = new LaySington();
            }
            return laySington;
        }

    }
}
