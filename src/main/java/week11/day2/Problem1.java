package week11.day2;

import java.util.Arrays;
import java.util.Collections;

/**
 * [연습 문제 1] 정렬 전략 패턴
 * 문제: 숫자 배열을 정렬하는 Sorter 클래스에 오름차순/내림차순 전략을 주입받게 만드세요.
 */
public class Problem1 {
    public static void main(String[] args)
    {
        // TODO
        Sorter sorter = new Sorter();
        int[] arr = {13,4,56,1,2,5,6,1,3565};

        sorter.setSortStrategy(new AscendingSortStrategy());
        sorter.sort(arr);

        sorter.setSortStrategy(new DecendingSortStrategy());
        sorter.sort(arr);
    }

    interface SortStrategy
    {
        void sort(int[] arr);
    }

    static class AscendingSortStrategy implements SortStrategy
    {
        @Override
        public void sort(int[] arr)
        {
            Arrays.sort(arr);
            for(int n : arr)
            {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }

    static class DecendingSortStrategy implements SortStrategy
    {
        @Override
        public void sort(int[] arr)
        {
            Arrays.sort(arr);
            for(int i = 0; i < arr.length /2; i++)
            {
                int temp = arr[i];
                arr[i] = arr[arr.length - i -1];
                arr[arr.length - i - 1] = temp;
            }

            for(int n : arr)
            {
                System.out.print(n+" ");
            }
            System.out.println();
        }
    }

    static class Sorter
    {
        SortStrategy sortStrategy;

        public void setSortStrategy(SortStrategy s) {this.sortStrategy=s;}

        public void sort(int[] arr) {this.sortStrategy.sort(arr);}
    }
}
