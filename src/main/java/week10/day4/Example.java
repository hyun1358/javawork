package week10.day4;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * [학습 예제] Week 10 Day 4 — Files 유틸리티 (Java NIO)
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Lab: Files 클래스로 초간단 파일 처리 ===");
        try {
            // 한 줄 쓰기
            Files.writeString(Paths.get("easy.txt"), "정말 쉬운 쓰기 방식\n한 줄 더 추가");

            // 모든 줄 통째로 읽기
            List<String> lines = Files.readAllLines(Paths.get("easy.txt"));
            System.out.println("읽어온 데이터:");
            for (String line : lines) System.out.println(line);

            Files.deleteIfExists(Paths.get("easy.txt")); // 정리
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
