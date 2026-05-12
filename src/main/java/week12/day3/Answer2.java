package week12.day3;

public class Answer2 {
    public static void main(String[] args) {
        System.out.println(toJson(1, "kim"));
    }

    public static String toJson(int id, String name) {
        return String.format("{\"id\":%d, \"name\":\"%s\"}", id, name);
    }
}
