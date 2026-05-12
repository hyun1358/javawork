package week04.day1;

/*
 * [정답 + 해설 5] Week 04 Day 1
 * 문제: 세 정수 중 최댓값을 구하는 max 메서드
 */
public class Answer5 {
    public static void main(String[] args) {
        int maxValue = max(10, 25, 7);
        System.out.println("세 수 중 최댓값은: " + maxValue);
    }

    public static int max(int n1, int n2, int n3) {
        // 첫 번째 값을 최댓값으로 가정
        int m = n1;
        // 두 번째 값이 더 크면 최댓값 교체
        if (n2 > m) {
            m = n2;
        }
        // 세 번째 값이 더 크면 최댓값 교체
        if (n3 > m) {
            m = n3;
        }
        return m;
    }
}
/*
 * [해설]
 * - 조건문(if)을 메서드 내에서 활용하여 원하는 결과값을 도출할 수 있습니다.
 * - 복잡한 로직을 메서드로 분리하면 main 코드가 훨씬 읽기 편해집니다.
 */
