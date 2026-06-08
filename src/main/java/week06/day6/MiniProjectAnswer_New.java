package week06.day6;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * [종합 미니 프로젝트 정답 - 신규] Week 06 Day 6
 * 「 개인정보 마스킹 기능이 포함된 스마트 일기장 및 백업 시스템 」
 */
public class MiniProjectAnswer_New {
    private static final String TEXT_FILE = "diary_raw.txt";
    private static final String BACKUP_FILE = "diary_backup.dat";
    private static List<DiaryEntry> diaryList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Day 4: java.nio 를 활용한 백업 파일 존재 여부 확인
        Path backupPath = Paths.get(BACKUP_FILE);
        if (Files.exists(backupPath)) {
            // Day 2 & Day 3: 바이트 스트림 및 객체 역직렬화 복원
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(BACKUP_FILE))) {
                diaryList = (List<DiaryEntry>) ois.readObject();
                System.out.println("[시스템] 백업 데이터로부터 " + diaryList.size() + "개의 일기를 복원했습니다.");
            } catch (Exception e) {
                System.out.println("[시스템] 백업 데이터 로드 중 오류가 발생했습니다: " + e.getMessage());
            }
        }

        boolean running = true;
        while (running) {
            System.out.println("\n=== 스마트 일기장 & 백업 시스템 ===");
            System.out.println("1. 새 일기 작성");
            System.out.println("2. 일기 목록 조회");
            System.out.println("3. 백업 데이터 파일로 저장 (직렬화)");
            System.out.println("4. 종료");
            System.out.print("선택> ");
            int menu = sc.nextInt();
            sc.nextLine(); // 버퍼 비우기

            switch (menu) {
                case 1:
                    System.out.print("작성일 (예: 2026-06-06): ");
                    String date = sc.nextLine();
                    System.out.print("제목: ");
                    String title = sc.nextLine();
                    System.out.print("본문 내용: ");
                    String rawContent = sc.nextLine();
                    System.out.print("비밀번호(백업 제외 민감정보): ");
                    String password = sc.nextLine();

                    // Day 5: 정규표현식을 이용한 개인 정보 마스킹 (이메일 및 전화번호 검출)
                    String maskedContent = maskPersonalData(rawContent);

                    // 일기 객체 생성
                    DiaryEntry entry = new DiaryEntry(date, title, maskedContent, password);
                    diaryList.add(entry);

                    // Day 1: 문자 스트림(BufferedWriter)을 활용해 원본(Raw) 텍스트 파일에 쓰기
                    saveToTextFile(entry);
                    System.out.println("[안내] 일기가 로컬 텍스트 파일에 추가되었으며, 임시 메모리에 등록되었습니다.");
                    break;

                case 2:
                    System.out.println("\n=== 일기 목록 ===");
                    if (diaryList.isEmpty()) {
                        System.out.println("작성된 일기가 없습니다.");
                    } else {
                        for (DiaryEntry de : diaryList) {
                            // Day 5: String.format을 이용한 깔끔한 포맷 출력
                            System.out.println(de.toString());
                        }
                    }
                    break;

                case 3:
                    // Day 2 & Day 3: 바이트 스트림 및 객체 직렬화 파일 저장
                    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(BACKUP_FILE))) {
                        oos.writeObject(diaryList);
                        System.out.println("[시스템] 메모리에 있는 모든 일기를 " + BACKUP_FILE + "에 백업 완료했습니다.");
                    } catch (IOException e) {
                        System.out.println("[시스템] 백업 중 오류 발생: " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("프로그램을 종료합니다.");
                    running = false;
                    break;

                default:
                    System.out.println("올바른 번호를 선택해주세요.");
            }
        }
        sc.close();
    }

    // Day 5: 정규표현식을 이용한 이메일 및 전화번호 마스킹 처리 메서드
    private static String maskPersonalData(String text) {
        // 이메일 정규식 패턴
        String emailPattern = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
        // 전화번호 정규식 패턴
        String phonePattern = "\\d{2,3}-\\d{3,4}-\\d{4}";

        // 이메일 마스킹
        Pattern p1 = Pattern.compile(emailPattern);
        Matcher m1 = p1.matcher(text);
        text = m1.replaceAll("[이메일 마스킹]");

        // 전화번호 마스킹
        Pattern p2 = Pattern.compile(phonePattern);
        Matcher m2 = p2.matcher(text);
        text = m2.replaceAll("[전화번호 마스킹]");

        return text;
    }

    // Day 1: BufferedWriter를 사용한 텍스트 파일 저장
    private static void saveToTextFile(DiaryEntry entry) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(TEXT_FILE, true))) {
            bw.write(String.format("날짜: %s | 제목: %s\n내용: %s\n", 
                     entry.getDate(), entry.getTitle(), entry.getContent()));
            bw.write("-----------------------------------------------\n");
        } catch (IOException e) {
            System.out.println("[오류] 텍스트 파일 저장 중 에러 발생: " + e.getMessage());
        }
    }
}

// Day 3: Serializable 구현
class DiaryEntry implements Serializable {
    // 직렬화 버전 ID
    private static final long serialVersionUID = 1L;

    private String date;
    private String title;
    private String content;

    // Day 3: 직렬화 제외 필드 (transient)
    private transient String password;

    public DiaryEntry(String date, String title, String content, String password) {
        this.date = date;
        this.title = title;
        this.content = content;
        this.password = password;
    }

    public String getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getPassword() {
        return password;
    }

    // Day 5: String.format을 이용한 포맷팅 출력 오버라이딩
    @Override
    public String toString() {
        // 비밀번호는 직렬화가 해제되어 불러와졌을 때 null이 됨 (transient 확인용)
        String pwDisplay = (password == null) ? "null(미복원)" : "****";
        return String.format("[%s] 제목: %-15s | 본문: %s (비밀번호: %s)", date, title, content, pwDisplay);
    }
}
