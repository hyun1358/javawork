package week11.day5;

import java.lang.reflect.Field;

public class Answer4 {
    public static void main(String[] args) throws Exception {
        CopyTarget src = new CopyTarget(10);
        CopyTarget dest = new CopyTarget(0);
        for (Field f : CopyTarget.class.getDeclaredFields()) {
            f.setAccessible(true);
            f.set(dest, f.get(src)); // 복사
        }
        System.out.println(dest.val); // 10
    }
}

class CopyTarget {
    int val;

    CopyTarget(int v) {
        val = v;
    }
}
