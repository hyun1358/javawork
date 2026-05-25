package week09.day1;

/**
 * [연습 문제 5] 람다를 변수에 담기
 * 문제: 람다식을 변수에 담고, for문 안에서 3번 호출하여 결과를 출력하세요.
 */
public class Problem5 {
    public static void main(String[] args)
    {
        // TODO
        Printer p = msg -> System.out.println("메세지:"+msg);

        for(int i = 0; i < 3; i++)
        {
            p.print(i+"ㅇㅇ");
        }
    }
}
