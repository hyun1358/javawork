package week10.day6;

/**
 * ──────────────────────────────────────────────────────────
 * [미니 프로젝트 가이드] Week 10 Day 6
 * 「 종합 학생 성적 관리 시스템 」
 * ──────────────────────────────────────────────────────────
 *
 * [목적]
 *   Week 10에서 배운 모든 개념을 하나의 프로젝트에 통합하여 복습합니다.
 *
 * ──────────────────────────────────────────────────────────
 * [활용 개념 — Day별 대응]
 * ──────────────────────────────────────────────────────────
 *
 *  Day 1 - List (ArrayList)
 *    → 학생 목록을 ArrayList<Student>로 관리
 *    → Collections.sort()를 이용한 성적순 정렬
 *
 *  Day 2 - Set (HashSet)
 *    → 학번(studentId) 중복 등록 방지에 HashSet<String> 사용
 *    → Student 클래스에 equals() / hashCode() 오버라이드
 *
 *  Day 3 - Map (HashMap)
 *    → 과목별 점수를 HashMap<String, Integer>로 관리
 *       (예: {"국어":90, "영어":85, "수학":78})
 *    → 전체 학생의 과목별 평균을 계산할 때 Map 순회(entrySet)
 *
 *  Day 4 - 예외 처리 (Exception Handling)
 *    → 커스텀 예외 DuplicateStudentException (학번 중복 시)
 *    → 커스텀 예외 InvalidScoreException (점수가 0~100 범위 밖일 때)
 *    → try-catch-finally 로 안전한 입력 처리
 *    → 잘못된 메뉴 입력(NumberFormatException) 방어
 *
 *  Day 5 - I/O & 직렬화 (Serialization)
 *    → ObjectOutputStream / ObjectInputStream 으로
 *       ArrayList<Student> 를 파일(students.dat)에 저장/로드
 *    → 프로그램 시작 시 자동 로드, 종료 시 자동 저장
 *
 * ──────────────────────────────────────────────────────────
 * [요구사항]
 * ──────────────────────────────────────────────────────────
 *
 *  1. Student 클래스 설계
 *     - Serializable 구현                        ← Day5
 *     - 필드: String studentId, String name,
 *             HashMap<String, Integer> scores     ← Day3
 *     - equals() / hashCode(): studentId 기준     ← Day2
 *     - 평균 점수 계산 메서드: getAverage()
 *     - Comparable<Student> 구현 (평균 내림차순)  ← Day1
 *
 *  2. 커스텀 예외 클래스                          ← Day4
 *     - DuplicateStudentException  : 중복 학번 등록 시
 *     - InvalidScoreException      : 0~100 범위 밖 점수 입력 시
 *
 *  3. 메인 프로그램 (콘솔 메뉴)
 *     ┌───────────────────────────────────────┐
 *     │  === 학생 성적 관리 시스템 ===        │
 *     │  1. 학생 등록                         │
 *     │  2. 성적 입력                         │
 *     │  3. 전체 학생 조회 (성적순 정렬)      │
 *     │  4. 학생 검색 (학번으로)              │
 *     │  5. 과목별 평균 조회                  │
 *     │  6. 학생 삭제                         │
 *     │  7. 저장 후 종료                      │
 *     └───────────────────────────────────────┘
 *
 *  [기능 상세]
 *
 *  1) 학생 등록
 *     - 학번, 이름을 입력받아 Student 생성
 *     - HashSet으로 학번 중복 체크 → 중복 시 DuplicateStudentException  ← Day2, Day4
 *     - 통과하면 ArrayList에 추가                                      ← Day1
 *
 *  2) 성적 입력
 *     - 학번으로 학생 검색 (없으면 안내 메시지)
 *     - 과목명, 점수 입력
 *     - 점수 유효성 검사 → 범위 밖이면 InvalidScoreException           ← Day4
 *     - HashMap에 과목-점수 저장                                       ← Day3
 *
 *  3) 전체 학생 조회 (성적순 정렬)
 *     - Collections.sort()로 평균 점수 내림차순 정렬                   ← Day1
 *     - 학번 | 이름 | 과목별 점수 | 평균 출력
 *
 *  4) 학생 검색
// *     - 학번 입력 → 해당 학생 상세 정보 출력
 *     - 없으면 안내 메시지
 *
 *  5) 과목별 평균 조회
 *     - 전체 학생의 scores(Map)를 순회하며 과목별 총점 집계            ← Day3
 *     - 과목별 평균 출력
 *
 *  6) 학생 삭제
 *     - 학번으로 학생 검색 후 ArrayList에서 remove                    ← Day1
 *     - HashSet에서도 학번 제거                                       ← Day2
 *
 *  7) 저장 후 종료
 *     - ObjectOutputStream 으로 ArrayList<Student> 직렬화 저장         ← Day5
 *     - try-catch-finally 로 스트림 안전 종료                          ← Day4
 *
 *  [프로그램 시작 시]
 *     - "students.dat" 파일이 존재하면
 *       ObjectInputStream 으로 역직렬화하여 데이터 복원                ← Day5
 *     - 파일이 없으면 빈 ArrayList로 시작
 *
 * ──────────────────────────────────────────────────────────
 * [힌트]
 * ──────────────────────────────────────────────────────────
 *
 *  - Student 클래스는 별도 파일이 아닌 MiniProject.java 하단에
 *    package-private 클래스로 작성해도 됩니다.
 *  - 커스텀 예외도 같은 파일 하단에 작성 가능합니다.
 *  - scores가 비어있을 때 getAverage()는 0.0을 반환하도록 처리하세요.
 *  - 과목별 평균 계산 시, 해당 과목 점수가 없는 학생은 제외합니다.
 */
public class MiniProjectGuide {
}
