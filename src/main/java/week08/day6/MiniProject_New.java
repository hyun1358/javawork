package week08.day6;

/**
 * [종합 미니 프로젝트 - 신규] Week 08 Day 6
 * 「 멀티스레드 기반 티켓 실시간 예매 및 랭킹 관리 시스템 」
 * 
 * 가이드(MiniProjectGuide_New.java)의 요구사항에 따라 
 * 멀티스레드, 동기화(synchronized), 스레드 풀(ExecutorService), 날짜/시간(LocalDateTime, Duration), 
 * 그리고 유틸리티(Collections.sort, Random)를 모두 적용해 프로그램을 완성하세요.
 * 
 * [주의] 동일 패키지 내 클래스명 중복 에러를 방지하기 위해 
 * 아래의 뼈대 클래스들을 직접 완성하거나 파일 하단에 직접 구현해 주세요.
 */
public class MiniProject_New {
    public static void main(String[] args) {
        // TODO: 1. TicketBooth(공유 자원) 생성 및 총 티켓 수 설정
        
        // TODO: 2. ExecutorService 스레드 풀 생성
        
        // TODO: 3. 작업 시작 시간 기록 (LocalDateTime)
        
        // TODO: 4. 10명의 고객 예매 요청을 스레드 풀에 등록 (submit)
        
        // TODO: 5. 스레드 풀 종료 대기 및 전체 소요 시간(Duration) 계산
        
        // TODO: 6. 예매 성공 명단을 고객 이름순으로 정렬(Collections.sort) 후 출력
    }
}

// TODO: 아래 클래스들의 주석을 해제하고 구현하거나 본인만의 구현을 작성하세요.
/*
class TicketReservation {
    // 고객명, 예매시각, 좌석번호 필드 및 생성자/Getter
}

class TicketBooth {
    // remainingTickets, successList
    // reserve() 동기화 메서드 구현
}

class ReservationTask implements Runnable {
    // name, booth 필드
    // run() 구현
}
*/
