package week03.day5;

public class Answer5 {
    // 메인 메서드: 배열 요소들의 절댓값들의 평균을 계산하는 로직 실행
    public static void main(String[] args) {
        // 양수와 음수가 섞여 있는 정수형 배열 초기화
        int[] nums = {-10, 20, -30, 40};
        // 절댓값의 합을 저장할 변수 초기화 (소수점 계산을 위해 double 타입 사용)
        double sum = 0;
        
        // 향상된 for문을 사용하여 배열의 모든 요소를 순회
        for (int n : nums) {
            // Math.abs() 메서드를 사용하여 요소의 부호를 없앤 절댓값을 구한 뒤 sum에 누적
            sum += Math.abs(n);
        }
        
        // 합계를 요소의 개수(배열의 길이)로 나누어 평균을 계산하고 출력
        System.out.println("절대값 평균: " + (sum / nums.length));
    }
}
