package week01.day4;

/**
 * [예습 파일] Week 01 Day 4 — 형변환 (Casting)
 * <p>
 * 자료형을 다른 자료형으로 바꾸는 것을 형변환이라고 합니다.
 * 자동 형변환과 강제 형변환의 차이를 구경해봅시다.
 */
public class Preview {
    public static void main(String[] args) {
        // 1. 자동 형변환 (작은 바구니 -> 큰 바구니)
        int num1 = 10;
        double num2 = num1;
        System.out.println("int 10 -> double: " + num2);

        // 2. 강제 형변환 (큰 바구니 -> 작은 바구니)
        double pi = 3.14;
        int intPi = (int) pi; // 소수점 잘림
        System.out.println("double 3.14 -> int: " + intPi);

        // 3. 문자 -> 숫자 (ASCII)
        char ch = 'A';
        int ascii = (int) ch;
        System.out.println("'A'의 ASCII 값: " + ascii);

        // 4. 문자열 -> 숫자
        String str = "100";
        int strToNum = Integer.parseInt(str);
        System.out.println("문자열 \"100\" -> 정수: " + strToNum);
    }
}
