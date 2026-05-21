package week08.day4;

import java.util.LinkedHashMap;

/**
 * [연습 문제 3] LinkedHashMap
 * 문제: LinkedHashMap에 여러 값을 넣고, 입력한 순서대로 출력됨을 확인하세요.
 */
public class Problem3 {
    public static void main(String[] args)
    {
        // TODO
        LinkedHashMap<String,String> lhm = new LinkedHashMap<>();

        lhm.put("고양이","야옹");
        lhm.put("강아지","멍멍");
        lhm.put("소","음머");
        lhm.put("병아리","삐약삐약");

        for(String s : lhm.keySet())
        {
            System.out.printf("%s의 울음소리 %s\n",s,lhm.get(s));
        }
    }
}
