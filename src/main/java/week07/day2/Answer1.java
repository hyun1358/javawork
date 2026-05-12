package week07.day2;

import java.util.Scanner;

public class Answer1 {
    public static void main(String[] args) {
        Scanner sc = null;
        try {
            sc = new Scanner(System.in);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sc != null) sc.close();
            System.out.println("스캐너 닫힘");
        }
    }
}
