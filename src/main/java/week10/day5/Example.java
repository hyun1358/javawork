package week10.day5;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * [학습 예제] Week 10 Day 5 — 객체 직렬화 & CSV 저장 완전 정복
 *
 * ★ 이 파일은 오늘 풀어야 할 연습 문제 5개의 핵심 기술을 모두 담고 있습니다.
 *
 * [문제별 학습 목표]
 * - 문제 1: Serializable 구현 + ObjectOutputStream 으로 객체 파일 저장
 * - 문제 2: ObjectInputStream 으로 파일에서 객체 복원(역직렬화)
 * - 문제 3: transient 키워드 — 직렬화 제외 필드 확인
 * - 문제 4: ArrayList<Student> 전체를 한 번에 직렬화하여 저장
 * - 문제 5: 객체 데이터를 "이름,점수" CSV 형태 텍스트로 수동 저장
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 1 & 2] 직렬화 / 역직렬화
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - Serializable: 직렬화 허용 표시 마커 인터페이스 (메서드 없음)
 *  - ObjectOutputStream.writeObject(obj): 객체 → 바이트로 변환하여 파일에 저장
 *  - ObjectInputStream.readObject(): 바이트 파일 → 객체로 복원 (역직렬화)
 *  - 직렬화된 파일은 .dat 또는 .ser 확장자를 주로 사용
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 3] transient 키워드
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - 필드 앞에 transient를 붙이면 직렬화 대상에서 제외됨
 *  - 역직렬화 시 해당 필드는 기본값(null, 0)으로 복원됨
 *  - 사용 사례: 비밀번호, 보안 토큰 등 민감한 정보 보호
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 4] 컬렉션 통째로 직렬화
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - ArrayList 자체가 Serializable을 구현하고 있어
 *    writeObject(list) 한 번으로 리스트 전체를 저장 가능
 *  - 단, 리스트 안의 객체(Student 등)도 Serializable이어야 함
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 5] 수동 CSV 저장 (직렬화 아님)
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - 직렬화: 바이너리(.dat) → 사람이 읽기 어려움, Java 전용
 *  - CSV: 텍스트 기반 → 엑셀/다른 시스템과 데이터 교환에 유리
 *  - 방법: 객체 필드를 "이름,점수\n" 형태 문자열로 변환 후 FileWriter로 저장
 */
public class Example {

    // ─────────────────────────────────────────────
    // Student 클래스 (문제 1~4에서 사용)
    // Serializable 구현 → 직렬화 가능
    // ─────────────────────────────────────────────
    static class Student implements Serializable {
        String name;
        int score;
        transient String password; // transient → 직렬화 제외 (→ 문제 3 핵심)

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

    public static void main(String[] args) throws Exception {

        // ─────────────────────────────────────────────
        // Lab 1: 객체 직렬화 — 파일에 저장 (→ 문제 1 참고)
        // ─────────────────────────────────────────────
        System.out.println("=== Lab 1: 객체 직렬화 (저장) ===");
        Student s1 = new Student("홍길동", 95, "secret123");

        // ObjectOutputStream: 객체를 바이트로 변환하여 파일에 씀
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.dat"))) {
            oos.writeObject(s1);
            System.out.println("직렬화 저장 완료: " + s1);
        }

        // ─────────────────────────────────────────────
        // Lab 2: 역직렬화 — 파일에서 객체 복원 (→ 문제 2 참고)
        // ─────────────────────────────────────────────
        System.out.println("\n=== Lab 2: 역직렬화 (복원) ===");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.dat"))) {
            Student loaded = (Student) ois.readObject(); // 바이트 → 객체 복원
            System.out.println("복원된 객체: " + loaded);
            // ↓ transient 필드는 null로 복원됨 (→ 문제 3 예고)
            System.out.println("  password(transient): " + loaded.password);
        }

        // ─────────────────────────────────────────────
        // Lab 3: transient 키워드 확인 (→ 문제 3 참고)
        // ─────────────────────────────────────────────
        System.out.println("\n=== Lab 3: transient 필드 확인 ===");
        System.out.println("위 Lab 2 결과에서 password가 null이면 transient 적용 성공!");
        System.out.println("이유: transient는 직렬화 대상에서 제외하는 키워드");
        System.out.println("     → 보안상 민감한 정보(비밀번호 등)를 파일에 저장하지 않을 때 사용");

        // ─────────────────────────────────────────────
        // Lab 4: ArrayList 전체를 한 번에 직렬화 (→ 문제 4 참고)
        // ─────────────────────────────────────────────
        System.out.println("\n=== Lab 4: ArrayList<Student> 직렬화 ===");
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("김철수", 88, "pw1"));
        students.add(new Student("이영희", 92, "pw2"));
        students.add(new Student("박민준", 76, "pw3"));

        // ArrayList 자체도 Serializable이므로 writeObject 한 번으로 전체 저장
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("students.dat"))) {
            oos.writeObject(students);
            System.out.println("ArrayList 직렬화 완료: " + students.size() + "명 저장");
        }

        // 복원
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("students.dat"))) {
            @SuppressWarnings("unchecked")
            ArrayList<Student> loaded = (ArrayList<Student>) ois.readObject();
            System.out.println("복원된 학생 목록:");
            for (Student s : loaded) {
                System.out.println("  " + s.name + " / 점수: " + s.score + " / password: " + s.password);
            }
        }

        // ─────────────────────────────────────────────
        // Lab 5: 수동 CSV 저장 (직렬화 대신 텍스트 방식) (→ 문제 5 참고)
        // ─────────────────────────────────────────────
        System.out.println("\n=== Lab 5: 수동 CSV 저장 ===");
        // 직렬화는 Java 전용 바이너리 → 다른 프로그램과 호환 불가
        // CSV(텍스트)는 엑셀, Python, DB 등 어디서나 읽을 수 있음

        try (FileWriter fw = new FileWriter("students.csv")) {
            fw.write("이름,점수\n"); // 헤더 행
            for (Student s : students) {
                // 객체 데이터를 "이름,점수" 형태 문자열로 변환하여 저장
                fw.write(s.name + "," + s.score + "\n");
            }
        }

        System.out.println("students.csv 저장 완료");
        // CSV 내용 확인
        List<String> csvLines = Files.readAllLines(Paths.get("students.csv"));
        System.out.println("--- CSV 내용 ---");
        csvLines.forEach(System.out::println);

        // 뒷정리
        new File("student.dat").delete();
        new File("students.dat").delete();
        new File("students.csv").delete();
    }
}
