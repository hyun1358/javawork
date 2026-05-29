package week10.day4;

import java.io.FileWriter;

/**
 * FileWriter를 사용하여 기존 파일의 끝에 내용을 추가(Append)하는 예제입니다.
 */
public class Answer3 {
    public static void main(String[] args) {
        // FileWriter의 두 번째 인자를 true로 주면 이어쓰기(append) 모드로 열립니다.
        // 기존 파일 내용이 지워지지 않고 그 뒤에 새로운 내용이 추가됩니다.
        try (FileWriter fw = new FileWriter("mydata.txt", true)) { // true가 append 모드
            // 기존 내용의 맨 끝에 "추가된 문구"와 줄바꿈을 기록합니다.
            fw.write("추가된 문구\n");
        } catch (Exception e) {
            // 예외 발생 시 에러의 발생 경로를 추적하여 출력합니다.
            e.printStackTrace();
        }
    }
}
