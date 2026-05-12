package week10.day4;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;

/**
 * [예습 파일] Week 10 Day 4 — 파일 입출력 기초
 */
public class Preview {
    public static void main(String[] args) throws Exception {
        File file = new File("test.txt");

        // 1. 쓰기
        try (FileWriter fw = new FileWriter(file)) {
            fw.write("Hello Java IO\n");
            fw.write("두 번째 줄입니다.");
        }
        System.out.println("파일 생성 및 쓰기 완료");

        // 2. 읽기
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            System.out.println("--- 파일 내용 ---");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }

        // 뒷정리 삭제 (테스트용)
        if (file.exists()) file.delete();
    }
}
