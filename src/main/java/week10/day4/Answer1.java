package week10.day4;

import java.io.FileWriter;

/**
 * FileWriter를 사용하여 파일에 문자열을 쓰는 예제입니다.
 */
public class Answer1 {
    public static void main(String[] args) {
        // try-with-resources 구문을 사용하여 FileWriter 객체를 생성합니다.
        // 이 구문을 사용하면 파일 쓰기 작업이 끝난 후 자동으로 파일을 닫아줍니다(close 호출).
        try (FileWriter fw = new FileWriter("mydata.txt")) {
            // 지정된 파일(mydata.txt)에 "안녕하세요!" 문자열과 줄바꿈 문자를 씁니다.
            fw.write("안녕하세요!\n");
        } catch (Exception e) {
            // 파일 쓰기 중 예외(오류)가 발생하면 예외의 상세 내용을 출력합니다.
            e.printStackTrace();
        }
    }
}
