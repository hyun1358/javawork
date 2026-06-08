package week11.day6;

/**
 * [종합 미니 프로젝트 가이드 - 신규] Week 11 Day 6
 * 「 Connection Pool과 트랜잭션을 적용한 은행 계좌 이체 시스템 」
 * 
 * [목적]
 *   Week 11에서 배운 JDBC 데이터베이스 연동 기술(JDBC CRUD, PreparedStatement, 트랜잭션 제어, 
 *   DAO/DTO 패턴, HikariCP 커넥션 풀 적용)을 모두 활용하여 안전한 계좌 이체 비즈니스 로직을 구축합니다.
 * 
 * [활용 개념 — Day별 대응]
 *   - Day 1 & Day 2 (JDBC 기초 & PreparedStatement CRUD):
 *       java.sql.Connection, PreparedStatement, ResultSet을 활용한 DB 연동.
 *       SQL 인젝션 방지 및 가독성을 위해 ? 파라미터 바인딩을 지원하는 PreparedStatement 사용.
 *   - Day 3 (트랜잭션과 배치):
 *       계좌 이체 로직 실행 시 autoCommit을 false로 설정하고, 
 *       "A계좌 출금"과 "B계좌 입금" 작업을 하나의 트랜잭션 단위로 묶어 실행.
 *       예외 발생 시 rollback(), 정상 종료 시 commit()을 명시적으로 호출하여 데이터 정합성 보장.
 *   - Day 4 (DAO 패턴 & DTO):
 *       계좌 데이터를 담는 AccountDTO 클래스 설계.
 *       데이터베이스 CRUD 연동을 전담하는 AccountDAO 클래스를 구현하여 비즈니스 로직과 데이터 액세스 영역 분리.
 *   - Day 5 (Connection Pool & HikariCP):
 *       커넥션 생성 비용을 줄이기 위해 HikariCP(또는 싱글톤 기반 커넥션 매니저)를 활용하여 
 *       커넥션을 재사용하는 커넥션 풀 메커니즘을 흉내 내거나 실제 설정 적용.
 *       (실제 DB가 실행되지 않는 콘솔 환경일 수 있으므로 H2/SQLite 가상 DB 접속 또는 표준 JDBC API 규격을 철저히 준수한 구현을 목표로 합니다.)
 * 
 * [상세 요구사항]
 *   1. AccountDTO 클래스 설계:
 *      - 필드: private String accountNumber, private String owner, private int balance
 *      - 생성자, Getter/Setter 및 toString() 오버라이딩
 *   2. AccountDAO 클래스 설계:
 *      - DB CRUD 메서드 제공 (Connection을 매개변수로 전달받아 트랜잭션 경계를 공유할 수 있도록 설계)
 *      - public void updateBalance(Connection conn, String accountNumber, int amount) throws SQLException
 *      - public AccountDTO findByAccountNumber(Connection conn, String accountNumber) throws SQLException
 *      - public void createAccount(Connection conn, AccountDTO account) throws SQLException
 *   3. DB Connection Manager 설계 (싱글톤):
 *      - HikariCP 설정 구조를 차용하거나, 메모리/임시 H2 DB 연동을 초기화하여 Connection을 제공하는 매니저 구현.
 *      - H2 DB 메모리 모드("jdbc:h2:mem:bankdb;DB_CLOSE_DELAY=-1")를 활용해 무설치로 완벽한 JDBC 실습 제공.
 *   4. 비즈니스 서비스 로직 (계좌 이체):
 *      - transfer(String fromAccount, String toAccount, int amount) 메서드 구현.
 *      - 로직 흐름:
 *        * 커넥션을 가져옴 -> autoCommit(false) 설정
 *        * fromAccount 에서 amount만큼 출금 (잔액 부족 시 예외 발생 및 롤백)
 *        * toAccount 에 amount만큼 입금
 *        * 모든 과정이 정상 처리되면 commit() 호출, 에러 발생 시 rollback() 호출.
 */
public class MiniProjectGuide_New {
}
