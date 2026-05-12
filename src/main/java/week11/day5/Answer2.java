package week11.day5;

import java.lang.reflect.Field;

public class Answer2 {
    public static void main(String[] args) throws Exception {
        Dummy d = new Dummy();
        Field f = Dummy.class.getDeclaredField("age");
        f.setAccessible(true);
        System.out.println("age 값: " + f.get(d));
    }
}

class Dummy {
    private int age = 20;
}
