package week10.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 * [최종 완성 실전 문제] 로그 파일 기록, 필터링 읽기 및 삭제
 * 
 * 시나리오:
 * 당신은 서버 로그 관리 모듈을 만들고 있습니다. 
 * 아래 요구사항에 맞게 로그를 파일에 기록하고, 에러 로그만 필터링해서 읽은 뒤, 로그 파일을 삭제하는 종합 코드를 완성하세요.
 * 
 * 요구사항:
 * 1. "server_log.txt" 파일을 생성하고 아래 5개의 로그 메시지를 저장하세요.
 *    (기존 파일이 있을 수 있으므로 항상 이어쓰기(APPEND) 모드로 작성하고, 파일이 없으면 생성(CREATE)되도록 하세요.)
 *    - "2026-06-04 13:00:00 [INFO] System started\n"
 *    - "2026-06-04 13:01:00 [WARNING] Disk space low\n"
 *    - "2026-06-04 13:02:00 [ERROR] Database connection failed\n"
 *    - "2026-06-04 13:03:00 [INFO] User logged in\n"
 *    - "2026-06-04 13:04:00 [ERROR] NullPointerException occurred\n"
 *    * 힌트: Files.writeString() 사용
 * 
 * 2. 생성된 "server_log.txt" 파일을 대용량 처리에 안전한 Files.newBufferedReader()를 사용해 한 줄씩 읽으세요.
 *    - 읽어온 로그 중에서 "[ERROR]"가 포함된 라인만 화면에 출력하세요.
 *    * 힌트: try-with-resources 사용 및 String.contains() 사용
 * 
 * 3. 출력이 끝난 후 "server_log.txt" 파일을 안전하게 삭제하세요.
 *    * 힌트: Files.deleteIfExists() 사용
 */
public class Problem_Final {
    public static void main(String[] args)
    {
        Path path = Path.of("server_log.txt");

        // 1. 로그 기록 (Files.writeString + StandardOpenOption)
        System.out.println("===== server_log.txt 없으면 생성 =====");
        // TODO
        try
        {
            Files.writeString(path,"2026-06-04 13:00:00 [INFO] System started\n"+
                    "2026-06-04 13:01:00 [WARNING] Disk space low\n"+
                    "2026-06-04 13:02:00 [ERROR] Database connection failed\n" +
                    "2026-06-04 13:03:00 [INFO] User logged in\n" +
                    "2026-06-04 13:04:00 [ERROR] NullPointerException occurred\n",StandardOpenOption.CREATE,StandardOpenOption.APPEND);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        // 2. 에러 로그만 필터링하여 읽기 (Files.newBufferedReader)
        // TODO
        System.out.println("===== [ERROR] 문구가 있는 행이 있는지 확인 =====");
        try(BufferedReader br = Files.newBufferedReader(path))
        {
            String line;
            while ((line = br.readLine()) != null)
            {
                if(line.contains("[ERROR]"))
                {
                    System.out.println(line);
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        // 3. 파일 삭제 (Files.deleteIfExists)
        System.out.println("===== File 삭제 =====");
        try
        {
            if(Files.deleteIfExists(path))
            {
                System.out.println("삭제완료");
            }
            else
            {
                System.out.println("삭제못함!! [파일 존재하지 않음]");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        // TODO
    }
}
