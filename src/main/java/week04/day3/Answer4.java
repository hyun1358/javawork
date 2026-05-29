package week04.day3;

public class Answer4 {
    // 메인 메서드: 서로 다른 데이터 타입을 매개변수로 하는 메서드 오버로딩 테스트
    public static void main(String[] args) {
        // 10(정수)을 전달하여 매개변수가 int인 getType 호출
        System.out.println(getType(10));
        // 1.23(실수)을 전달하여 매개변수가 double인 getType 호출
        System.out.println(getType(1.23));
        // "Hello"(문자열)을 전달하여 매개변수가 String인 getType 호출
        System.out.println(getType("Hello"));
    }

    // getType 메서드 오버로딩 1: 정수형 매개변수를 받음
    public static String getType(int v) {
        return "정수";
    }

    // getType 메서드 오버로딩 2: 실수형(double) 매개변수를 받음
    public static String getType(double v) {
        return "실수";
    }

    // getType 메서드 오버로딩 3: 문자열(String) 객체를 매개변수로 받음
    public static String getType(String v) {
        return "문자열";
    }
}
