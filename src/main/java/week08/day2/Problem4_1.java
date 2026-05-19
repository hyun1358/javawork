package week08.day2;

import java.util.HashMap;
import java.util.Map;

/**
 * [추가 연습 문제 4-1] entrySet() 활용 심화
 * 문제: 다음 제품명과 가격이 담긴 HashMap에서, 
 *       가격이 2000원 이상인 제품만 entrySet()을 사용하여 출력하세요.
 */
public class Problem4_1 {
    public static void main(String[] args) {
        HashMap<String, Integer> products = new HashMap<>();
        products.put("콜라", 1500);
        products.put("사이다", 2000);
        products.put("과자", 1200);
        products.put("초콜릿", 2500);

        // TODO: entrySet()을 사용하여 가격이 2000 이상인 항목만 출력하세요.
        // 출력 예시:
        // 사이다 : 2000
        // 초콜릿 : 2500

        for(Map.Entry<String,Integer> entry : products.entrySet())
        {
            if(entry.getValue()>= 2000)
            {
                System.out.printf("음류: %s, 가격: %d\n",entry.getKey(),entry.getValue());
            }
        }
        
    }
}