package week10.day5;

import java.io.*;

// 객체 직렬화를 연습하는 클래스입니다.
public class Answer1 {
    public static void main(String[] args) throws Exception {
        // 직렬화할 Stud 객체를 생성합니다.
        Stud s = new Stud("홍길동", 20);
        
        // 객체를 파일에 저장하기 위해 ObjectOutputStream과 FileOutputStream을 사용합니다.
        // try-with-resources 문법을 사용하여 스트림을 자동으로 닫아줍니다.
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("stud.dat"))) {
            // writeObject 메서드를 통해 객체를 직렬화하여 파일(stud.dat)에 씁니다.
            out.writeObject(s);
        }
    }
}

// 객체 직렬화를 위해 Serializable 인터페이스를 구현합니다.
class Stud implements Serializable {
    String name;
    int age;

    // 생성자를 통해 이름과 나이를 초기화합니다.
    Stud(String n, int a) {
        name = n;
        age = a;
    }
}
