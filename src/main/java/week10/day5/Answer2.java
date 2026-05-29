package week10.day5;

import java.io.*;

// 직렬화된 객체를 파일에서 읽어와 역직렬화하는 클래스입니다.
public class Answer2 {
    public static void main(String[] args) throws Exception {
        // 객체가 저장된 파일을 가리키는 File 객체를 생성합니다.
        File f = new File("stud.dat");
        
        // 해당 파일이 존재하는지 확인합니다.
        if (f.exists()) {
            // 객체를 파일에서 읽기 위해 ObjectInputStream과 FileInputStream을 사용합니다.
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(f))) {
                // readObject 메서드로 파일에서 객체를 읽어온 후 원래 타입인 Stud로 형변환합니다.
                Stud s = (Stud) in.readObject();
                // 복원된 객체의 정보를 출력합니다.
                System.out.println("복원 완료: " + s.name);
            }
        }
    }
}
