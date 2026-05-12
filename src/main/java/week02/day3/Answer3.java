package week02.day3;

/*
 * [정답 + 해설 3] Week 02 Day 3
 * 문제: 별 삼각형 출력 (5행)
 */
public class Answer3 {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) { // i는 줄 번호 (1~5)
            for (int j = 1; j <= i; j++) { // j는 별의 개수 (줄 번호만큼 출력)
                System.out.print("*");
            }
            System.out.println(); // 한 줄 출력 후 줄바꿈
        }
    }
}
/*
 * [해설]
 * - 바깥쪽 루프(i)가 1일 때 안쪽 루프(j)는 1번 돌고 별 1개 출력
 * - 바깥쪽 루프(i)가 2일 때 안쪽 루프(j)는 2번 돌고 별 2개 출력...
 * - 이 구조를 이해하는 것이 중첩 반복문의 핵심입니다.
 */
