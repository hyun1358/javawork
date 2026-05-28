package week03.day5;

/**
 * [예습 파일] Week 03 Day 5 — 배열 실무 활용
 * 
 * [핵심 개념: 실무 배열 패턴]
 * 1. 통계 연산 (누적 합, 평균, 최댓값, 최솟값):
 *    - 실무 비즈니스 로직에서 배열에 담긴 대량의 데이터를 수치적으로 집계하고 요약하는 가장 보편적인 연산 흐름입니다.
 * 
 * 2. 탐색(Search) 알고리즘 기초:
 *    - 순차 탐색 (Sequential Search): 배열의 처음부터 마지막 요소까지 하나하나 비교하는 기초적인 탐색 방식 (시간복잡도: O(N)).
 * 
 * 3. 빈도수 측정 (Frequency Count):
 *    - 특정 인덱스를 점수나 값으로 치환하여, 특정 데이터가 등장한 횟수를 카운팅하는 기법(빈도 검색 배열)을 예습합니다.
 */
public class Preview {
    public static void main(String[] args) {
        // 1. 랜덤 숫자 (0.0 ~ 0.999...)
        double rand = Math.random();
        System.out.println("기본 랜덤: " + rand);

        // 2. 1~10 사이 정수 만들기
        int num = (int) (Math.random() * 10) + 1;
        System.out.println("1~10 랜덤: " + num);

        // 3. 수학 함수들
        System.out.println("절대값: " + Math.abs(-5));
        System.out.println("최대값: " + Math.max(10, 20));
        System.out.println("반올림: " + Math.round(3.14));
    }
}
