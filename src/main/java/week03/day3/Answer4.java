package week03.day3;

public class Answer4 {
    // 메인 메서드: 학생별 점수의 합계와 평균을 계산하는 로직 실행
    public static void main(String[] args) {
        // 2명의 학생(행), 각 3과목(열)의 점수를 저장하는 2차원 배열 초기화
        int[][] scores = {{80, 90, 100}, {70, 60, 50}};

        // 각 학생(행)을 순회
        for (int i = 0; i < scores.length; i++) {
            // 학생별 점수 합계를 저장할 변수 초기화
            int sum = 0;
            // 향상된 for문을 사용하여 해당 학생의 모든 과목 점수를 누적
            for (int score : scores[i]) sum += score;

            // 학생 번호(i + 1), 합계, 그리고 평균(sum / 3.0)을 계산하여 서식 문자열로 출력
            System.out.printf("%d번 학생 - 합계: %d, 평균: %.1f\n", i + 1, sum, sum / 3.0);
        }
    }
}
