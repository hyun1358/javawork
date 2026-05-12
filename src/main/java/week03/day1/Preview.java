package week03.day1;

/**
 * [예습 파일] Week 03 Day 1 — 1차원 배열 기초
 * <p>
 * ▶ 이 파일을 먼저 실행해보세요!
 * 오늘 배울 내용을 코드로 미리 구경할 수 있습니다.
 * 이해가 안 돼도 괜찮아요 — 그냥 눈에 익히는 목적입니다.
 */
public class Preview {
    public static void main(String[] args) {
        // === 오늘 배울 것들 ===

        // 1. 배열 선언과 생성 (공간 만들기)
        int[] scores = new int[5];

        // 2. 배열 값 넣기 (초기화)
        scores[0] = 90;
        scores[1] = 85;
        scores[2] = 78;
        scores[3] = 92;
        scores[4] = 88;

        // 3. 배열 길이 확인하기
        System.out.println("배열의 길이: " + scores.length);

        // 4. 반복문으로 배열 출력하기
        System.out.println("--- 전체 점수 목록 ---");
        for (int i = 0; i < scores.length; i++) {
            System.out.println(i + "번째 학생의 점수: " + scores[i]);
        }

        System.out.println("--- 오늘 배울 내용 미리보기 끝 ---");
    }
}
