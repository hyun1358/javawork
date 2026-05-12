package week06.day5;

/**
 * [연습 문제 4] default 메서드
 * 문제: 인터페이스에 default 메서드를 추가하고, 자식에서 바로 사용해보세요.
 */
public class Problem4 {
    public static void main(String[] args)
    {
        // TODO
        SmartPrinter sp = new SmartPrinter();
        sp.PowerOn();
        sp.print();
        sp.PowerOff();
    }

    interface Machine
    {
        default void PowerOn()
        {
            System.out.println("전원을 킵니다.");
        }

        default void PowerOff()
        {
            System.out.println("전원을 끕니다.");
        }

        void print();
    }

    static class SmartPrinter implements Machine
    {
        public void print()
        {
            System.out.println("결과물을 출력합니다.");
        }
    }
}
