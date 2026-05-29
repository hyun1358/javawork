package week10.day5;

import java.io.*;
import java.util.ArrayList;

// 컬렉션을 사용하여 여러 객체를 한 번에 직렬화하는 클래스입니다.
public class Answer4 {
    public static void main(String[] args) throws Exception {
        // 여러 Stud 객체를 담기 위해 ArrayList를 생성합니다.
        ArrayList<Stud> list = new ArrayList<>();
        list.add(new Stud("Kim", 10));
        list.add(new Stud("Lee", 20));
        
        // ArrayList 전체를 직렬화하여 파일에 저장하기 위해 스트림을 엽니다.
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("studs.dat"))) {
            // ArrayList 객체 하나를 쓰면 내부의 모든 요소가 함께 직렬화됩니다.
            out.writeObject(list);
            System.out.println("리스트 통째로 직렬화 완료");
        }
    }
}
