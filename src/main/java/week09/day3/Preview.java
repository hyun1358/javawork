package week09.day3;

import java.util.Arrays;
import java.util.List;

/**
 * [예습 파일] Week 09 Day 3 — 스트림(Stream) 기초 개념 및 중간 연산
 * 
 * 스트림은 데이터의 흐름입니다. 
 * 리스트나 배열에 담긴 데이터를 하나씩 꺼내서 원하는 대로 가공(필터링, 변환, 정렬 등)한 뒤 
 * 결과를 내놓는 아주 편리한 도구입니다.
 * 
 * [스트림 사용 3단계]
 * 1. 생성: 데이터 소스로부터 스트림을 만듭니다. (.stream())
 * 2. 중간 연산: 데이터를 가공합니다. (filter, map, sorted, distinct, limit 등) 
 *    - 여러 번 연결해서 쓸 수 있습니다. (파이프라인)
 *    - 중간 연산의 결과는 다시 스트림이므로 계속 다른 중간 연산을 연결할 수 있습니다.
 * 3. 최종 연산: 결과를 내거나 출력하며 스트림을 닫습니다. (forEach, collect 등)
 * 
 * [주요 스트림 중간 연산]
 * - filter(Predicate): 조건에 맞는 요소만 걸러냅니다. (예: 짝수만 필터링)
 * - map(Function): 요소를 다른 값이나 타입으로 변환합니다. (예: 소문자를 대문자로 변환)
 * - sorted(): 요소를 오름차순으로 정렬합니다. 
 * - distinct(): 스트림 내의 중복된 요소들을 깔끔하게 제거합니다.
 * - limit(maxSize): 스트림의 앞부분부터 지정된 개수(maxSize)만큼만 잘라내어 남깁니다.
 */
public class Preview {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Apple", "Banana", "Cherry", "Avocado", "Blueberry", "Apple");

        System.out.println("=== 1. filter와 forEach ===");
        // A로 시작하는 과일만 찾아서 출력하기
        list.stream()
                .filter(s -> s.startsWith("A")) // 'A'로 시작하는 요소만 통과
                .forEach(s -> System.out.println("찾은 과일: " + s));

        System.out.println("\n=== 2. distinct와 limit ===");
        // 중복을 제거(distinct)하고, 앞에서 3개만 잘라내기(limit)
        list.stream()
                .distinct() // 중복된 "Apple" 제거
                .limit(3)   // 앞의 3개("Apple", "Banana", "Cherry")만 남김
                .forEach(s -> System.out.println("중복제거 및 제한: " + s));

        System.out.println("\n=== 3. sorted와 map ===");
        // 정렬(sorted)하고, 대문자로 변환(map)하기
        list.stream()
                .distinct()
                .sorted() // 알파벳 순서대로 정렬 (오름차순)
                .map(String::toUpperCase) // 대문자로 일괄 치환
                .forEach(s -> System.out.println("정렬 및 변환: " + s));
    }
}
