package week07.day3;

import java.io.IOException;

public class Answer2 {
    public static void main(String[] args) {
        try {
            doTask();
        } catch (IOException e) {
            System.out.println("잡음!");
        }
    }

    public static void doTask() throws IOException {
        throw new IOException();
    }
}
