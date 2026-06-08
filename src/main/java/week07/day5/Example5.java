package week07.day5;

/**
 * [학습 예제 5] Week 07 Day 5 — String 클래스와 효율적 가공
 * 
 * [학습 핵심 이론: 실무형 문자열 제어와 성능 최적화]
 * 4. String.format()의 정렬/패딩 옵션:
 *    - `%s`, `%d` 등의 지시어와 자리수 지정(`%-10s`: 10글자 좌측 정렬)을 결합하여 가독성 높은 표(Grid) 형태 출력을 손쉽게 완성할 수 있습니다.
 * 
 * [문제별 학습 목표]
 * - Lab5: String.format을 활용한 정렬 규격 표 출력 (Problem 5 연계)
 */
public class Example5 {
    public static void main(String[] args) {
        System.out.println("\n--- Lab5: String.format을 활용한 정렬 규격 표 출력 (Problem 5 연계) ---");
        Lab5.run();
    }

    static class Lab5 {
        static void run() {
            // Problem 5: String.format 정렬 표 출력
            String[][] userTable = {
                {"홍길동", "85"},
                {"김철수", "100"},
                {"김영희", "92"}
            };

            System.out.println("\n===== [String.format 정밀 정렬 표] =====");
            System.out.printf("%-6s\t%-5s\n", "이름", "점수");
            System.out.println("----------------------------------------");
            for (String[] row : userTable) {
                // %-6s: 6글자 폭 할당 후 좌측 정렬 패딩
                System.out.print(String.format("%-6s\t%-5s\n", row[0], row[1]));
            }
            
            // 보너스: 1,000,000 단위 콤마 쉼표 포맷팅
            System.out.println("----------------------------------------");
            System.out.println(String.format("보너스 천단위 콤마 서식: %,d원", 1000000));
        }
    }
}
