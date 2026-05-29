package week02.day5;

/* 정답 파일 Answer1 ~ Answer5 통합 */
public class Answer1 {
    public static void main(String[] args) {
        // 이중 for문을 이용한 역삼각형 별찍기입니다.
        // 바깥쪽 루프의 i가 5부터 1까지 감소하므로, 처음에는 별을 5개 찍고 점차 줄어듭니다.
        for (int i = 5; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
