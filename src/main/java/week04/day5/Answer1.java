package week04.day5;

public class Answer1 {
    public static void main(String[] args) {
        printHeader("학생 정보");
        printData("이름", "홍길동");
        printFooter();
    }

    public static void printHeader(String title) {
        System.out.println("---------");
        System.out.println(title);
        System.out.println("---------");
    }

    public static void printData(String label, String value) {
        System.out.println(label + ": " + value);
    }

    public static void printFooter() {
        System.out.println("---------");
    }
}
