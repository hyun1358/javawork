package week02.day5;

public class Answer4 {
    public static void main(String[] args) {
        // 자바에서는 루프 앞에 이름(라벨)을 붙일 수 있습니다. (예: outer:)
        // 다중 반복문에서 특정 조건을 만족했을 때 break 뒤에 라벨명을 적으면, 가장 가까운 루프뿐만 아니라 
        // 라벨이 붙은 바깥쪽 루프까지 한 번에 탈출할 수 있습니다.
        outer:
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                if (i * j > 100) {
                    System.out.println("탈출! " + i + " * " + j + " = " + (i * j));
                    break outer;
                }
            }
        }
    }
}
