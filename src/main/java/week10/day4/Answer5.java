package week10.day4;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * java.nio 패키지의 Files 및 Paths 클래스를 사용하여 
 * 파일 쓰기, 읽기, 삭제를 간단히 수행하는 예제입니다.
 */
public class Answer5 {
    public static void main(String[] args) throws Exception {
        // "nio_data.txt" 파일에 "NIO 테스트"라는 문자열을 씁니다.
        // 파일이 없으면 새로 생성하고, 있으면 덮어씁니다.
        Files.writeString(Paths.get("nio_data.txt"), "NIO 테스트");
        
        // 파일의 모든 라인을 읽어와 리스트 형태로 콘솔에 출력합니다.
        System.out.println(Files.readAllLines(Paths.get("nio_data.txt")));
        
        // "nio_data.txt" 파일이 존재할 경우 해당 파일을 삭제합니다.
        Files.deleteIfExists(Paths.get("nio_data.txt"));
    }
}
