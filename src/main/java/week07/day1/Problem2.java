package week07.day1;

/**
 * [연습 문제 2] ArrayIndexOutOfBoundsException 잡기
 * 문제: 크기가 2인 배열에 3번째 값을 넣으려 할 때 발생하는 예외를 잡으세요.
 */
public class Problem2 {
    public static void main(String[] args)
    {
        // TODO
        int arr[] = new int[2];
        try
        {
            for(int i = 0; i < 3; i++)
            {
                arr[i] = i;
            }
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
