package week02.day5;

public class Answer2 {
    public static void main(String[] args) {
        // 숫자를 이용한 직각 삼각형 패턴 출력입니다.
        // 안쪽 루프에서 별(*) 대신 숫자 변수(j)를 그대로 출력하여 1, 12, 123 같은 형태를 만듭니다.
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
