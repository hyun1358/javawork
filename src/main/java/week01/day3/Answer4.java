package week01.day3;

/**
 * [정답 + 해설 4] Week 01 Day 3
 */
public class Answer4 {
    public static void main(String[] args) {
        int money = 5000;
        money += 1000;
        System.out.println("1000원 추가 후: " + money);
        money -= 500;
        System.out.println("500원 차감 후: " + money);
    }
}
/*
 [해설]
 +=, -=를 사용하여 기존 변수 값에 연산 결과를 바로 반영할 수 있습니다.
*/
