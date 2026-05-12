package week12.day3;

public class Answer4 {
    public static void main(String[] args) {
        String json = "{\"id\":5}";
        String strVal = json.replaceAll("[^0-9]", ""); // 숫자만 남기기
        int id = Integer.parseInt(strVal);
        System.out.println("추출된 숫자: " + id);
    }
}
