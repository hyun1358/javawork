package week07.day6;

import java.util.Scanner;

public class MiniProjectAnswer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("아이디: ");
            String id = sc.nextLine();
            UserValidator.checkId(id);

            System.out.print("이메일: ");
            String email = sc.nextLine();
            UserValidator.checkEmail(email);

            System.out.print("비밀번호: ");
            String pw = sc.nextLine();
            UserValidator.checkPassword(pw);

            System.out.println("회원가입에 성공했습니다!");
        } catch (InvalidDataException e) {
            System.out.println("가입 실패: " + e.getMessage());
        } finally {
            sc.close();
            System.out.println("프로세스 종료.");
        }
    }
}

class InvalidDataException extends Exception {
    InvalidDataException(String msg) {
        super(msg);
    }
}

class UserValidator {
    public static void checkId(String id) throws InvalidDataException {
        if (id.length() < 5) throw new InvalidDataException("아이디가 너무 짧습니다.");
        if (!id.matches("^[a-z0-9]+$")) throw new InvalidDataException("아이디는 소문자와 숫자만 가능합니다.");
    }

    public static void checkEmail(String email) throws InvalidDataException {
        if (!email.contains("@") || !email.contains(".")) {
            throw new InvalidDataException("올바르지 않은 이메일 형식입니다.");
        }
    }

    public static void checkPassword(String pw) throws InvalidDataException {
        if (pw.length() < 8) throw new InvalidDataException("비밀번호는 8자 이상이어야 합니다.");
        if (!(pw.contains("!") || pw.contains("@") || pw.contains("#"))) {
            throw new InvalidDataException("비밀번호에 특수문자(!,@,#)가 포함되어야 합니다.");
        }
    }
}
