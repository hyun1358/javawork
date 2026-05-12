package week06.day3;

public class Answer4 {
    public static void main(String[] args) {
        Object obj = "String";
        try {
            Integer num = (Integer) obj; // ClassCastException 발생
        } catch (ClassCastException e) {
            System.out.println("다운캐스팅 에러 잡힘: " + e.getMessage());
        }
    }
}
