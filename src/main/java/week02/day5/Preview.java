package week02.day5;

/**
 * [예습 파일] Week 02 Day 5 — break와 continue
 * 
 * [핵심 개념: 반복문 제어 키워드]
 * 1. break 키워드:
 *    - 자신이 속해 있는 가장 가까운 반복문(for, while, do-while) 전체를 즉시 중단하고 블록을 완전히 탈출합니다.
 * 
 * 2. continue 키워드:
 *    - 반복문의 나머지 코드를 실행하지 않고 건너뛴 뒤, 다음 반복 회차(for의 증감식 또는 while의 조건식)로 즉시 점프합니다.
 * 
 * 3. 중첩 루프에서의 레이블(Label) 활용:
 *    - break나 continue 뒤에 레이블명을 선언하면, 다중 루프 구조에서 안쪽 루프가 아닌 레이블로 지정된 가장 바깥쪽 루프를 한 번에 제어할 수 있습니다.
 */
public class Preview {
    public static void main(String[] args) {
        // 1. 구구단 전체 출력 (이중 for문)
        System.out.println("--- 구구단 전체 ---");
        for (int i = 2; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                System.out.printf("%d * %d = %d\t", i, j, i * j);
            }
            System.out.println();
        }

        // 2. 무한 루프와 탈출
        System.out.println("\n--- 무한 루프 탈출 ---");
        int count = 0;
        while (true) {
            count++;
            if (count > 5) break;
            System.out.println("카운트: " + count);
        }
    }
}
