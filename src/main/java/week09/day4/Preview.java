package week09.day4;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;

/**
 * [예습 파일] Week 09 Day 4 — 집계 연산과 Optional
 * 
 * [새로운 개념: 스트림 집계 연산과 Optional]
 * 1. 스트림 집계 연산 (Terminal Operations)
 *    - 스트림의 요소들을 상호작용하여 합계(sum), 평균(average), 최대값(max), 최소값(min), 개수(count) 등의 단일 값으로 산출해내는 최종 연산입니다.
 *    - 일반 객체 스트림(Stream<T>)에는 sum(), average(), max() 등이 정의되어 있지 않으므로, mapToInt() 등을 사용하여 기본형 특화 스트림(IntStream 등)으로 변환한 뒤 집계 연산을 수행해야 합니다.
 *    - 합계(sum)와 개수(count)는 무조건 값이 존재하므로 일반 기본형(int, long)을 반환합니다.
 *    - 하지만 평균(average)과 최대/최소(max/min)는 스트림이 비어있을 경우 반환할 값이 없으므로, null을 안전하게 다루기 위해 각각 OptionalDouble, OptionalInt 등을 반환합니다.
 * 
 * 2. Optional, OptionalDouble, OptionalInt 클래스
 *    - Java 8에 도입된 Optional 계열 클래스들은 'null일 수도 있는 값'을 감싸는 래퍼(Wrapper) 클래스입니다.
 *    - NPE(NullPointerException) 발생을 우아하게 방지하고, null 체크 코드를 지저분하게 작성하지 않도록 도와주는 도구입니다.
 *    - 기본형 특화 Optional(OptionalDouble, OptionalInt 등)은 제네릭을 쓰지 않고 기본형 값을 직접 품어 박싱/언박싱 오버헤드를 줄여줍니다.
 * 
 * [Optional 핵심 메서드]
 * - Optional.of(value): 절대 null이 아닌 객체를 포장할 때 사용 (null이면 NPE 발생)
 * - Optional.ofNullable(value): null일 수도 있는 객체를 포장할 때 사용
 * - Optional.empty(): 빈 Optional 객체 생성
 * - isPresent(): 값이 들어있으면 true, 없으면 false 반환
 * - ifPresent(Consumer): 값이 존재할 때만 전달된 람다식 실행
 * - orElse(defaultValue): 값이 비어있을 경우 인자로 전달된 기본값 반환
 * - orElseGet(Supplier): 값이 비어있을 경우 람다식을 실행하여 결과값을 대체 반환
 * - orElseThrow(): 값이 비어있을 경우 예외 발생시킴
 */
public class Preview {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);

        // 1. 합계 구하기
        // mapToInt()는 Stream<Integer>를 기본형 스트림인 IntStream으로 변환하여 sum() 등의 기본형 특화 연산을 사용할 수 있게 합니다.
        // Integer::intValue는 각 Integer 객체를 int 기본형 값으로 언박싱(Unboxing)하는 메서드 참조입니다.
        int sum = nums.stream().mapToInt(Integer::intValue).sum();
        System.out.println("합계: " + sum);

        // 2. 평균 구하기 (OptionalDouble 반환)
        // average() 메서드는 평균 값을 담은 OptionalDouble 객체를 반환합니다.
        // orElse(0.0)을 통해 만약 스트림이 비어있어 평균을 낼 수 없는 경우 0.0을 반환하도록 대처합니다.
        OptionalDouble avgOpt = nums.stream().mapToInt(Integer::intValue).average();
        double average = avgOpt.orElse(0.0);
        System.out.println("평균: " + average);

        // 3. 최대값 구하기 (OptionalInt 반환)
        // max() 메서드는 스트림의 최대값을 담은 OptionalInt 객체를 반환합니다.
        // orElse(-1)을 통해 최대값을 찾을 수 없는 경우 -1을 반환하도록 설정합니다.
        OptionalInt maxOpt = nums.stream().mapToInt(Integer::intValue).max();
        int max = maxOpt.orElse(-1);
        System.out.println("최대값: " + max);

        // 4. Optional: null일 수도 있는 값을 안전하게 포장하는 래퍼 객체
        // ofNullable은 인자가 null일 가능성이 있을 때 사용하며, null이 들어와도 에러 없이 빈 Optional 객체를 리턴합니다.
        Optional<String> opt = Optional.ofNullable("Hello");
        // ifPresent()는 내부 값이 null이 아닐 때만 전달된 람다식(여기서는 System.out::println 메서드 참조)을 실행하여 NPE를 방지합니다.
        opt.ifPresent(System.out::println);

        // 빈 Optional 객체를 직접 생성할 때는 Optional.empty()를 사용합니다.
        Optional<String> empty = Optional.empty();
        // orElse()는 포장하고 있는 값이 비어있을(null일) 경우, 지정된 기본값("기본값")을 대신 반환하여 안전성을 높입니다.
        System.out.println("빈 값 대체: " + empty.orElse("기본값"));
    }
}
