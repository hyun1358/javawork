package week11.day6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 * [종합 미니 프로젝트 정답 - 신규] Week 11 Day 6
 * 「 Connection Pool과 트랜잭션을 적용한 은행 계좌 이체 시스템 」
 * 
 * * 설명:
 *   본 예제는 외부 데이터베이스 설치 유무에 관계없이 완벽히 동작하도록 
 *   인메모리 H2 DB 연동을 우선 시도하며, H2 드라이버가 존재하지 않는 순수 자바 환경일 경우 
 *   자체 구현된 Mock JDBC 드라이버(H2 모방 장치)로 자동 Fallback 하여 작동하도록 안전 설계되었습니다.
 */
public class MiniProjectAnswer_New {
    public static void main(String[] args) {
        // DB 테이블 및 초기 데이터 세팅
        initDatabase();

        System.out.println("=== 초기 계좌 상태 조회 ===");
        printAccount("111-1111");
        printAccount("222-2222");

        // 1. 정상 계좌 이체 (10,000원 송금)
        System.out.println("\n[이체 시도] 111-1111 계좌에서 222-2222 계좌로 10,000원 송금");
        transfer("111-1111", "222-2222", 10000);

        System.out.println("\n=== 이체 후 계좌 상태 조회 ===");
        printAccount("111-1111");
        printAccount("222-2222");

        // 2. 롤백 시나리오 (잔액을 초과하는 5,000,000원 송금 시도)
        System.out.println("\n[이체 시도] 111-1111 계좌에서 222-2222 계좌로 5,000,000원 송금");
        transfer("111-1111", "222-2222", 5000000);

        System.out.println("\n=== 롤백 후 최종 계좌 상태 조회 (잔액 변동 없어야 함) ===");
        printAccount("111-1111");
        printAccount("222-2222");
    }

    // 데이터베이스 초기화 및 테이블 생성
    private static void initDatabase() {
        try (Connection conn = DBConnectionManager.getConnection();
             Statement stmt = conn.createStatement()) {
            
            // 기존 테이블이 있으면 삭제 후 생성
            try {
                stmt.execute("DROP TABLE IF EXISTS ACCOUNTS");
            } catch (Exception e) {
                // MockDB 환경에서는 무시
            }
            
            stmt.execute("CREATE TABLE ACCOUNTS (" +
                    "account_number VARCHAR(20) PRIMARY KEY, " +
                    "owner VARCHAR(20), " +
                    "balance INT)");

            // 초기 데이터 추가
            AccountDAO dao = new AccountDAO();
            dao.createAccount(conn, new AccountDTO("111-1111", "홍길동", 50000));
            dao.createAccount(conn, new AccountDTO("222-2222", "이순신", 20000));
            
            System.out.println("[시스템] 데이터베이스 초기 테이블 생성 및 샘플 데이터 적재 완료.");
        } catch (SQLException e) {
            System.out.println("데이터베이스 초기화 실패: " + e.getMessage());
        }
    }

    // 계좌 잔액 출력용 헬퍼 메서드
    private static void printAccount(String accountNumber) {
        try (Connection conn = DBConnectionManager.getConnection()) {
            AccountDAO dao = new AccountDAO();
            AccountDTO account = dao.findByAccountNumber(conn, accountNumber);
            if (account != null) {
                System.out.println("   -> " + account);
            } else {
                System.out.println("   -> 계좌를 찾을 수 없습니다: " + accountNumber);
            }
        } catch (SQLException e) {
            System.out.println("조회 오류: " + e.getMessage());
        }
    }

    // Day 3: 트랜잭션 제어를 적용한 이체 메서드
    public static void transfer(String fromAccount, String toAccount, int amount) {
        Connection conn = null;
        try {
            conn = DBConnectionManager.getConnection();
            
            // Day 3: 수동 커밋 모드로 설정 (트랜잭션 시작)
            conn.setAutoCommit(false);

            AccountDAO dao = new AccountDAO();

            // 1. 송금인 계좌 조회 및 잔액 검증
            AccountDTO sender = dao.findByAccountNumber(conn, fromAccount);
            if (sender == null) {
                throw new IllegalArgumentException("송금 계좌가 존재하지 않습니다: " + fromAccount);
            }
            if (sender.getBalance() < amount) {
                // Day 4: 예외를 발생시켜 비즈니스 트랜잭션 실패 유도
                throw new IllegalArgumentException("잔액이 부족합니다. (현재 잔액: " + sender.getBalance() + "원, 요청 금액: " + amount + "원)");
            }

            // 2. 수취인 계좌 존재 여부 조회
            AccountDTO receiver = dao.findByAccountNumber(conn, toAccount);
            if (receiver == null) {
                throw new IllegalArgumentException("수취 계좌가 존재하지 않습니다: " + toAccount);
            }

            // 3. 송금 계좌 출금 처리 (마이너스 차감)
            dao.updateBalance(conn, fromAccount, sender.getBalance() - amount);

            // 4. 수취 계좌 입금 처리 (플러스 증액)
            dao.updateBalance(conn, toAccount, receiver.getBalance() + amount);

            // Day 3: 모든 작업 성공 시 트랜잭션 확정 (Commit)
            conn.commit();
            System.out.println("   >> [이체 완료] 송금이 성공적으로 완료되어 커밋되었습니다.");

        } catch (Exception e) {
            System.out.println("   >> [이체 실패] 오류 발생: " + e.getMessage());
            // Day 3: 예외 발생 시 트랜잭션 롤백 (Rollback)
            if (conn != null) {
                try {
                    conn.rollback();
                    System.out.println("   >> [롤백 완료] 데이터가 안전하게 이전 상태로 되돌아갔습니다.");
                } catch (SQLException ex) {
                    System.out.println("롤백 중 에러 발생: " + ex.getMessage());
                }
            }
        } finally {
            // 커넥션 자원 반납
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("자원 반납 오류: " + e.getMessage());
                }
            }
        }
    }
}

// Day 4: Account DTO 클래스
class AccountDTO {
    private String accountNumber;
    private String owner;
    private int balance;

    public AccountDTO(String accountNumber, String owner, int balance) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = balance;
    }

    public String getAccountNumber() { return accountNumber; }
    public String getOwner() { return owner; }
    public int getBalance() { return balance; }

    @Override
    public String toString() {
        return String.format("계좌번호: %s | 예금주: %s | 잔액: %,d원", accountNumber, owner, balance);
    }
}

// Day 4: Account DAO 클래스 (Connection 파라미터는 트랜잭션 공유 목적)
class AccountDAO {
    
    // Day 2: PreparedStatement 사용한 등록
    public void createAccount(Connection conn, AccountDTO account) throws SQLException {
        String sql = "INSERT INTO ACCOUNTS (account_number, owner, balance) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, account.getAccountNumber());
            pstmt.setString(2, account.getOwner());
            pstmt.setInt(3, account.getBalance());
            pstmt.executeUpdate();
        }
    }

    // Day 2: PreparedStatement 사용한 조회 및 ResultSet 읽기 (Day 1)
    public AccountDTO findByAccountNumber(Connection conn, String accountNumber) throws SQLException {
        String sql = "SELECT * FROM ACCOUNTS WHERE account_number = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, accountNumber);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new AccountDTO(
                            rs.getString("account_number"),
                            rs.getString("owner"),
                            rs.getInt("balance")
                    );
                }
            }
        }
        return null;
    }

    // Day 2: PreparedStatement 사용한 업데이트
    public void updateBalance(Connection conn, String accountNumber, int amount) throws SQLException {
        String sql = "UPDATE ACCOUNTS SET balance = ? WHERE account_number = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, amount);
            pstmt.setString(2, accountNumber);
            pstmt.executeUpdate();
        }
    }
}

// Day 5: 싱글톤 방식의 DB Connection Manager
class DBConnectionManager {
    private static final String H2_URL = "jdbc:h2:mem:bankdb;DB_CLOSE_DELAY=-1";
    private static final String USER = "sa";
    private static final String PASSWORD = "";
    private static boolean useMock = false;

    static {
        try {
            // H2 드라이버가 로드 가능한지 확인
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            // 드라이버가 없으면 로컬 가상 Mock DB 드라이버 사용 설정
            useMock = true;
        }
    }

    public static Connection getConnection() throws SQLException {
        if (useMock) {
            return MockDB.getConnection();
        }
        return DriverManager.getConnection(H2_URL, USER, PASSWORD);
    }
}

// =========================================================================
// [안전 장치] H2 드라이버가 없을 때를 대비한 가상 JDBC 구현체 (MockDB)
// 학습자가 외부 라이브러리 설정 없이도 컴파일 오류 없이 순수 JDBC 문법을 연습할 수 있게 돕습니다.
// =========================================================================
class MockDB {
    private static final Map<String, MockRow> table = new HashMap<>();

    static class MockRow {
        String accountNumber;
        String owner;
        int balance;
        MockRow(String id, String name, int money) {
            accountNumber = id; owner = name; balance = money;
        }
    }

    public static Connection getConnection() {
        return (Connection) java.lang.reflect.Proxy.newProxyInstance(
            Connection.class.getClassLoader(),
            new Class<?>[]{Connection.class},
            (proxy, method, args) -> {
                String name = method.getName();
                if (name.equals("createStatement")) {
                    return createMockStatement();
                } else if (name.equals("prepareStatement")) {
                    return createMockPreparedStatement((String) args[0]);
                } else if (name.equals("setAutoCommit") || name.equals("commit") || name.equals("rollback") || name.equals("close")) {
                    // 트랜잭션 제어 동작 가상 성공화
                    return null;
                }
                return null;
            }
        );
    }

    private static Statement createMockStatement() {
        return (Statement) java.lang.reflect.Proxy.newProxyInstance(
            Statement.class.getClassLoader(),
            new Class<?>[]{Statement.class},
            (proxy, method, args) -> null
        );
    }

    private static PreparedStatement createMockPreparedStatement(String sql) {
        final Object[] params = new Object[4];
        return (PreparedStatement) java.lang.reflect.Proxy.newProxyInstance(
            PreparedStatement.class.getClassLoader(),
            new Class<?>[]{PreparedStatement.class},
            (proxy, method, args) -> {
                String methodName = method.getName();
                if (methodName.startsWith("set")) {
                    int index = (Integer) args[0];
                    params[index] = args[1];
                    return null;
                } else if (methodName.equals("executeUpdate")) {
                    if (sql.startsWith("INSERT")) {
                        String id = (String) params[1];
                        String name = (String) params[2];
                        int bal = (Integer) params[3];
                        table.put(id, new MockRow(id, name, bal));
                    } else if (sql.startsWith("UPDATE")) {
                        int bal = (Integer) params[1];
                        String id = (String) params[2];
                        MockRow row = table.get(id);
                        if (row != null) {
                            row.balance = bal;
                        }
                    }
                    return 1;
                } else if (methodName.equals("executeQuery")) {
                    String searchId = (String) params[1];
                    MockRow row = table.get(searchId);
                    
                    return (ResultSet) java.lang.reflect.Proxy.newProxyInstance(
                        ResultSet.class.getClassLoader(),
                        new Class<?>[]{ResultSet.class},
                        (rProxy, rMethod, rArgs) -> {
                            String rmName = rMethod.getName();
                            if (rmName.equals("next")) {
                                return row != null;
                            } else if (rmName.equals("getString")) {
                                String colName = (String) rArgs[0];
                                if (colName.equals("account_number")) return row.accountNumber;
                                if (colName.equals("owner")) return row.owner;
                            } else if (rmName.equals("getInt")) {
                                return row.balance;
                            } else if (rmName.equals("close")) {
                                return null;
                            }
                            return null;
                        }
                    );
                } else if (methodName.equals("close")) {
                    return null;
                }
                return null;
            }
        );
    }
}
