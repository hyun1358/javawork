package week07.day6;

import java.util.Scanner;

/**
 * [미니 프로젝트] Week 07 Day 6 — 회원가입 시스템 (실습용)
 * <p>
 * 가이드(MiniProjectGuide.java)를 참조하여 예외처리와 문자열 검증 기능을 만드세요.
 */
public class MiniProject {
    public static void main(String[] args)
    {
        // TODO: 유효성 검사 로직 작성
        Scanner sc = new Scanner(System.in);
        UserValidator uv = new UserValidator();
        try
        {
            System.out.print("아이디: ");
            String id = sc.nextLine();
            uv.checkId(id);

            System.out.print("비밀번호: ");
            String pw = sc.nextLine();
            uv.checkPassword(pw);

            System.out.print("이메일: ");
            String email = sc.nextLine();
            uv.checkEmail(email);


            System.out.println("회원가입 완료");
            System.out.printf("아이디 : %s, 비밀번호: %s, 이메일: %s",id,pw,email);
        }
        catch (InvalidDataException e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            sc.close();
        }
    }

    static class InvalidDataException extends Exception
    {
        public InvalidDataException(String massge)
        {
            super(massge);
        }
    }

    static class UserValidator
    {
        void checkId(String id) throws InvalidDataException //5자이상,소문자 숫자만 포함 (아니면 예외)
        {
            if(id.length() >= 5)
            {
                for(int i = 0; i < id.length(); i++)
                {
                    char c = id.charAt(i);
                    if((c >='a' && c <= 'z') || (c >= '0' && c <= '9')) { }
                    else
                    {
                        throw new InvalidDataException("아이디는 소문자, 숫자만 가능합니다.");
                    }
                }

                System.out.println("========== 생성 가능한 아이디 ==========");
            }
            else
            {
                throw new InvalidDataException("아이디가 5자리 미만입니다.");
            }

        }

        void checkPassword(String pw) throws InvalidDataException//8자이상, 특정문자(!@#) 하나 이상 포함(아니면 예외)
        {
            if(pw.length() >= 8)
            {
                if(pw.contains("!") || pw.contains("@") || pw.contains("#"))
                {
                    System.out.println("========== 생성 가능한 비밀번호 ==========");
                }
                else
                {
                    throw new InvalidDataException("비밀번호에는 !@# 중 하나를 포함 해야합니다.");
                }
            }
            else
            {
                throw new InvalidDataException("비밀번호는 8자리 이상 입니다.");
            }
        }

        void checkEmail(String email) throws InvalidDataException// '@','.' 포함 필수(아니면 예외)
        {
            if(!email.contains("@") || !email.contains("."))
            {
                throw new InvalidDataException("이메일 형식이아닙니다.");
            }
            else
            {
                System.out.println("========== 사용가능한 이메일 ==========");
            }
        }
    }

}
