package week05.day6;

/**
 * [종합 미니 프로젝트 가이드 - 신규] Week 05 Day 6
 * 「 예외 처리와 컬렉션을 적용한 도서 대출 및 회원 관리 시스템 」
 * 
 * [목적]
 *   Week 05에서 배운 컬렉션 프레임워크(List, Set, Map)와 예외 처리(try-catch, 커스텀 예외)를
 *   모두 활용하여 안정적인 도서관 관리 시스템을 구축합니다.
 * 
 * [활용 개념 — Day별 대응]
 *   - Day 1 & Day 2 (예외 처리 & 커스텀 예외):
 *       이미 대출 중인 도서 대출 시도 시 AlreadyBorrowedException 발생.
 *       도서관에 없는 도서 조회 시 BookNotFoundException 발생.
 *       사용자가 메뉴 선택 시 숫자가 아닌 문자를 입력했을 때의 예외 처리(try-catch 활용).
 *   - Day 3 (List):
 *       도서 목록을 관리하는 데 동적 크기 조절이 가능한 ArrayList<Book> 사용.
 *   - Day 4 (Map):
 *       도서 대출 현황을 기록하는 데 Map<String, String> 사용 (키: 도서 제목, 값: 대출한 회원 이름).
 *       이를 통해 어떤 도서가 누구에게 대출되었는지 쉽게 매핑 및 조회.
 *   - Day 5 (Set):
 *       도서관에 등록될 도서 제목들의 중복 등록을 방지하기 위해 HashSet<String> 사용.
 * 
 * [상세 요구사항]
 *   1. Book 클래스 설계:
 *      - 필드: private String title, private boolean isBorrowed
 *      - 생성자 및 Getter/Setter 정의
 *   2. 커스텀 예외 클래스 설계:
 *      - BookNotFoundException (일반 Exception 상속)
 *      - AlreadyBorrowedException (RuntimeException 상속)
 *   3. Library 서비스 클래스 설계:
 *      - 필드:
 *        * List<Book> bookList = new ArrayList<>(); (Day 3)
 *        * Set<String> bookTitles = new HashSet<>(); (Day 5 - 중복 도서 등록 방지)
 *        * Map<String, String> loanRecords = new HashMap<>(); (Day 4 - 도서 제목 -> 회원 이름)
 *      - 메서드:
 *        * void registerBook(String title) throws Exception : 
 *          이미 존재하는 제목이면 Exception을 던지고, 새로운 책이면 List와 Set에 모두 추가.
 *        * void borrowBook(String title, String borrower) throws BookNotFoundException :
 *          도서가 없으면 BookNotFoundException 발생. 이미 대출 중이면 AlreadyBorrowedException 발생. 
 *          정상 상태이면 대출 처리 후 loanRecords 맵에 기록 저장.
 *        * void returnBook(String title) throws BookNotFoundException :
 *          도서가 없으면 BookNotFoundException 발생. 대출 중이 아니면 일반 메시지 출력. 
 *          대출 중이면 반납 처리 후 loanRecords 맵에서 제거.
 *   4. 메인 프로그램 흐름:
 *      - 1. 도서 등록, 2. 도서 목록 조회, 3. 도서 대출, 4. 도서 반납, 5. 대출 현황 조회, 6. 종료 메뉴 구성.
 *      - 각 메뉴 입력을 처리할 때 발생할 수 있는 오류를 try-catch로 감사하여 시스템 다운을 예방.
 */
public class MiniProjectGuide_New {
}
