package week10.day4;

import java.io.File;

/**
 * File 클래스를 이용하여 특정 파일을 삭제하는 예제입니다.
 */
public class Answer4 {
    public static void main(String[] args) {
        // "mydata.txt" 경로를 가리키는 File 객체를 생성합니다.
        File f = new File("mydata.txt");
        // 해당 경로에 파일이 실제로 존재하는지 확인합니다.
        if (f.exists()) {
            // 파일이 존재한다면 파일을 삭제합니다.
            f.delete();
            // 삭제가 성공적으로 수행되었음을 콘솔에 알립니다.
            System.out.println("삭제 완료");
        }
    }
}
