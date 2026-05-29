package week01.day4;

/**
 * [정답 + 해설 1] Week 01 Day 4
 */
public class Answer1 {
    public static void main(String[] args) {
        // double(실수) 타입 변수를 int(정수) 타입으로 변환할 때는 명시적 형변환(캐스팅)이 필요합니다.
        // 이때 소수점 이하의 값은 반올림되지 않고 완전히 무시(버림)되므로, 데이터 손실이 발생할 수 있습니다.
        double d = 3.99;
        int i = (int) d;
        System.out.println("원본 double: " + d);
        System.out.println("변환된 int: " + i);
    }
}
/*
 [해설]
 double을 int로 변환하면 소수점 아래 자리가 모두 버려집니다. (반올림 아님)
*/
