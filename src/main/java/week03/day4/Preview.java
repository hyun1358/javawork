package week03.day4;

/**
 * [예습 파일] Week 03 Day 4 — 문자열 배열
 * 
 * [핵심 개념: String과 문자형 배열]
 * 1. 문자열 배열 (String Array)의 구조:
 *    - `String[] names = new String[5];`와 같이 선언합니다.
 *    - 자바에서 객체 타입인 String은 힙의 특정 구역(String Pool)에 생성되며, 배열의 각 요소에는 힙 주소가 담깁니다.
 * 
 * 2. char[] vs String:
 *    - char[]는 단순한 문자들의 기본형 연속 데이터 배열입니다.
 *    - String은 이 char[] 배열을 내부에 품고, 다양한 문자열 조작 편의 메서드(length(), concat(), substring() 등)를 결합한 참조형 객체 클래스입니다.
 */
public class Preview {
    public static void main(String[] args) {
        // 1. 문자열 배열
        String[] fruits = {"Apple", "Banana", "Cherry"};

        // 2. 병렬 배열 (이름과 점수를 동일한 인덱스로 매칭)
        String[] names = {"홍길동", "이순신", "강감찬"};
        int[] scores = {90, 85, 100};

        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i] + "의 점수: " + scores[i]);
        }
    }
}
