package week04.day5;

/**
 * [학습 예제 2] Week 04 Day 5 — 메서드 설계와 문서화
 * 
 * [학습 핵심 이론: 클린 코드와 메서드 문서화 표준]
 * 2. 입력값 검증 (Validation):
 *    - 메서드 초입부에 잘못된 인수 값이 오는지 사전에 체크하여 차단(Guard Clauses)하는 구조로 결함을 방지합니다.
 * 
 * [문제별 학습 목표]
 * - Lab2: 로그인 데이터 길이 유효성 검증 (Problem 2 연계)
 */
public class Example2 {
    public static void main(String[] args) {
        boolean success = isValidLogin("java_user", "pass12345");
        boolean fail = isValidLogin("abc", "123");
        System.out.println("정상 ID/PW 검증 결과: " + success);
        System.out.println("비정상 ID/PW 검증 결과: " + fail);
    }

    public static boolean isValidLogin(String id, String pw) {
        if (id == null || pw == null) {
            return false;
        }
        return id.length() >= 4 && pw.length() >= 8;
    }
}
