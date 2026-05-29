package week04.day4;

public class Answer1 {
    // 메인 메서드: 재귀 함수를 이용한 카운트다운 로직 테스트
    public static void main(String[] args) {
        // 10부터 시작하여 1씩 감소하며 출력하는 재귀 메서드 호출
        countDown(10);
    }

    // countDown 메서드: 재귀 호출을 통해 반복문 없이 숫자를 출력
    public static void countDown(int n) {
        // [기저 조건(Base Case)] 재귀 호출을 멈추는 탈출 조건
        // n이 1보다 작아지면 더 이상 호출하지 않고 반환(return)
        if (n < 1) return;
        
        // 현재 숫자를 출력
        System.out.print(n + " ");
        // n-1을 인자로 하여 자기 자신(countDown)을 다시 호출
        countDown(n - 1);
    }
}
