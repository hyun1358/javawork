package week11.day5;

import java.lang.reflect.Method;
import java.util.Scanner;

public class Answer3 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner("Hello\n");
        Method m = Scanner.class.getMethod("nextLine");
        String result = (String) m.invoke(sc);
        System.out.println("리플렉션으로 읽은 값: " + result);
    }
}
