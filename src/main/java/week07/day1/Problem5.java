package week07.day1;

/**
 * [연습 문제 5] 다중 catch
 * 문제: 하나의 try 블록 안에서 0나누기 에러와 배열 인덱스 에러를
 * 각각 다른 catch 블록으로 잡아 처리하게 구현하세요.
 */
public class Problem5 {
    public static void main(String[] args)
    {
        // TODO
        try
        {
            int arr[] = new int[3];
            for(int i = 0; i < 3; i++)
            {
                arr[i] = i;
            }

            int result = 5/0;
        }
        catch(ArithmeticException a)
        {
            System.out.println("0나누기 오류");
            a.printStackTrace();
        }
        catch(ArrayIndexOutOfBoundsException index)
        {
            System.out.println("배열 없는 인덱스 접근");
            index.printStackTrace();
        }
    }
}
