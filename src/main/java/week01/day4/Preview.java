package week01.day4;

/**
 * [예습 파일] Week 01 Day 4 — 형변환 (Casting)
 * 
 * 자료형을 다른 자료형으로 바꾸는 것을 '형변환'이라고 합니다.
 * 바구니의 크기에 따라 자바의 대처가 달라집니다.
 * 
 * 1. 자동 형변환 (Promotion):
 *    - 작은 바구니(int)의 물건을 큰 바구니(double)로 옮길 때 발생합니다.
 *    - 데이터 손실이 없으므로 자바가 알아서 해줍니다.
 * 
 * 2. 강제 형변환 (Casting):
 *    - 큰 바구니(double)의 물건을 작은 바구니(int)로 옮길 때 사용합니다.
 *    - (자료형) 처럼 괄호를 써서 강제로 명령해야 하며, 소수점 같은 데이터가 잘려 나갈 수 있습니다.
 */
public class Preview {
    public static void main(String[] args) {
        // 1. 자동 형변환 (정수 -> 실수)
        int num1 = 10;
        double num2 = num1; 
        System.out.println("int 10을 double에 넣으면? : " + num2); // 10.0

        // 2. 강제 형변환 (실수 -> 정수)
        double pi = 3.99;
        int intPi = (int) pi; // (int)를 안 붙이면 에러가 납니다.
        System.out.println("double 3.99를 int로 강제 변환하면? : " + intPi); // 3 (소수점은 무조건 버림)

        // 3. 문자 -> 숫자 (유니코드/ASCII)
        // 컴퓨터는 모든 글자를 숫자로 관리합니다.
        char ch = 'A';
        int ascii = (int) ch;
        System.out.println("'A'의 숫자 번호는? : " + ascii); // 65

        // 4. 문자열 -> 숫자 (중요!)
        // "100"은 글자일 뿐 숫자가 아닙니다. 계산하려면 바꿔줘야 합니다.
        String str = "100";
        int strToNum = Integer.parseInt(str);
        System.out.println("글자 \"100\" + 1 = " + (strToNum + 1));
    }
}
