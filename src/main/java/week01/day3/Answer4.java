package week01.day3;

/**
 * [정답 + 해설 4] Week 01 Day 3
 */
public class Answer4 {
    public static void main(String[] args) {
        // 복합 대입 연산자(+=, -= 등)는 연산과 대입을 동시에 수행하여 코드를 간결하게 만듭니다.
        // money += 1000 은 money = money + 1000 과 같은 의미로 변수 값을 누적시키거나 감소시킬 때 자주 씁니다.
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
