package week11.day4;

import java.lang.annotation.*;

public class Answer3 {
    public static void main(String[] args) {
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface NotNull {
}
