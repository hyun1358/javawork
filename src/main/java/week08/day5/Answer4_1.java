package week08.day5;

import java.util.Arrays;
import java.util.List;

/**
 * [연습 문제 4-1 정답 및 이론 해설]
 * 
 * 💡 핵심 이론: 상한 제한 와일드카드 (Upper Bounded Wildcard) `<? extends T>`
 * 
 * 1. 개념:
 *    - `<? extends Number>`는 "Number 클래스이거나, Number를 상속받은 하위 클래스(Integer, Double, Float 등) 중
 *      '어떤 구체적인 타입 하나'를 담는 리스트"를 의미합니다.
 *    - 구체적으로 어떤 타입인지 컴파일 타임에는 확실히 알 수 없기 때문에, 컴파일러는 이 리스트에 새로운 데이터를 추가(Write)하는
 *      행위를 완벽히 금지합니다. (오직 'null'만 추가 가능)
 * 
 * 2. 왜 읽기(Read)는 안전한가?
 *    - 리스트 안에 들어있는 원소가 구체적으로 Integer인지, Double인지는 모르지만, 확실한 한 가지는
 *      "아무리 못해도 최소한 Number 클래스의 하위 타입임이 100% 보장된다"는 점입니다.
 *    - 따라서 리스트에서 원소를 꺼낼 때 `Number` 타입으로 다형성을 적용해 안전하게 받아낼 수 있습니다.
 *      예) for (Number num : list)
 * 
 * 3. PECS (Producer-Extends, Consumer-Super) 법칙:
 *    - 데이터를 외부로 제공(Produce)하여 읽기 작업을 수행할 때는 'extends'를 사용합니다.
 *    - 여기서는 리스트로부터 숫자를 꺼내서(Produce) 합계를 구하므로 `? extends Number`가 가장 적절한 선택입니다.
 */
public class Answer4_1 {
    public static void main(String[] args) {
        // Integer는 Number의 자식 클래스이므로 대입 가능
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);
        
        // Double 역시 Number의 자식 클래스이므로 대입 가능
        List<Double> doubleList = Arrays.asList(1.1, 2.2, 3.3);

        System.out.println("Integer 합계 (기대값 15.0): " + sumOfList(intList));
        System.out.println("Double 합계 (기대값 6.6): " + sumOfList(doubleList));
    }

    /**
     * 숫자 타입의 List라면 어떤 타입이든(Integer, Double 등) 모두 수용하여 
     * 모든 원소의 합을 double 타입으로 연산해 반환하는 메서드
     * 
     * @param list Number 또는 Number의 하위 타입을 원소로 가지는 List
     * @return 리스트 모든 원소의 합 (double)
     */
    static double sumOfList(List<? extends Number> list) {
        double sum = 0;
        
        // 리스트 안의 모든 원소는 최소한 'Number' 타입이 보장되므로, 
        // 다형성에 의해 'Number' 타입 변수로 안전하게 꺼낼 수 있습니다.
        for (Number num : list) {
            // Number 클래스의 추상 메서드인 doubleValue()를 호출하면,
            // 실제 객체가 Integer든 Double든 간에 double 값으로 알아서 자동 형변환되어 반환됩니다.
            sum += num.doubleValue();
        }
        
        return sum;
    }
}
