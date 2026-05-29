package week03.day4;

public class Answer5 {
    // 메인 메서드: 문자열 배열의 요소를 역순으로 출력하는 로직 실행
    public static void main(String[] args) {
        // 출력 대상인 문자열 배열 생성
        String[] arr = {"A", "B", "C", "D"};
        
        // 배열의 가장 마지막 인덱스(length - 1)부터 시작하여 0까지 감소하며 순회
        for (int i = arr.length - 1; i >= 0; i--) {
            // 각 요소를 공백으로 구분하여 한 줄에 역순으로 출력
            System.out.print(arr[i] + " ");
        }
    }
}
