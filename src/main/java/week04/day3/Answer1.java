package week04.day3;

public class Answer1 {
    // 메인 메서드: 서로 다른 타입의 매개변수를 갖는 오버로딩된 메서드 호출 테스트
    public static void main(String[] args) {
        // 문자형('A') 인자를 전달하여 매개변수가 char인 print 메서드 호출
        print('A');
        // 논리형(true) 인자를 전달하여 매개변수가 boolean인 print 메서드 호출
        print(true);
    }

    // print 메서드 오버로딩 1: 문자(char) 타입의 데이터를 매개변수로 받음
    public static void print(char c) {
        System.out.println("문자: " + c);
    }

    // print 메서드 오버로딩 2: 논리(boolean) 타입의 데이터를 매개변수로 받음
    public static void print(boolean b) {
        System.out.println("논리: " + b);
    }
}
