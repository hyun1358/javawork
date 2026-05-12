package week01.day2;

/**
 * [예습 파일] Week 01 Day 2 — 변수와 자료형
 * <p>
 * 변수(Variable)는 데이터를 저장하는 바구니와 같습니다.
 * 다양한 종류(자료형)의 바구니를 미리 구경해봅시다.
 */
public class Preview {
    public static void main(String[] args) {
        // 1. 정수 (Integer)
        int age = 20;

        // 2. 실수 (Double)
        double height = 175.5;

        // 3. 문자 (Character)
        char bloodType = 'A';

        // 4. 논리형 (Boolean)
        boolean isStudent = true;

        // 5. 문자열 (String)
        String name = "홍길동";

        System.out.println("이름: " + name);
        System.out.println("나이: " + age);
        System.out.println("키: " + height);
        System.out.println("혈액형: " + bloodType);
        System.out.println("학생여부: " + isStudent);
    }
}
