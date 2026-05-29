package week01.day4;

/**
 * [정답 + 해설 3] Week 01 Day 4
 */
public class Answer3 {
    public static void main(String[] args) {
        // char 타입은 문자를 유니코드(아스키코드) 정수값으로 저장합니다.
        // 문자를 int로 강제 형변환(캐스팅)하면 메모리에 저장된 실제 숫자 값을 확인할 수 있습니다.
        System.out.println('A' + " : " + (int) 'A');
        System.out.println('B' + " : " + (int) 'B');
        System.out.println('C' + " : " + (int) 'C');
        System.out.println('D' + " : " + (int) 'D');
        System.out.println('E' + " : " + (int) 'E');
    }
}
/*
 [해설]
 문자를 (int)로 캐스팅하면 아스키(유니코드) 코드 번호를 알 수 있습니다.
*/
