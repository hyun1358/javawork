package week03.day1;

/*
 * [정답 + 해설 1] Week 03 Day 1
 * 문제: 5명 점수 배열에서 합계/평균 구하기
 */
public class Answer1 {
    // 메인 메서드: 프로그램의 시작점
    public static void main(String[] args) {
        // 5명의 점수를 담은 정수형 배열 생성 및 초기화
        int[] scores = {90, 80, 70, 60, 50};
        // 합계를 누적할 변수를 0으로 초기화
        int sum = 0;

        // 1. 합계 구하기
        // 배열의 첫 번째 요소부터 마지막 요소까지 순회
        for (int i = 0; i < scores.length; i++) {
            // 현재 인덱스의 점수를 sum 변수에 누적하여 더함
            sum += scores[i];
        }

        // 2. 평균 구하기
        // 총합을 배열의 길이(학생 수)로 나누어 평균 계산
        // 정확한 소수점 결과를 얻기 위해 sum을 double로 형변환 후 나눔
        double average = (double) sum / scores.length;

        // 계산된 합계 출력
        System.out.println("합계: " + sum);
        // 계산된 평균 출력
        System.out.println("평균: " + average);
    }
}
/*
 * [해설]
 * - sum 변수를 0으로 초기화한 뒤, 반복문을 통해 각 인덱스의 값을 더합니다.
 * - scores.length를 사용하면 배열 크기가 바뀌어도 코드를 수정할 필요가 없습니다.
 * - 평균을 구할 때 sum이나 scores.length 중 하나를 (double)로 형변환해야
 *   소수점 결과가 나옵니다. (정수 / 정수 = 정수 결과가 나오기 때문)
 */
