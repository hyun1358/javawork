package week07.day5;

public class Answer3 {
    public static void main(String[] args) {
        String data = "홍길동/20/남";
        String[] parts = data.split("/");
        for (String p : parts) System.out.println(p);
    }
}
