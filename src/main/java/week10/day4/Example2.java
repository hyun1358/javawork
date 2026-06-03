package week10.day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * [실습 2] BufferedReader.readLine() 으로 한 줄씩 읽기 (Problem 2 연계)
 * 
 * 비유: "책을 한 줄씩 넘기면서 정독하기"
 * FileReader로 텍스트 파일을 글자 단위로 읽고, BufferedReader의 readLine() 메서드를 활용해
 * 텍스트 파일을 한 줄씩 문자열로 가져와 출력합니다. 파일의 끝에 도달하면 null을 반환합니다.
 */
public class Example2 {
    public static void main(String[] args) {
        System.out.println("=== [실습 2] BufferedReader 파일 읽기 예제 ===");
        
        // mydata.txt를 읽어옵니다. (실습 1의 mydata.txt 파일이 먼저 생성되어 있어야 합니다.)
        try (BufferedReader br = new BufferedReader(new FileReader("mydata.txt"))) {
            String line;
            // readLine()은 파일 끝(EOF)에 도달하면 null을 돌려줍니다.
            while ((line = br.readLine()) != null) {
                System.out.println("읽어들인 한 줄: " + line);
            }
        } catch (IOException e) {
            System.err.println("파일을 읽는 도중 오류가 발생했습니다. 먼저 실습 1을 실행해 주세요!");
        }
    }
}
