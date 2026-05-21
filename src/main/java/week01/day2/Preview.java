package week01.day2;

/**
 * [예습 파일] Week 01 Day 2 — 변수(Variable)와 자료형(DataType)
 * 
 * 변수는 데이터를 저장하는 '바구니'와 같습니다. 
 * 자바는 아주 깐깐해서, 바구니마다 담을 수 있는 물건의 종류가 정해져 있습니다.
 * 
 * [자주 쓰는 바구니(자료형) 종류]
 * 1. int (정수): 1, 2, 100 같은 소수점 없는 숫자
 * 2. double (실수): 3.14, 175.5 같은 소수점 있는 숫자
 * 3. char (문자): 'A', '가' 같은 딱 한 글자 (작은따옴표 ' ' 사용)
 * 4. boolean (논리): true(참) 또는 false(거짓)
 * 5. String (문자열): "안녕하세요" 같은 문장 (큰따옴표 " " 사용)
 */
public class Preview {
    public static void main(String[] args) {
        // [변수 선언 공식] : 자료형 변수명 = 값;
        
        // 1. 정수 (Integer)
        int age = 20;

        // 2. 실수 (Double)
        double height = 175.5;

        // 3. 문자 (Character) - 외자
        char bloodType = 'A';

        // 4. 논리형 (Boolean) - 예/아니오
        boolean isStudent = true;

        // 5. 문자열 (String) - 문장
        String name = "홍길동";

        System.out.println("이름: " + name);
        System.out.println("나이: " + age + "살");
        System.out.println("키: " + height + "cm");
        System.out.println("혈액형: " + bloodType + "형");
        System.out.println("학생여부: " + isStudent);
    }
}
