package week04.day1;

public class Answer4 {

    // printArraySum 메서드: 내부적으로 배열을 생성하고 합계를 구해 출력
    static void printArraySum() {
        // 메서드 내에서만 사용되는 지역 변수 배열 생성
        int[] arr = {1, 2, 3, 4, 5};
        // 누적 합계를 저장할 지역 변수 초기화
        int sum = 0;
        
        // 향상된 for문으로 배열의 모든 요소를 순회하며 sum에 누적
        for (int num : arr) {
            sum += num;
        }
        // 계산된 배열의 합계 출력
        System.out.println("배열 합계: " + sum);
    }

    // 메인 메서드: 프로그램 실행의 진입점
    public static void main(String[] args) {
        // 복잡한 합산 로직이 메서드 안으로 들어갔습니다.
        // 메서드를 호출함으로써 깔끔하고 읽기 쉬운 코드 작성 가능
        printArraySum();

        /*
         * [상세 해설]
         * 1. 지역 변수의 범위
         *    - 메서드 안에서 선언된 변수(arr, sum)는 그 메서드가 끝나는 순간 메모리에서 사라집니다.
         *    - 이를 '지역 변수'라고 부르며, 다른 메서드와 변수 이름이 겹쳐도 상관없게 해주는 편리한 특징입니다.
         */
    }
}
