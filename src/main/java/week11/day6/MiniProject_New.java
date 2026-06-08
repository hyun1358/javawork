package week11.day6;

import java.sql.Connection;

/**
 * [종합 미니 프로젝트 - 신규] Week 11 Day 6
 * 「 Connection Pool과 트랜잭션을 적용한 은행 계좌 이체 시스템 」
 * 
 * 가이드(MiniProjectGuide_New.java)의 요구사항에 따라 
 * JDBC, PreparedStatement, 트랜잭션(commit/rollback), DAO/DTO 패턴을 적용하여 안전한 뱅킹 시스템을 구현하세요.
 * 
 * [주의] 동일 패키지 내 클래스명 중복 에러를 방지하기 위해 
 * 아래의 뼈대 클래스들을 직접 완성하거나 파일 하단에 직접 구현해 주세요.
 */
public class MiniProject_New {
    public static void main(String[] args) {
        // TODO: 1. DB 초기 테이블 생성 수행 (H2 인메모리 사용 권장)
        
        // TODO: 2. 테스트용 계좌 등록
        
        // TODO: 3. 계좌 이체 수행 (트랜잭션 적용)
        //          - 10,000원 정상 이체 (성적 반영 확인)
        //          - 잔액을 초과하는 5,000,000원 이체 시도 (예외 발생 후 롤백 처리 검증)
    }

    // TODO: 계좌 이체 서비스 메서드 구현 (트랜잭션 제어 필수)
    public static void transfer(String fromAccount, String toAccount, int amount) {
        // Connection conn = null;
        // try {
        //     conn = DBConnectionManager.getConnection();
        //     conn.setAutoCommit(false);
        //     ...
        //     conn.commit();
        // } catch (Exception e) {
        //     if (conn != null) conn.rollback();
        // } finally {
        //     if (conn != null) conn.close();
        // }
    }
}

// TODO: 아래 클래스들의 주석을 해제하고 구현하거나 본인만의 구현을 작성하세요.
/*
class AccountDTO {
    // accountNumber, owner, balance 필드 및 생성자/Getter
}

class AccountDAO {
    // createAccount(Connection conn, AccountDTO account)
    // findByAccountNumber(Connection conn, String accountNumber)
    // updateBalance(Connection conn, String accountNumber, int amount)
}

class DBConnectionManager {
    // getConnection() 구현
}
*/
