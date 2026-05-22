package week08.day5;

import java.util.Arrays;
import java.util.List;

/**
 * [연습 문제 4-1] 상한 제한 와일드카드 <? extends Number>
 * 
 * 문제: 숫자 타입(Number)의 List라면 어떤 타입이든(Integer, Double 등) 모두 받아서 
 *       모든 원소(Element)의 합을 double 타입으로 합산하여 반환하는 
 *       static double sumOfList(List<? extends Number> list) 메서드를 작성하고 테스트하세요.
 */
public class Problem4_1 {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);
        List<Double> doubleList = Arrays.asList(1.1, 2.2, 3.3);

        System.out.println("Integer 합계 (기대값 15.0): " + sumOfList(intList));
        System.out.println("Double 합계 (기대값 6.6): " + sumOfList(doubleList));
    }

    // TODO: sumOfList 메서드를 여기에 작성하세요.
    // 
    // [힌트 가이드]
    // 1. <? extends Number>로 선언된 리스트 안의 모든 원소(Element)들은 최소한 'Number' 클래스의 하위 클래스임이 100% 보장됩니다.
    // 2. 따라서 for문에서 원소를 꺼낼 때 'Object' 대신 'Number' 타입으로 안전하게 받아낼 수 있습니다: for (Number num : list)
    // 3. Number 클래스가 제공하는 'num.doubleValue()' 메서드를 사용하면 정수든 실수든 모두 double 실수의 형태로 값을 얻어와 합산할 수 있습니다.
    static double sumOfList(List<? extends Number> list)
    {
        double sum = 0;
        for(Number num : list)
        {
            sum+=num.doubleValue();
        }
        return sum;
    }
}

