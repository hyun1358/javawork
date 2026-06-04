package week10.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 * [최종 완성 실전 문제 정답]
 */
public class Answer_Final {
    public static void main(String[] args) {
        Path path = Path.of("server_log.txt");

        // 1. 로그 기록 (Files.writeString + StandardOpenOption)
        try {
            String logData = "2026-06-04 13:00:00 [INFO] System started\n"
                           + "2026-06-04 13:01:00 [WARNING] Disk space low\n"
                           + "2026-06-04 13:02:00 [ERROR] Database connection failed\n"
                           + "2026-06-04 13:03:00 [INFO] User logged in\n"
                           + "2026-06-04 13:04:00 [ERROR] NullPointerException occurred\n";
            
            Files.writeString(path, logData, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            System.out.println("=== 로그 기록 완료 ===");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 2. 에러 로그만 필터링하여 읽기 (Files.newBufferedReader)
        System.out.println("=== 에러 로그 필터링 결과 ===");
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("[ERROR]")) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 3. 파일 삭제 (Files.deleteIfExists)
        try {
            boolean deleted = Files.deleteIfExists(path);
            System.out.println("=== 로그 파일 삭제 여부: " + deleted + " ===");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
