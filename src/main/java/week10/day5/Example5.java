package week10.day5;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * [실습 5] 수동 CSV 저장 (직렬화 대신 텍스트 방식) (Problem 5 연계)
 * 
 * 비유: "엑셀이나 파이썬도 볼 수 있는 글로벌 규격 텍스트 장부 만들기"
 * 자바 전용 이진(Binary) 직렬화와 다르게, 콤마(,)와 엔터(\n)를 활용해 수동으로 CSV 파일 포맷을 만들어
 * 타 언어(Python 등) 및 오피스 엑셀과 통신하기 유리한 글로벌 텍스트 형태로 객체를 직렬화하는 법을 배웁니다.
 */
public class Example5 {
    static class Student {
        String name;
        int score;

        Student(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== [실습 5] 수동 CSV 데이터 직렬화 예제 ===");
        
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("김철수", 88));
        students.add(new Student("이영희", 92));
        students.add(new Student("박민준", 76));

        // CSV 파일 저장 시작
        try (FileWriter fw = new FileWriter("students.csv")) {
            fw.write("이름,점수\n"); // 헤더 타이틀 작성
            for (Student s : students) {
                // 각 객체를 콤마로 연결한 문자열 한 줄로 번역해서 디스크에 씁니다.
                fw.write(s.name + "," + s.score + "\n");
            }
            System.out.println("-> students.csv 파일 저장 성공!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // CSV 저장 결과 읽어와서 출력 검증
        try {
            List<String> csvLines = Files.readAllLines(Paths.get("students.csv"));
            System.out.println("--- 저장된 CSV 파일 텍스트 전문 ---");
            for (String line : csvLines) {
                System.out.println("  " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
