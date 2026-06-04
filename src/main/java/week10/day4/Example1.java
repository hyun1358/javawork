package week10.day4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * [실습 1] FileWriter + BufferedWriter 로 파일 생성 및 쓰기 (Problem 1 연계)
 * 
 * 비유: "새 텍스트 문서 만들고 글 쓰기"
 * FileWriter를 이용해 파일을 생성하고, BufferedWriter 버퍼링 도구를 얹어 
 * 컴퓨터 디스크에 텍스트를 대용량으로 빠르게 쓰는 정석 방법을 다룹니다.
 * try-with-resources 문법을 사용해 작업이 끝나면 자동으로 파일을 닫아줍니다(Auto Close).
 */
public class Example1 {
    public static void main(String[] args) {
        System.out.println("=== [실습 1] FileWriter 파일 생성 및 쓰기 예제 ===");
        
        // try-with-resources: 괄호 안에 선언된 스트림 객체는 블록이 끝나면 자동으로 close() 됩니다.
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("mydata.txt")))
        {
            bw.write("안녕하세요!");
            bw.newLine(); // 운영체제(OS)에 맞춰 줄바꿈을 해줍니다.
            bw.write("두 번째 줄입니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println("mydata.txt 파일 생성 및 쓰기 완료!");
    }
}
