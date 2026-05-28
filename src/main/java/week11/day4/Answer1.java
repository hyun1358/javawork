package week11.day4;

public class Answer1 {
    public static void main(String[] args) {
        System.out.println(Day.MONDAY.getKor());
    }

    enum Day {
        MONDAY("월요일"), TUESDAY("화요일");
        private String kor;
        Day(String k) {
            kor = k;
        }
        public String getKor() {
            return kor;
        }
    }
}
