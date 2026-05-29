package week04.day1;

public class Answer3 {

    // drawStars 메서드: 호출될 때마다 별 5개를 한 줄에 출력
    static void drawStars() {
        System.out.println("*****");
    }

    // 메인 메서드: 작성된 메서드를 테스트
    public static void main(String[] args) {
        // 복사 붙여넣기 대신 메서드 이름만 호출!
        // 중복 코드를 줄이고 가독성을 높이기 위해 메서드를 두 번 호출
        drawStars();
        drawStars();

        /*
         * [상세 해설]
         * 1. 코드 응집도
         *    - "별 5개 찍기"라는 하나의 구체적인 동작을 drawStars라는 이름 뒤로 숨겼습니다.
         *    - 나중에 별 5개가 아니라 10개로 바꾸고 싶다면, main을 건드릴 필요 없이
         *      drawStars 내부의 한 줄만 수정하면 됩니다. 이것이 유지보수의 시작입니다.
         */
    }
}
