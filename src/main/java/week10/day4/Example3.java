package week10.day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * [실습 3] Append(이어쓰기) 모드 (Problem 3 연계)
 * 
 * 비유: "방명록에 한 줄 덧붙이기"
 * FileWriter 생성자의 두 번째 매개변수로 true를 넘겨주면 '이어쓰기(Append)' 모드가 되어, 
 * 기존 파일에 채워져 있던 내용을 지우지 않고 맨 뒷부분에 추가로 글자를 이어 붙여 줍니다.
 */
public class Example3 {
    public static void main(String[] args) {
        System.out.println("=== [실습 3] FileWriter Append 이어쓰기 예제 ===");
        
        // 두 번째 인자로 true를 전송 -> 파일 끝에 이어쓰기 실행
        try (FileWriter fw = new FileWriter("mydata.txt", true)) {
            fw.write("\n추가된 문구");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 이어쓰기 결과 검증을 위한 전체 출력
        try (BufferedReader br = new BufferedReader(new FileReader("mydata.txt"))) {
            String line;
            System.out.println("--- 이어쓰기 후 전체 파일 내용 ---");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
