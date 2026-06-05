package week10.day5;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 * [실습 2] 역직렬화 — 파일에서 객체 복원 (Problem 2 연계)
 * 
 * 비유: "냉동 보존된 바이트 파일(.dat)을 해동하여 실물 자바 객체로 부활시키기"
 * ObjectInputStream의 readObject() 메서드를 활용하여, 
 * 디스크에 저장된 바이트 데이터 파일로부터 원본 자바 객체의 필드값들을 그대로 해동(역직렬화)합니다.
 */
public class Example2 {
    public static void main(String[] args) {
        System.out.println("=== [실습 2] 객체 역직렬화 (객체 복원) 예제 ===");
        
        // student.dat 파일을 읽어와 객체로 복원합니다. (먼저 실습 1을 실행해야 파일이 존재합니다!)
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.dat"))) {
            // readObject() 호출 시 다운캐스팅이 필요합니다.
            Example1.Student loaded = (Example1.Student) ois.readObject();
            System.out.println("-> 복원 완료된 객체: " + loaded);
        } catch (Exception e) {
            System.err.println("오류: 복원할 파일이 없습니다. 먼저 실습 1을 실행해 주세요!");
        }
    }
}
