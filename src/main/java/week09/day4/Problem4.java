package week09.day4;

import javax.swing.text.html.Option;
import java.util.Optional;

/**
 * [연습 문제 4] Optional 기본
 * 문제: 값이 들어있을 수도 있고 null일 수도 있는 Optional 객체를 만들고 orElse를 통해 안전하게 꺼내보세요.
 */
public class Problem4 {
    public static void main(String[] args)
    {
        // TODO
        Optional<Integer> nums = Optional.empty();
        System.out.println(nums+", 기본값:"+ nums.orElse(1));
    }
}
