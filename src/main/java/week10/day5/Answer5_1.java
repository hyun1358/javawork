package week10.day5;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [보충 문제 5_1 정답] UTF-8 BOM을 적용한 CSV 저장 및 읽기 모범 정답
 */
public class Answer5_1 {
    public static void main(String[] args) {
        List<Member> members = new ArrayList<>(Arrays.asList(
            new Member("이순신", "장군", 10),
            new Member("세종대왕", "왕", 10),
            new Member("홍길동", "의적", 5)
        ));

        // 1. UTF-8 인코딩으로 파일 쓰기 준비
        try (FileWriter fw = new FileWriter("members.csv", StandardCharsets.UTF_8)) {
            // 2. 엑셀 호환용 UTF-8 BOM 문자 작성
            fw.write("\ufeff");
            fw.write("이름,역할,레벨\n");
            
            for (Member m : members) {
                fw.write(m.name + "," + m.role + "," + m.level + "\n");
            }
            System.out.println("-> members.csv 저장 성공!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 3. UTF-8 인코딩을 명시하여 파일 읽기
        try {
            List<String> lines = Files.readAllLines(Path.of("members.csv"), StandardCharsets.UTF_8);
            System.out.println("--- 저장된 members.csv 파일 내용 ---");
            for (String line : lines) {
                System.out.println("  " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Member {
    String name;
    String role;
    int level;

    Member(String name, String role, int level) {
        this.name = name;
        this.role = role;
        this.level = level;
    }
}
