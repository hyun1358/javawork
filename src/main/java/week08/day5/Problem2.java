package week08.day5;

/**
 * [연습 문제 2] 제네릭 메서드 swap
 * 문제: 배열의 두 인덱스 값을 교환하는 <T> void swap(T[] arr, int i, int j) 메서드를 작성하세요.
 */
public class Problem2 {
    public static void main(String[] args)
    {
        // TODO
        String[] str = {"바나나","사괴","포도","딸기"};
        swap(str,0,3);

        for(String s : str)
        {
            System.out.println(s);
        }
    }

    static <T> void swap(T[] arr, int i, int j)
    {
        T temp;

         temp = arr[i];
         arr[i] = arr[j];
         arr[j] = temp;
    }
}
