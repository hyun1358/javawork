package week10.day5;

import java.io.*;

/**
 * [예습 파일] Week 10 Day 5 — 객체 직렬화 (Serialization)
 */
public class Preview {
    public static void main(String[] args) throws Exception {
        // 객체를 통째로 바이트로 변환하여 저장
        User u = new User("Alice", "1234");

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.dat"))) {
            oos.writeObject(u);
            System.out.println("직렬화 저장 완료");
        }

        // 파일에서 객체로 복원
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))) {
            User loaded = (User) ois.readObject();
            System.out.println("복원된 이름: " + loaded.name);
            System.out.println("복원된 비번(transient라 null): " + loaded.pw);
        }
    }
}

// 직렬화를 허용한다는 마커 인터페이스 구현
class User implements Serializable {
    String name;
    transient String pw; // 직렬화 대상에서 제외 (보안)

    User(String n, String p) {
        name = n;
        pw = p;
    }
}
