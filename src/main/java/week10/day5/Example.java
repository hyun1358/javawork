package week10.day5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * [학습 예제] Week 10 Day 5 — 리스트 객체의 직렬화 및 File/FileWriter 유틸리티
 */
public class Example {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Lab 1: ArrayList 전체를 한 번에 파일로 저장 ===");
        ArrayList<String> list = new ArrayList<>();
        list.add("자바");
        list.add("파이썬");
        list.add("C++");

        // 저장
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("list.dat"))) {
            out.writeObject(list);
        }

        // 읽기
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("list.dat"))) {
            List<String> loaded = (List<String>) in.readObject();
            System.out.println("불러온 리스트: " + loaded);
        }

        System.out.println("\n=== Lab 2: File 클래스와 FileWriter 사용법 ===");
        runFileAndWriter();
    }

    public static void runFileAndWriter() throws Exception {
        File file = new File("output.csv");
        
        // 1. File 클래스로 존재 여부 체크
        if (file.exists()) {
            System.out.println("기존 파일이 존재하여 덮어씁니다: " + file.getName());
        }

        // 2. FileWriter를 활용한 CSV 데이터 쓰기 (try-with-resources)
        try (FileWriter writer = new FileWriter(file)) {
            writer.write("Name,Language\n");
            writer.write("Kim,Java\n");
            writer.write("Lee,Python\n");
        }
        System.out.println("파일 쓰기 완료: " + file.getAbsolutePath());
    }
}
