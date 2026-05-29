package week03.day5;

public class Answer2 {
    // 메인 메서드: 주사위를 10번 던진 결과의 합계를 구하는 로직 실행
    public static void main(String[] args) {
        // 주사위 결과를 저장할 크기 10의 정수형 배열 생성
        int[] dice = new int[10];
        // 결과의 합계를 저장할 변수 0으로 초기화
        int sum = 0;
        
        // 10번 반복하여 주사위를 던짐
        for (int i = 0; i < 10; i++) {
            // Math.random() * 6은 0.0 이상 6.0 미만 반환
            // (int) 형변환 후 +1 하면 1부터 6까지의 정수가 됨 (주사위 눈금)
            dice[i] = (int) (Math.random() * 6) + 1;
            // 배열에 저장된 현재 주사위 눈금을 합계 변수에 누적
            sum += dice[i];
        }
        
        // 누적된 10번의 주사위 합계 출력
        System.out.println("주사위 합: " + sum);
    }
}
