package week02.day3;

/**
 * [예습 파일] Week 02 Day 3 — for 반복문
 * <p>
 * ▶ 이 파일을 먼저 실행해보세요!
 * 반복문은 컴퓨터가 가장 잘하는 '단순 반복 작업'을 시키는 방법입니다.
 * for 문을 사용하면 단 몇 줄로 수만 번의 작업도 처리할 수 있습니다.
 */
public class Preview {
    public static void main(String[] args) {
        System.out.println("=== 오늘 배울 내용 미리보기 ===");

        // 1. 기초 for 문 (1부터 5까지 출력)
        System.out.println("1부터 5까지 출력:");
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println("\n");

        // 2. 합계 구하기 (1부터 10까지의 합)
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += i;
        }
        System.out.println("1부터 10까지의 합: " + sum);

        // 3. 중첩 for 문 (구구단 맛보기 - 2단)
        System.out.println("\n구구단 2단:");
        for (int i = 1; i <= 9; i++) {
            System.out.println("2 * " + i + " = " + (2 * i));
        }

        System.out.println("\n--- 미리보기 끝 ---");
    }
}
