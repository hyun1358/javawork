package week10.day5;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [보충 문제 5_1] UTF-8 BOM을 적용한 CSV 저장 및 읽기
 * 
 * 문제: 다음 요구사항을 만족하는 자바 코드를 작성하여 members.csv 파일에 저장하고 콘솔에 출력하세요.
 * 
 * 요구사항:
 * 1. Member 클래스를 작성하세요. (필드: String name, String role, int level)
 * 2. Member 객체들을 여러 개 담은 List를 생성하세요.
 * 3. members.csv 파일에 데이터를 저장할 때, 글로벌 표준인 UTF-8 문자셋을 적용하고 
 *    엑셀에서 더블클릭해 바로 열어도 한글이 깨지지 않도록 맨 앞에 BOM(\ufeff) 문자를 삽입하세요.
 * 4. 저장된 members.csv 파일을 다시 UTF-8 인코딩을 지정하여 읽어들인 뒤 콘솔에 각 행을 출력하세요.
 */
public class Problem5_1 {
    public static void main(String[] args)
    {
        // TODO: 아래에 코드를 완성하세요.
        try(BufferedWriter bw = Files.newBufferedWriter(Paths.get("members.csv"), StandardCharsets.UTF_8,StandardOpenOption.APPEND,StandardOpenOption.CREATE))
        {
            List<Member> members = new ArrayList<>(Arrays.asList(
                    new Member("홍길동","전사",50),
                    new Member("이길동","궁수",60),
                    new Member("삼길동","도적",70),
                    new Member("사길동","마법사",80)
            ));

            bw.write("\ufeff");
            bw.write("이름,역할,레벨\n");
            for(Member m : members)
            {
                bw.write(m.name+","+m.role+","+m.level+"\n");
            }

            System.out.println("csv직렬화 완료");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        try
        {
            List<String> lines = Files.readAllLines(Paths.get("members.csv"), StandardCharsets.UTF_8);
            //왜 String.vlaueOf를 해야하는지 알려줘

            for(String s : lines)
            {
                System.out.println(s);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    static class Member implements Serializable
    {
        private static final long serialVersionUID = 1L;
        String name;
        String role;
        int level;

        Member(String name, String role, int level)
        {
            this.name = name;
            this.role = role;
            this.level = level;
        }

    }
}
