package week01.day1;

/**
 * [예습 파일] Week 01 Day 1 — 자바 기초 출력
 * <p>
 * ▶ 이 파일을 먼저 실행해보세요!
 * 오늘 배울 내용을 코드로 미리 구경할 수 있습니다.
 */
public class Preview {
    public static void main(String[] args) {
        // === 오늘 배울 것들 ===

        // 1. 화면에 글자 출력하기 (줄바꿈 포함)
        System.out.println("안녕하세요! 자바 입문을 환영합니다.");

        // 2. 화면에 글자 출력하기 (줄바꿈 없음)
        System.out.print("이것은 ");
        System.out.print("이어서 출력됩니다.\n");

        // 3. 형식 맞춰 출력하기
        System.out.printf("이름: %s, 나이: %d살, 키: %.1fcm%n", "홍길동", 20, 175.5);

        // 4. 주석 사용법
        // 이것은 한 줄 주석입니다.
        /* 이것은 
           여러 줄 주석입니다. */

        System.out.println("--- 오늘 배울 내용 미리보기 끝 ---");
    }
}
