package week04.day4;

public class Answer4 {
    // 메인 메서드: 재귀를 이용한 배열 요소의 총합 구하기 테스트
    public static void main(String[] args) {
        // 합계를 구할 정수형 배열 초기화
        int[] arr = {1, 2, 3, 4, 5};
        // sum 메서드 호출 시, 배열과 함께 계산을 시작할 '마지막 인덱스'를 전달
        System.out.println(sum(arr, arr.length - 1));
    }

    // sum 메서드: 배열의 끝 인덱스부터 처음(0)까지 역순으로 요소들을 더하는 재귀 함수
    public static int sum(int[] arr, int n) {
        // [기저 조건(Base Case)] 인덱스가 0에 도달하면 첫 번째 요소 반환 후 재귀 종료
        if (n == 0) return arr[0];
        // 현재 인덱스의 값(arr[n])과 이전 인덱스까지의 합을 재귀적으로 더함
        return arr[n] + sum(arr, n - 1);
    }
}
