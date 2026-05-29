package week10.day4;

import java.io.FileReader;
import java.io.BufferedReader;

/**
 * BufferedReader와 FileReader를 사용하여 파일의 내용을 읽어오는 예제입니다.
 */
public class Answer2 {
    public static void main(String[] args) {
        // mydata.txt 파일을 읽기 위해 FileReader를 생성하고,
        // 성능 향상과 줄 단위 읽기(readLine)를 위해 BufferedReader로 감싸줍니다.
        // try-with-resources를 사용하여 작업 완료 후 자동으로 자원을 해제합니다.
        try (BufferedReader br = new BufferedReader(new FileReader("mydata.txt"))) {
            String line;
            // 파일의 끝(null)에 도달할 때까지 한 줄씩 읽어옵니다.
            while ((line = br.readLine()) != null) {
                // 읽어온 한 줄의 문자열을 콘솔에 출력합니다.
                System.out.println(line);
            }
        } catch (Exception e) {
            // 파일을 읽는 도중 오류가 발생하면 예외 내용을 출력합니다.
            e.printStackTrace();
        }
    }
}
