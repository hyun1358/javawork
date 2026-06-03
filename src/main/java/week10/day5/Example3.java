package week10.day5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * [실습 3] transient 키워드 검증 (Problem 3 연계)
 * 
 * 비유: "민감한 비밀번호 정보에 엑스레이 차단 필터 씌우기"
 * 보안상 중요한 정보(비밀번호, 토큰 등)를 저장하지 않도록, 
 * 필드명 앞에 transient를 지정하여 직렬화 대상에서 강제 제외하고 역직렬화 시 null로 복원되는지 검증합니다.
 */
public class Example3 {
    static class Student implements Serializable {
        String name;
        int score;
        // transient 키워드를 붙여서 직렬화(디스크 저장)에서 제외시킵니다.
        transient String password; 

        Student(String name, int score, String password) {
            this.name = name;
            this.score = score;
            this.password = password;
        }

        @Override
        public String toString() {
            return "Student{name=" + name + ", score=" + score + ", password=" + password + "}";
        }
    }

    public static void main(String[] args) {
        System.out.println("=== [실습 3] transient 키워드 검증 예제 ===");
        Student s1 = new Student("홍길동", 95, "my_password_123");

        // 1. 파일에 저장 (직렬화)
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("transient_test.dat"))) {
            oos.writeObject(s1);
            System.out.println("-> 원본 객체 정보: " + s1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 2. 파일에서 복원 (역직렬화)
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("transient_test.dat"))) {
            Student loaded = (Student) ois.readObject();
            System.out.println("-> 복원된 객체 정보: " + loaded);
            
            // transient 필드는 직렬화되지 않았기 때문에 복원 시 해당 타입의 기본값(null)으로 뜹니다.
            System.out.println("-> [검증] 비밀번호 복원값: " + loaded.password + " (null이면 성공!)");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
