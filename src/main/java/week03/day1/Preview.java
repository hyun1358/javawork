package week03.day1;

/**
 * [예습 파일] Week 03 Day 1 — 1차원 배열(Array) 기초
 * 
 * 배열은 '같은 종류의 데이터'들을 한 줄로 길게 세워놓은 '데이터 기차'와 같습니다.
 * 수백 개의 변수를 일일이 만들 필요 없이, 하나의 이름으로 관리할 수 있습니다.
 * 
 * [배열의 규칙]
 * 1. 기차 칸(방)의 개수를 미리 정해야 합니다. (한 번 정하면 못 바꿈)
 * 2. 각 칸에는 0번부터 번호(인덱스)가 매겨집니다. (중요: 1번이 아닌 0번부터 시작!)
 * 3. array.length 를 사용하면 기차가 총 몇 칸인지 알 수 있습니다.
 */
public class Preview {
    public static void main(String[] args) {
        // 1. 5칸짜리 '정수' 기차 만들기
        // new int[개수] 형식을 사용합니다.
        int[] scores = new int[5];

        // 2. 각 칸에 값 넣기 (번호표는 0번부터!)
        scores[0] = 90; // 1번째 칸
        scores[1] = 85; // 2번째 칸
        scores[2] = 78; // 3번째 칸
        scores[3] = 92; // 4번째 칸
        scores[4] = 88; // 5번째 칸

        // 3. 기차 길이 확인
        System.out.println("우리 기차는 총 " + scores.length + "칸입니다.");

        // 4. 반복문(for)으로 모든 칸의 데이터 구경하기
        System.out.println("\n--- 학생 점수 목록 ---");
        for (int i = 0; i < scores.length; i++) {
            // i가 0, 1, 2, 3, 4로 변하면서 모든 칸을 방문합니다.
            System.out.println(i + "번 방에 저장된 점수: " + scores[i]);
        }
    }
}
