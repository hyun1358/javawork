package week01.day6;

import java.util.Scanner;

/**
 * [종합 미니 프로젝트 정답 - 신규] Week 01 Day 6
 * 「 학생 성적 분석 및 장학금 대상자 판별 시스템 」
 */
public class MiniProjectAnswer_New {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== 학생 성적 관리 시스템 ===");
        System.out.print("관리할 학생 수 입력(1~5명): ");
        int studentCount = sc.nextInt();
        sc.nextLine(); // 버퍼 비우기

        // Day 5: 1차원 배열 생성
        String[] names = new String[studentCount];
        int[] korScores = new int[studentCount];
        int[] engScores = new int[studentCount];

        // Day 4: 반복문을 이용해 정보 입력받기
        for (int i = 0; i < studentCount; i++) {
            System.out.printf("\n[%d번째 학생 정보 입력]\n", i + 1);
            System.out.print("이름: ");
            names[i] = sc.nextLine();
            
            System.out.print("국어 점수: ");
            korScores[i] = sc.nextInt();
            
            System.out.print("영어 점수: ");
            engScores[i] = sc.nextInt();
            sc.nextLine(); // 버퍼 비우기
        }

        // Day 4: while 문을 활용한 프로그램 메뉴 루프
        boolean run = true;
        while (run) {
            System.out.println("\n-------------------------------------");
            System.out.println("1. 전체 학생 성적 조회");
            System.out.println("2. 장학금 대상자 명단 조회");
            System.out.println("3. 프로그램 종료");
            System.out.println("-------------------------------------");
            System.out.print("메뉴 선택> ");
            int menu = sc.nextInt();
            sc.nextLine(); // 버퍼 비우기

            switch (menu) {
                case 1:
                    System.out.println("\n================= 전체 학생 성적 조회 =================");
                    System.out.printf("%-10s %-6s %-6s %-6s %-8s %-6s %-6s\n", 
                                      "이름", "국어", "영어", "총점", "평균", "학점", "합격여부");
                    System.out.println("-----------------------------------------------------");
                    
                    for (int i = 0; i < studentCount; i++) {
                        int total = korScores[i] + engScores[i];
                        
                        // Day 1 & Day 2: 형변환 및 산술 연산자 활용
                        double average = (double) total / 2; 

                        // Day 3: 조건문(if-else if-else) 활용한 학점 산출
                        char grade;
                        if (average >= 90.0) {
                            grade = 'A';
                        } else if (average >= 80.0) {
                            grade = 'B';
                        } else if (average >= 70.0) {
                            grade = 'C';
                        } else if (average >= 60.0) {
                            grade = 'D';
                        } else {
                            grade = 'F';
                        }

                        // Day 2: 삼항 연산자(?:)와 비교 연산자 활용
                        String isPassed = (average >= 60.0) ? "합격" : "불합격";

                        System.out.printf("%-10s %-6d %-6d %-6d %-8.2f %-6c %-6s\n", 
                                          names[i], korScores[i], engScores[i], total, average, grade, isPassed);
                    }
                    System.out.println("=====================================================");
                    break;

                case 2:
                    System.out.println("\n================= 장학금 대상자 명단 조회 =================");
                    boolean found = false;

                    for (int i = 0; i < studentCount; i++) {
                        int total = korScores[i] + engScores[i];
                        double average = (double) total / 2;

                        // Day 2: 논리 연산자(&&, ||) 및 비교 연산자 활용
                        // 조건: "국어 90점 이상 OR 영어 90점 이상"이면서 "두 과목 평균이 85점 이상"
                        if ((korScores[i] >= 90 || engScores[i] >= 90) && average >= 85.0) {
                            System.out.printf(" - %s (평균: %.2f점)\n", names[i], average);
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("장학금 대상자가 없습니다.");
                    }
                    System.out.println("=========================================================");
                    break;

                case 3:
                    System.out.println("프로그램을 종료합니다.");
                    run = false;
                    break;

                default:
                    System.out.println("잘못된 메뉴 선택입니다. 다시 입력해주세요.");
                    break;
            }
        }

        sc.close();
    }
}
