package week03.day2;

public class Answer4 {
    // 메인 메서드: 배열 내 중복된 요소를 찾는 로직 실행
    public static void main(String[] args) {
        // 중복된 값을 포함하는 정수 배열 초기화
        int[] nums = {10, 20, 30, 20, 40, 10};
        System.out.print("중복된 값: ");
        
        // 배열의 첫 번째 요소부터 순회 (기준 요소)
        for (int i = 0; i < nums.length; i++) {
            // 기준 요소의 다음 요소부터 순회하여 중복 확인
            for (int j = i + 1; j < nums.length; j++) {
                // 두 값이 같다면 중복된 값으로 판단
                if (nums[i] == nums[j]) {
                    // 중복된 값 출력
                    System.out.print(nums[i] + " ");
                }
            }
        }
    }
}
