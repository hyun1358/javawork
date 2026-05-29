package week04.day1;

/*
 * [정답 + 해설 2] Week 04 Day 1
 * 문제: 두 정수의 합을 반환하는 add 메서드 작성
 */
public class Answer2 {
    // 메인 메서드: 덧셈 메서드(add)를 호출하고 결과를 출력하는 로직 실행
    public static void main(String[] args) {
        // add 메서드에 인자(15, 25)를 전달하여 호출하고 반환된 결과값을 sum 변수에 저장
        int sum = add(15, 25); // 메서드 호출 및 결과 저장
        // 저장된 결과를 활용하여 화면에 출력
        System.out.println("15 + 25 = " + sum);
    }

    // int 반환형: 결과값으로 int형 데이터를 돌려줍니다.
    // 매개변수 a와 b를 입력받아 두 수의 합을 계산함
    public static int add(int a, int b) {
        // 덧셈 연산 결과(a + b)를 자신을 호출한 곳으로 반환(return)
        return a + b; // return 키워드로 값을 전달합니다.
    }
}
/*
 * [해설]
 * - 메서드 선언에서 'int'는 반환될 데이터의 자료형을 의미합니다.
 * - 반환값은 메서드가 호출된 그 자리에 전달됩니다.
 */
