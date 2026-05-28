package week10.day5;

import java.io.*;

/**
 * [예습 파일] Week 10 Day 5 — 객체 직렬화 (Serialization)
 * 
 * [핵심 개념: 객체를 파일로 내보내는 바이트 변환]
 * 1. 객체 직렬화 (Serialization):
 *    - 힙(Heap) 메모리에 임시 상주해 복잡하게 얽혀 있는 자바 객체 인스턴스 정보(필드 값들)를 컴퓨터 파일로 저장하거나 네트워크로 전송할 수 있도록 납작한 바이트 흐름(byte array)으로 변환해 내는 작업입니다.
 * 
 * 2. 객체 역직렬화 (Deserialization):
 *    - 파일에 저장되어 있던 납작한 바이트 데이터를 다시 읽어들여, 힙 메모리에 생생한 자바 객체 인스턴스로 원복 구축해 내는 마법 같은 역변환 작업입니다.
 * 
 * 3. Serializable 마커 인터페이스:
 *    - 직렬화가 가능한 안전한 보안 클래스임을 보증하기 위해 JVM에 알리는 빈 표식(Marker) 인터페이스인 `java.io.Serializable`을 클래스 옆에 반드시 선언해주어야 에러 없이 수행됩니다.
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
