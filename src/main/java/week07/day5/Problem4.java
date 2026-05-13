package week07.day5;

/**
 * [연습 문제 4] StringBuilder 활용
 * 문제: 반복문 안에서 문자열을 10번 합칠 때 StringBuilder의 append()를 사용하세요.
 */
public class Problem4 {
    public static void main(String[] args)
    {
        // TODO
        String test = "a";
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 10; i++)
        {
            sb.append(test);
        }

        System.out.println(sb);
    }
}
