package week10.day5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * [학습 예제] Week 10 Day 5 — 리스트 객체의 직렬화
 */
public class Example {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Lab: ArrayList 전체를 한 번에 파일로 저장 ===");
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
    }
}
