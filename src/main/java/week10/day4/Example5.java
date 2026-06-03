package week10.day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * [실습 5] NIO Files 유틸리티 (Problem 5 연계)
 * 
 * 비유: "초고속 로켓 파일 입출력"
 * 전통적인 스트림(FileWriter, BufferedReader 등)의 복잡한 연결 과정 없이, 
 * 현대적인 자바 NIO의 Files 유틸리티를 활용하여 단 한 줄의 코드로 파일 전체를 쓰고(writeString),
 * 전체 줄을 단번에 List<String> 형태로 읽어오는(readAllLines) 초경량 실무 기법을 다룹니다.
 */
public class Example5 {
    public static void main(String[] args) {
        System.out.println("=== [실습 5] NIO Files 유틸리티 예제 ===");
        
        try {
            // 1. 단 한 줄로 파일 생성하고 텍스트 채워넣기
            Files.writeString(Paths.get("easy.txt"), "Java NIO\nFiles 유틸리티는 정말 편리하고 강력합니다!");
            System.out.println("-> easy.txt 파일 작성 완료");

            // 2. 단 한 줄로 전체 파일 내용을 줄별로 리스트(List)화 하여 읽어오기
            List<String> lines = Files.readAllLines(Paths.get("easy.txt"));
            
            System.out.println("--- 읽어온 텍스트 내용 ---");
            for (String line : lines) {
                System.out.println("  " + line);
            }

            // 3. 파일이 존재할 경우 깔끔하게 삭제 정리
            Files.deleteIfExists(Paths.get("easy.txt"));
            System.out.println("-> easy.txt 파일 정리 완료!");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
