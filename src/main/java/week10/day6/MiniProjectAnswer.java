package week10.day6;

import java.io.*;
import java.util.*;

/**
 * [모범 정답] Week 10 Day 6 — 종합 학생 성적 관리 시스템
 *
 * 활용 개념:
 *   Day1 - ArrayList, Collections.sort(), Comparable
 *   Day2 - HashSet (학번 중복 방지), equals/hashCode 오버라이드
 *   Day3 - HashMap (과목별 점수), entrySet 순회
 *   Day4 - 커스텀 예외(DuplicateStudentException, InvalidScoreException), try-catch-finally
 *   Day5 - ObjectOutputStream/ObjectInputStream (직렬화/역직렬화)
 */
public class MiniProjectAnswer {

    private static final String FILE_NAME = "students.dat";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ── Day1: ArrayList로 학생 관리 ──
        ArrayList<StudentData> students = new ArrayList<>();

        // ── Day2: HashSet으로 학번 중복 체크 ──
        HashSet<String> idSet = new HashSet<>();

        // ── Day5: 프로그램 시작 시 파일에서 데이터 로드 (역직렬화) ──
        File file = new File(FILE_NAME);
        if (file.exists()) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
                students = (ArrayList<StudentData>) in.readObject();
                // 로드된 학생들의 학번을 HashSet에 등록
                for (StudentData s : students) {
                    idSet.add(s.getStudentId());
                }
                System.out.println("기존 데이터를 불러왔습니다. (학생 " + students.size() + "명)");
            } catch (FileNotFoundException e) {
                System.out.println("파일을 찾을 수 없습니다. 새로 시작합니다.");
            } catch (IOException e) {
                System.out.println("파일 읽기 오류: " + e.getMessage());
            } catch (ClassNotFoundException e) {
                System.out.println("데이터 형식 오류: " + e.getMessage());
            }
        }

        boolean running = true;
        while (running) {
            System.out.println("\n=== 학생 성적 관리 시스템 ===");
            System.out.println("1. 학생 등록");
            System.out.println("2. 성적 입력");
            System.out.println("3. 전체 학생 조회 (성적순 정렬)");
            System.out.println("4. 학생 검색 (학번)");
            System.out.println("5. 과목별 평균 조회");
            System.out.println("6. 학생 삭제");
            System.out.println("7. 저장 후 종료");
            System.out.print("선택> ");

            // ── Day4: 잘못된 메뉴 입력 예외 처리 ──
            int menu;
            try {
                menu = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("[오류] 숫자를 입력해 주세요.");
                continue;
            }

            switch (menu) {

                // ────────────────────────────
                // 1. 학생 등록 (Day1 + Day2 + Day4)
                // ────────────────────────────
                case 1:
                    System.out.print("학번: ");
                    String id = sc.nextLine().trim();
                    System.out.print("이름: ");
                    String name = sc.nextLine().trim();

                    try {
                        // Day2 + Day4: 중복 체크 → 커스텀 예외
                        if (idSet.contains(id)) {
                            throw new DuplicateStudentException("학번 [" + id + "]는 이미 등록되어 있습니다.");
                        }

                        // Day1: ArrayList에 추가
                        students.add(new StudentData(id, name));
                        // Day2: HashSet에 학번 추가
                        idSet.add(id);
                        System.out.println("학생 [" + name + "] 등록 완료!");

                    } catch (DuplicateStudentException e) {
                        System.out.println("[오류] " + e.getMessage());
                    }
                    break;

                // ────────────────────────────
                // 2. 성적 입력 (Day3 + Day4)
                // ────────────────────────────
                case 2:
                    System.out.print("학번: ");
                    String scoreId = sc.nextLine().trim();
                    StudentData target = findStudent(students, scoreId);

                    if (target == null) {
                        System.out.println("[안내] 해당 학번의 학생이 없습니다.");
                        break;
                    }

                    System.out.print("과목명: ");
                    String subject = sc.nextLine().trim();
                    System.out.print("점수 (0~100): ");

                    try {
                        int score = Integer.parseInt(sc.nextLine().trim());

                        // Day4: 커스텀 예외로 점수 유효성 검사
                        if (score < 0 || score > 100) {
                            throw new InvalidScoreException("점수는 0~100 범위여야 합니다. (입력값: " + score + ")");
                        }

                        // Day3: HashMap에 과목-점수 저장
                        target.getScores().put(subject, score);
                        System.out.println(target.getName() + "의 " + subject + " 점수 [" + score + "] 입력 완료!");

                    } catch (NumberFormatException e) {
                        System.out.println("[오류] 점수는 숫자로 입력해 주세요.");
                    } catch (InvalidScoreException e) {
                        System.out.println("[오류] " + e.getMessage());
                    }
                    break;

                // ────────────────────────────
                // 3. 전체 학생 조회 — 성적순 정렬 (Day1)
                // ────────────────────────────
                case 3:
                    if (students.isEmpty()) {
                        System.out.println("[안내] 등록된 학생이 없습니다.");
                        break;
                    }

                    // Day1: Collections.sort + Comparable
                    Collections.sort(students);

                    System.out.println("\n──────────────────────────────────────────────────");
                    System.out.printf("%-8s %-8s %-20s %s\n", "학번", "이름", "과목별 점수", "평균");
                    System.out.println("──────────────────────────────────────────────────");

                    for (StudentData s : students) {
                        // Day3: Map의 entrySet 순회로 과목별 점수 표시
                        StringBuilder scoreStr = new StringBuilder();
                        for (Map.Entry<String, Integer> entry : s.getScores().entrySet()) {
                            if (scoreStr.length() > 0) scoreStr.append(", ");
                            scoreStr.append(entry.getKey()).append(":").append(entry.getValue());
                        }
                        if (scoreStr.length() == 0) scoreStr.append("(미입력)");

                        System.out.printf("%-8s %-8s %-20s %.1f\n",
                                s.getStudentId(), s.getName(), scoreStr.toString(), s.getAverage());
                    }
                    System.out.println("──────────────────────────────────────────────────");
                    break;

                // ────────────────────────────
                // 4. 학생 검색 (Day1: ArrayList 탐색)
                // ────────────────────────────
                case 4:
                    System.out.print("검색할 학번: ");
                    String searchId = sc.nextLine().trim();
                    StudentData found = findStudent(students, searchId);

                    if (found == null) {
                        System.out.println("[안내] 해당 학번의 학생이 없습니다.");
                    } else {
                        System.out.println("\n── 학생 상세 정보 ──");
                        System.out.println("학번: " + found.getStudentId());
                        System.out.println("이름: " + found.getName());

                        if (found.getScores().isEmpty()) {
                            System.out.println("성적: (입력된 과목 없음)");
                        } else {
                            System.out.println("성적:");
                            // Day3: Map 순회
                            for (Map.Entry<String, Integer> entry : found.getScores().entrySet()) {
                                System.out.println("  - " + entry.getKey() + ": " + entry.getValue() + "점");
                            }
                        }
                        System.out.printf("평균: %.1f점\n", found.getAverage());
                    }
                    break;

                // ────────────────────────────
                // 5. 과목별 평균 조회 (Day3: Map 집계)
                // ────────────────────────────
                case 5:
                    if (students.isEmpty()) {
                        System.out.println("[안내] 등록된 학생이 없습니다.");
                        break;
                    }

                    // Day3: HashMap으로 과목별 총점/인원 집계
                    HashMap<String, Integer> totalMap = new HashMap<>();
                    HashMap<String, Integer> countMap = new HashMap<>();

                    for (StudentData s : students) {
                        for (Map.Entry<String, Integer> entry : s.getScores().entrySet()) {
                            String subj = entry.getKey();
                            int val = entry.getValue();

                            totalMap.put(subj, totalMap.getOrDefault(subj, 0) + val);
                            countMap.put(subj, countMap.getOrDefault(subj, 0) + 1);
                        }
                    }

                    if (totalMap.isEmpty()) {
                        System.out.println("[안내] 입력된 성적이 없습니다.");
                    } else {
                        System.out.println("\n── 과목별 평균 ──");
                        for (Map.Entry<String, Integer> entry : totalMap.entrySet()) {
                            String subj = entry.getKey();
                            double avg = (double) entry.getValue() / countMap.get(subj);
                            System.out.printf("  %s: %.1f점 (%d명)\n", subj, avg, countMap.get(subj));
                        }
                    }
                    break;

                // ────────────────────────────
                // 6. 학생 삭제 (Day1 + Day2)
                // ────────────────────────────
                case 6:
                    System.out.print("삭제할 학번: ");
                    String delId = sc.nextLine().trim();
                    StudentData delTarget = findStudent(students, delId);

                    if (delTarget == null) {
                        System.out.println("[안내] 해당 학번의 학생이 없습니다.");
                    } else {
                        // Day1: ArrayList에서 제거
                        students.remove(delTarget);
                        // Day2: HashSet에서 학번 제거
                        idSet.remove(delId);
                        System.out.println("학생 [" + delTarget.getName() + "] 삭제 완료!");
                    }
                    break;

                // ────────────────────────────
                // 7. 저장 후 종료 (Day4 + Day5)
                // ────────────────────────────
                case 7:
                    // Day5: ObjectOutputStream으로 직렬화 저장
                    // Day4: try-catch-finally로 안전한 스트림 처리
                    ObjectOutputStream oos = null;
                    try {
                        oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
                        oos.writeObject(students);
                        System.out.println("데이터를 안전하게 저장했습니다. (" + students.size() + "명)");
                    } catch (IOException e) {
                        System.out.println("[오류] 저장 실패: " + e.getMessage());
                    } finally {
                        // Day4: finally로 스트림 반드시 닫기
                        if (oos != null) {
                            try {
                                oos.close();
                            } catch (IOException e) {
                                System.out.println("[오류] 스트림 종료 실패");
                            }
                        }
                    }
                    running = false;
                    System.out.println("프로그램을 종료합니다.");
                    break;

                default:
                    System.out.println("[오류] 1~7 사이의 번호를 입력해 주세요.");
                    break;
            }
        }
        sc.close();
    }

    // 학번으로 학생 검색 (ArrayList 순회)
    private static StudentData findStudent(ArrayList<StudentData> students, String id) {
        for (StudentData s : students) {
            if (s.getStudentId().equals(id)) {
                return s;
            }
        }
        return null;
    }
}

// ──────────────────────────────────────────────────────────
// Student 클래스 (Day1 + Day2 + Day3 + Day5)
// ──────────────────────────────────────────────────────────
class StudentData implements Serializable, Comparable<StudentData> {
    // Day5: 직렬화 버전 UID
    private static final long serialVersionUID = 1L;

    private String studentId;    // 학번
    private String name;         // 이름
    // Day3: HashMap으로 과목별 점수 관리
    private HashMap<String, Integer> scores;

    public StudentData(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.scores = new HashMap<>();
    }

    public String getStudentId() { return studentId; }
    public String getName() { return name; }
    public HashMap<String, Integer> getScores() { return scores; }

    // 평균 점수 계산
    public double getAverage() {
        if (scores.isEmpty()) return 0.0;

        int total = 0;
        for (int score : scores.values()) {
            total += score;
        }
        return (double) total / scores.size();
    }

    // Day2: equals / hashCode — studentId 기준
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentData that = (StudentData) o;
        return studentId.equals(that.studentId);
    }

    @Override
    public int hashCode() {
        return studentId.hashCode();
    }

    // Day1: Comparable — 평균 점수 내림차순 정렬
    @Override
    public int compareTo(StudentData other) {
        return Double.compare(other.getAverage(), this.getAverage());
    }
}

// ──────────────────────────────────────────────────────────
// 커스텀 예외 클래스들 (Day4)
// ──────────────────────────────────────────────────────────

// 학번 중복 시 발생
class DuplicateStudentException extends Exception {
    public DuplicateStudentException(String message) {
        super(message);
    }
}

// 점수 범위(0~100) 밖일 때 발생
class InvalidScoreException extends Exception {
    public InvalidScoreException(String message) {
        super(message);
    }
}
