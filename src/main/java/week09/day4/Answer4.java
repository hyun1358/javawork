package week09.day4;

import java.util.Optional;

public class Answer4 {
    public static void main(String[] args) {
        // null 값을 허용하는 Optional 객체 생성
        Optional<String> opt = Optional.ofNullable(null);
        
        // Optional에 값이 존재하면 그 값을 반환하고, 값이 비어있다면 "데이터 없음"을 반환
        System.out.println("결과: " + opt.orElse("데이터 없음"));
    }
}
