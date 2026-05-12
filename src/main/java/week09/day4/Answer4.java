package week09.day4;

import java.util.Optional;

public class Answer4 {
    public static void main(String[] args) {
        Optional<String> opt = Optional.ofNullable(null);
        System.out.println("결과: " + opt.orElse("데이터 없음"));
    }
}
