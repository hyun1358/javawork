package week03.day4;

public class Answer3 {
    public static void main(String[] args) {
        String[] names = {"Kim", "Lee", "Park", "Choi"};
        int index = -1;
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals("Park")) {
                index = i;
                break;
            }
        }
        System.out.println("인덱스: " + (index == -1 ? "없음" : index));
    }
}
