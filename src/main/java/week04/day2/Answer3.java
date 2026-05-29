package week04.day2;

public class Answer3 {
    // 메인 메서드: 가변 인자(Variable Arguments)를 사용하는 메서드 테스트
    public static void main(String[] args) {
        // 인자의 개수가 3개인 경우
        System.out.println("합계 1: " + sum(1, 2, 3));
        // 인자의 개수가 5개인 경우 (동일한 메서드 호출)
        System.out.println("합계 2: " + sum(10, 20, 30, 40, 50));
    }

    // sum 메서드: int... 을 사용하여 인자의 개수가 동적으로 변할 수 있도록 처리
    // nums는 내부적으로 배열처럼 취급됨
    public static int sum(int... nums) {
        // 누적 합계를 저장할 변수
        int total = 0;
        // 향상된 for문을 이용하여 전달받은 모든 인자를 순회하며 합산
        for (int n : nums) total += n;
        // 최종 합산 결과 반환
        return total;
    }
}
