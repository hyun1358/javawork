package week08.day2;

import java.util.HashMap;

/**
 * [연습 문제 2] 단어 빈도수 세기
 * 문제: "apple banana apple orange" 문자열을 자른 뒤, 각 단어가 몇 번 나왔는지 HashMap으로 집계하세요.
 */
public class Problem2 {
    public static void main(String[] args)
    {
        // TODO
        String fruit = "apple banana apple orange";
        String[] fruitArr = fruit.split(" ");
        HashMap<String,Integer> fruitCount = new HashMap<>();
        for(int i = 0; i < fruitArr.length; i++)
        {
            if(fruitCount.get(fruitArr[i]) == null)
            {
                fruitCount.put(fruitArr[i],1);
            }
            else
            {
                fruitCount.put( fruitArr[i], fruitCount.get( fruitArr[i] ) + 1 );
            }
        }

        for(String key : fruitCount.keySet())
        {
            System.out.println(key+" -> " + fruitCount.get(key));
        }

    }
}
