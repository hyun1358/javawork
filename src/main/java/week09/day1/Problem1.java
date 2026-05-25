package week09.day1;

/**
 * [연습 문제 1] 함수형 인터페이스 직접 만들기
 * 문제: 두 수를 받아서 더 큰 수를 반환하는 getMax(int a, int b) 메서드를 가진
 *
 * @FunctionalInterface를 만들고 람다로 구현해 테스트하세요.
 */
public class Problem1 {
    public static void main(String[] args)
    {
        // TODO
        MyFun myfun = (int a, int b) -> a > b ? a : b;
        System.out.println(myfun.getMax(10,20));
    }

}

@FunctionalInterface
interface MyFun
{
    int getMax(int a, int b);
}
