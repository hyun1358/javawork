package week01.day3;

/**
 * [정답 + 해설 3] Week 01 Day 3
 */
public class Answer3 {
    public static void main(String[] args) {
        // 논리 연산자 &&(AND)는 양쪽 조건이 모두 참(true)일 때만 결과가 true가 됩니다.
        // 여러 조건을 동시에 만족해야 하는 상황에서 사용합니다.
        int age = 20;
        boolean hasID = true;
        boolean canEnter = (age >= 18) && hasID;
        System.out.println("입장 가능 여부: " + canEnter);
    }
}
/*
 [해설]
 '이고(AND)' 조건이므로 && 연산자를 사용합니다.
*/
