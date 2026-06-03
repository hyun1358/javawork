package week10.day5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * [실습 4] ArrayList 전체를 한 번에 직렬화 (Problem 4 연계)
 * 
 * 비유: "화물 컨테이너(ArrayList) 통째로 직렬화 배에 실어 보내기"
 * 하나씩 따로 저장하지 않고, 컬렉션 자체를 하나의 객체로 취급하여 writeObject(list) 한 번으로
 * 리스트 안의 모든Serializable 객체를 통째로 파일에 저장하고 읽어오는 초간단 벌크 직렬화입니다.
 */
public class Example4 {
    static class Student implements Serializable {
        String name;
        int score;

        Student(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== [실습 4] ArrayList 객체 묶음 직렬화 예제 ===");
        
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("김철수", 88));
        students.add(new Student("이영희", 92));
        students.add(new Student("박민준", 76));

        // 1. ArrayList 통째로 직렬화하여 저장
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("students.dat"))) {
            oos.writeObject(students);
            System.out.println("-> " + students.size() + "명의 학생 리스트 통째로 직렬화 완료!");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 2. 파일에서 리스트 복원
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("students.dat"))) {
            @SuppressWarnings("unchecked")
            ArrayList<Student> loaded = (ArrayList<Student>) ois.readObject();
            System.out.println("--- 복원된 학생 목록 ---");
            for (Student s : loaded) {
                System.out.println("  이름: " + s.name + " / 점수: " + s.score);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
