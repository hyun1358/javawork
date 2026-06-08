package week01.day1;

/**
 * [학습 예제 4] Week 01 Day 1 — 자바 기초 출력
 * 
 * [학습 핵심 이론: 자바의 출력 스트림과 메소드]
 * 3. Lab 학습 가이드:
 *    - Lab4: 한 줄 주석(//) 및 여러 줄 주석 의 컴파일러 처리 방식 학습
 */
public class Example4 {
    public static void main(String[] args) {
        System.out.println("--- Lab4: 주석(Comment) 사용 ---");
        Lab4.run();
        System.out.println("\n[해설] 주석은 코드 실행에 영향을 주지 않으며 설명을 다는 데 사용됩니다.");
    }

    static class Lab4 {
        static void run() {
            // 한 줄 주석
            /*
               여러 줄 주석
            */
            System.out.println("주석은 화면에 나오지 않아요.");
        }
    }
}
