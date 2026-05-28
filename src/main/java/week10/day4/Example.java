package week10.day4;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 * [학습 예제] Week 10 Day 4 — 파일 입출력 (IO) 완전 정복
 *
 * ★ 이 파일은 오늘 풀어야 할 연습 문제 5개의 핵심 기술을 모두 담고 있습니다.
 *
 * [문제별 학습 목표]
 * - 문제 1: FileWriter + BufferedWriter 로 파일 생성 및 쓰기
 * - 문제 2: FileReader + BufferedReader.readLine() 으로 한 줄씩 읽기
 * - 문제 3: FileWriter(file, true) — append 모드로 이어쓰기
 * - 문제 4: File.exists() / File.delete() 로 파일 존재 확인 및 삭제
 * - 문제 5: Files.writeString() / Files.readAllLines() (NIO 현대 방식)
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 1] FileWriter 로 파일 생성 및 쓰기
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - new FileWriter("파일명"): 파일이 없으면 생성, 있으면 덮어씀
 *  - BufferedWriter(fw): 버퍼를 이용해 성능 향상 (대용량 텍스트에 유리)
 *  - try-with-resources: 블록이 끝나면 자동으로 close() 호출 → 파일 핸들 반환
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 2] BufferedReader.readLine() 으로 한 줄씩 읽기
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - new FileReader("파일명"): 문자 단위로 파일을 읽는 스트림
 *  - BufferedReader: 줄 단위 읽기(readLine()) 기능 제공
 *  - readLine(): 한 줄 반환, 파일 끝에 도달하면 null 반환
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 3] Append(이어쓰기) 모드
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - new FileWriter("파일명", true): 두 번째 인자 true = 이어쓰기 모드
 *    (false 또는 생략 시 기존 내용을 지우고 덮어씀)
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 4] File 클래스 — 파일 존재 확인 / 삭제
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - new File("파일명"): 파일 경로를 나타내는 객체 (실제 IO는 하지 않음)
 *  - file.exists(): 파일이 실제로 존재하면 true
 *  - file.delete(): 파일 삭제 (성공 시 true 반환)
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 5] NIO Files 유틸 (현대적 방법)
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - Files.writeString(path, text): 한 줄 코드로 파일 전체 쓰기
 *  - Files.readAllLines(path): 전체 줄을 List<String>으로 읽기
 *  - Files.deleteIfExists(path): 존재하면 삭제, 없어도 예외 없음
 */
public class Example {
    public static void main(String[] args) throws Exception {

        // ─────────────────────────────────────────────
        // Lab 1: FileWriter 로 파일 생성 및 쓰기 (→ 문제 1 참고)
        // ─────────────────────────────────────────────
        System.out.println("=== Lab 1: FileWriter 로 파일 쓰기 ===");
        // try-with-resources: 블록 끝나면 자동 close()
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("mydata.txt"))) {
            bw.write("안녕하세요!");
            bw.newLine(); // 줄바꿈
            bw.write("두 번째 줄입니다.");
        }
        System.out.println("mydata.txt 생성 완료");

        // ─────────────────────────────────────────────
        // Lab 2: BufferedReader.readLine() 으로 한 줄씩 읽기 (→ 문제 2 참고)
        // ─────────────────────────────────────────────
        System.out.println("\n=== Lab 2: BufferedReader.readLine() 으로 읽기 ===");
        try (BufferedReader br = new BufferedReader(new FileReader("mydata.txt"))) {
            String line;
            // readLine()은 파일 끝에서 null을 반환
            while ((line = br.readLine()) != null) {
                System.out.println("읽음: " + line);
            }
        }

        // ─────────────────────────────────────────────
        // Lab 3: Append(이어쓰기) 모드 (→ 문제 3 참고)
        // ─────────────────────────────────────────────
        System.out.println("\n=== Lab 3: Append 이어쓰기 ===");
        // FileWriter 두 번째 인자 true → 기존 내용 유지 + 뒤에 추가
        try (FileWriter fw = new FileWriter("mydata.txt", true)) {
            fw.write("\n추가된 문구");
        }

        // 이어쓰기 확인: 전체 내용 출력
        try (BufferedReader br = new BufferedReader(new FileReader("mydata.txt"))) {
            String line;
            System.out.println("--- 이어쓰기 후 전체 내용 ---");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }

        // ─────────────────────────────────────────────
        // Lab 4: File.exists() / File.delete() (→ 문제 4 참고)
        // ─────────────────────────────────────────────
        System.out.println("\n=== Lab 4: File.exists() / File.delete() ===");
        File file = new File("mydata.txt");

        if (file.exists()) {
            System.out.println(file.getName() + " 파일이 존재합니다. 삭제합니다.");
            boolean deleted = file.delete();
            System.out.println("삭제 성공: " + deleted);
        } else {
            System.out.println("파일이 존재하지 않습니다.");
        }

        // ─────────────────────────────────────────────
        // Lab 5: NIO Files 유틸 (→ 문제 5 참고)
        // ─────────────────────────────────────────────
        System.out.println("\n=== Lab 5: Files.writeString() / Files.readAllLines() ===");
        // 한 줄 코드로 파일 쓰기 (WRITE: 덮어씀, APPEND: 이어씀)
        Files.writeString(Paths.get("easy.txt"), "Java NIO\nFiles 유틸 편리함!");

        // 전체 줄을 List<String>으로 읽기
        List<String> lines = Files.readAllLines(Paths.get("easy.txt"));
        System.out.println("읽어온 내용:");
        for (String l : lines) System.out.println("  " + l);

        // 파일 정리
        Files.deleteIfExists(Paths.get("easy.txt"));
        System.out.println("easy.txt 삭제 완료");
    }
}
