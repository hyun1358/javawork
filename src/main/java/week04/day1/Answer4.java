package week04.day1;

public class Answer4 {

    static void printArraySum() {
        int[] arr = {1, 2, 3, 4, 5};
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        System.out.println("배열 합계: " + sum);
    }

    public static void main(String[] args) {
        // 복잡한 합산 로직이 메서드 안으로 들어갔습니다.
        printArraySum();

        /*
         * [상세 해설]
         * 1. 지역 변수의 범위
         *    - 메서드 안에서 선언된 변수(arr, sum)는 그 메서드가 끝나는 순간 메모리에서 사라집니다.
         *    - 이를 '지역 변수'라고 부르며, 다른 메서드와 변수 이름이 겹쳐도 상관없게 해주는 편리한 특징입니다.
         */
    }
}
