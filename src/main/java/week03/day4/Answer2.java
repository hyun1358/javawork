package week03.day4;

public class Answer2 {
    public static void main(String[] args) {
        String[] names = {"Kim", "Lee", "Park"};
        int[] scores = {80, 95, 70};
        for (int i = 0; i < names.length; i++) {
            System.out.printf("%s의 점수는 %d점입니다.\n", names[i], scores[i]);
        }
    }
}
