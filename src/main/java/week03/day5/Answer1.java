package week03.day5;

public class Answer1 {
    // 메인 메서드: 로또 번호 자동 생성기 로직 실행
    public static void main(String[] args) {
        // 6개의 숫자를 저장할 정수형 배열 생성 (크기 6)
        int[] lotto = new int[6];
        
        // 6번 반복하여 배열의 각 요소에 랜덤 값 할당 (현재는 중복 제거 로직 없음)
        for (int i = 0; i < 6; i++) {
            // Math.random()은 0.0 이상 1.0 미만의 실수를 반환
            // 45를 곱하면 0.0 이상 45.0 미만이 됨
            // (int)로 형변환하면 0부터 44까지의 정수가 됨
            // 여기에 1을 더해 1부터 45까지의 범위로 맞춤
            lotto[i] = (int) (Math.random() * 45) + 1;
        }
        
        // 향상된 for문을 이용하여 배열에 저장된 로또 번호를 순차적으로 출력
        for (int n : lotto) System.out.print(n + " ");
    }
}
