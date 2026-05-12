package week04.day2;

/**
 * [예습 파일] Week 04 Day 2 — 메서드 매개변수 심화
 * <p>
 * ▶ 매개변수로 무엇을 넘길 수 있을까?
 * - 기본형(int, double): 값 자체가 복사됨 (Call by Value)
 * - 참조형(배열, 객체): 주소(참조)가 전달됨 (원본 변경 가능)
 * - 가변 인자(...): 개수가 정해지지 않은 여러 매개변수
 */
public class Preview {
    public static void main(String[] args) {
        // 1. 기본형 매개변수 (원본 보존)
        int a = 10;
        increase(a);
        System.out.println("기본형 원본 a: " + a);

        // 2. 참조형(배열) 매개변수 (원본 변경)
        int[] arr = {1, 2, 3};
        change(arr);
        System.out.println("배열 원본 arr[0]: " + arr[0]);

        // 3. 가변 인자
        printAll("사과", "바나나", "포도", "딸기");
    }

    public static void increase(int n) {
        n = n + 1; // n의 복사본이 바뀔 뿐
    }

    public static void change(int[] n) {
        n[0] = 99; // 참조 주소를 통해 원본 배열 수정
    }

    public static void printAll(String... words) {
        for (String w : words) {
            System.out.print(w + " ");
        }
        System.out.println();
    }
}
