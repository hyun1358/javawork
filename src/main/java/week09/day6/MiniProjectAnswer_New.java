package week09.day6;

import java.io.*;
import java.util.Properties;
import java.util.Scanner;

/**
 * [종합 미니 프로젝트 정답 - 신규] Week 09 Day 6
 * 「 도서 대여 파일 장부 및 상태 인덱스 관리 시스템 」
 */
public class MiniProjectAnswer_New {
    private static final String DIR_PATH = "data";
    private static final String CONFIG_FILE = "data/config.properties";
    private static final String INDEX_FILE = "data/books.dat";
    private static final String RENTAL_FILE = "data/rentals.txt";
    private static final String BACKUP_FILE = "data/rentals_backup.txt";

    // 1레코드 크기: int(4바이트) + char(2바이트) = 6바이트
    private static final int RECORD_SIZE = 6;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Day 1: 디렉토리 관리 (data 폴더가 없으면 생성)
        File dir = new File(DIR_PATH);
        if (!dir.exists()) {
            dir.mkdir();
        }

        // Day 5: Properties 로딩
        Properties props = new Properties();
        File conf = new File(CONFIG_FILE);
        if (!conf.exists()) {
            // 기본 환경 설정 저장
            props.setProperty("library_name", "자바 아카데미 도서관");
            props.setProperty("max_rent_days", "7");
            try (FileWriter fw = new FileWriter(conf)) {
                props.store(fw, "Library Configurations");
            } catch (IOException e) {
                System.out.println("설정 파일 생성 실패: " + e.getMessage());
            }
        } else {
            try (FileReader fr = new FileReader(conf)) {
                props.load(fr);
            } catch (IOException e) {
                System.out.println("설정 파일 읽기 실패: " + e.getMessage());
            }
        }

        String libName = props.getProperty("library_name", "기본 도서관");
        System.out.println("============================================");
        System.out.println("환영합니다! " + libName + " 시스템에 접속했습니다.");
        System.out.println("============================================");

        // Day 4: RandomAccessFile 을 사용한 도서 인덱스 초기 설정 (책 3권 등록)
        // 1번 책: 1, 'O'
        // 2번 책: 2, 'O'
        // 3번 책: 3, 'O'
        File idxFile = new File(INDEX_FILE);
        if (!idxFile.exists()) {
            try (RandomAccessFile raf = new RandomAccessFile(idxFile, "rw")) {
                for (int id = 1; id <= 3; id++) {
                    raf.writeInt(id);      // 4바이트
                    raf.writeChar('O');    // 2바이트 (O: 대출가능, X: 대출중)
                }
                System.out.println("[시스템] 도서 인덱스 파일(books.dat)이 생성 및 초기화되었습니다.");
            } catch (IOException e) {
                System.out.println("인덱스 초기화 오류: " + e.getMessage());
            }
        }

        boolean running = true;
        while (running) {
            System.out.println("\n--- 메뉴 선택 ---");
            System.out.println("1. 도서 대출 신청");
            System.out.println("2. 도서 반납 신청");
            System.out.println("3. 대출 장부 전체 조회");
            System.out.println("4. 대출 장부 백업 (바이트 복사)");
            System.out.println("5. 종료");
            System.out.print("선택> ");
            int menu = sc.nextInt();
            sc.nextLine(); // 버퍼 비우기

            switch (menu) {
                case 1:
                    System.out.print("대출할 도서 번호 (1~3): ");
                    int rentId = sc.nextInt();
                    sc.nextLine();
                    if (rentId < 1 || rentId > 3) {
                        System.out.println("올바른 도서 번호가 아닙니다.");
                        break;
                    }
                    System.out.print("대출자 이름: ");
                    String borrower = sc.nextLine().trim();

                    // Day 4: RandomAccessFile seek 제어
                    try (RandomAccessFile raf = new RandomAccessFile(INDEX_FILE, "rw")) {
                        // 레코드 위치 계산: (id - 1) * RECORD_SIZE
                        raf.seek((rentId - 1) * RECORD_SIZE);
                        int id = raf.readInt();
                        char status = raf.readChar();

                        if (status == 'X') {
                            System.out.println("[대출 불가] 이미 대출 중인 도서입니다.");
                        } else {
                            // 상태 수정
                            raf.seek((rentId - 1) * RECORD_SIZE + 4); // 상태값 위치로 바로 이동
                            raf.writeChar('X'); // 'X'로 덮어쓰기

                            // Day 2: 문자 스트림(BufferedWriter)으로 장부 기록
                            try (BufferedWriter bw = new BufferedWriter(new FileWriter(RENTAL_FILE, true))) {
                                bw.write(rentId + "," + borrower + ",2026-06-06\n");
                            }
                            System.out.println("[성공] " + id + "번 도서가 대출되었습니다. 장부에 기록되었습니다.");
                        }
                    } catch (IOException e) {
                        System.out.println("대출 처리 오류: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("반납할 도서 번호 (1~3): ");
                    int returnId = sc.nextInt();
                    sc.nextLine();
                    if (returnId < 1 || returnId > 3) {
                        System.out.println("올바른 도서 번호가 아닙니다.");
                        break;
                    }

                    // Day 4: RandomAccessFile 을 활용한 상태 변경
                    try (RandomAccessFile raf = new RandomAccessFile(INDEX_FILE, "rw")) {
                        raf.seek((returnId - 1) * RECORD_SIZE);
                        int id = raf.readInt();
                        char status = raf.readChar();

                        if (status == 'O') {
                            System.out.println("[반납 불가] 이미 대여 가능한 도서입니다.");
                        } else {
                            raf.seek((returnId - 1) * RECORD_SIZE + 4); // 상태값 위치로 이동
                            raf.writeChar('O'); // 'O'로 변경
                            System.out.println("[성공] " + id + "번 도서가 반납되었습니다.");
                        }
                    } catch (IOException e) {
                        System.out.println("반납 처리 오류: " + e.getMessage());
                    }
                    break;

                case 3:
                    // Day 5: Scanner를 활용한 파일 파싱 및 읽기
                    File rentalFile = new File(RENTAL_FILE);
                    if (!rentalFile.exists()) {
                        System.out.println("대출 장부가 비어 있습니다.");
                        break;
                    }

                    System.out.println("\n========= 대출 장부 내역 =========");
                    try (Scanner fileScanner = new Scanner(rentalFile)) {
                        while (fileScanner.hasNextLine()) {
                            String line = fileScanner.nextLine();
                            // 쉼표로 파싱
                            String[] data = line.split(",");
                            if (data.length >= 3) {
                                System.out.printf("도서 번호: %s번 | 대출자: %-6s | 대출일: %s\n", 
                                        data[0], data[1], data[2]);
                            }
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("장부 파일을 찾을 수 없습니다.");
                    }
                    System.out.println("==================================");
                    break;

                case 4:
                    // Day 3: 바이트 스트림을 이용한 파일 백업 (FileInputStream/FileOutputStream)
                    File src = new File(RENTAL_FILE);
                    if (!src.exists()) {
                        System.out.println("백업할 장부 파일이 존재하지 않습니다.");
                        break;
                    }

                    try (FileInputStream fis = new FileInputStream(src);
                         FileOutputStream fos = new FileOutputStream(BACKUP_FILE)) {
                        byte[] buffer = new byte[1024];
                        int bytesRead;
                        while ((bytesRead = fis.read(buffer)) != -1) {
                            fos.write(buffer, 0, bytesRead);
                        }
                        System.out.println("[백업 완료] 장부가 " + BACKUP_FILE + "로 안전하게 백업되었습니다.");
                    } catch (IOException e) {
                        System.out.println("백업 실패: " + e.getMessage());
                    }
                    break;

                case 5:
                    System.out.println("시스템을 종료합니다.");
                    running = false;
                    break;

                default:
                    System.out.println("잘못된 메뉴입니다.");
            }
        }
        sc.close();
    }
}
