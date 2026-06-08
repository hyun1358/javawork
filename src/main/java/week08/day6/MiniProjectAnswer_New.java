package week08.day6;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * [종합 미니 프로젝트 정답 - 신규] Week 08 Day 6
 * 「 멀티스레드 기반 티켓 실시간 예매 및 랭킹 관리 시스템 」
 */
public class MiniProjectAnswer_New {
    public static void main(String[] args) {
        // Day 2: 공유 자원인 티켓 부스 생성 (총 5장의 티켓 설정)
        TicketBooth booth = new TicketBooth(5);

        // Day 3: 고정 크기 3의 스레드 풀 생성
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Day 4: 전체 작업 시작 시각 기록
        LocalDateTime startTime = LocalDateTime.now();
        System.out.println("[시스템] 예매 서버 오픈 시각: " + 
                startTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));

        // Day 1 & Day 3: 10명의 고객이 병렬로 예매 신청하도록 스레드 풀에 Task 전달
        for (int i = 1; i <= 10; i++) {
            String customerName = "고객_" + String.format("%02d", i);
            executor.submit(new ReservationTask(customerName, booth));
        }

        // 스레드 풀 종료 및 대기
        executor.shutdown();
        try {
            // 모든 작업이 끝나거나 10초 대기
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        // Day 4: 전체 소요 시간 계산 (Duration)
        LocalDateTime endTime = LocalDateTime.now();
        Duration elapsed = Duration.between(startTime, endTime);
        
        System.out.println("\n[시스템] 예매 서버 클로즈 시각: " + 
                endTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));
        System.out.printf("[시스템] 예매 완료 처리 소요 시간: %d 밀리초 (ms)\n", elapsed.toMillis());

        // Day 5: 유틸리티(Collections.sort)를 이용해 예매 성공자 목록 정렬
        List<TicketReservation> list = booth.getSuccessList();
        
        // 정렬: 고객 이름순으로 정렬
        Collections.sort(list, new Comparator<TicketReservation>() {
            @Override
            public int compare(TicketReservation o1, TicketReservation o2) {
                return o1.getCustomerName().compareTo(o2.getCustomerName());
            }
        });

        System.out.println("\n================ 예매 성공자 명단 (이름순 정렬) ================");
        if (list.isEmpty()) {
            System.out.println("예매 성공자가 없습니다.");
        } else {
            for (TicketReservation reservation : list) {
                System.out.println(reservation);
            }
        }
        System.out.println("================================================================");
    }
}

// 예매 정보 클래스
class TicketReservation {
    private String customerName;
    private LocalDateTime reservationTime;
    private int seatNumber;

    public TicketReservation(String customerName, LocalDateTime reservationTime, int seatNumber) {
        this.customerName = customerName;
        this.reservationTime = reservationTime;
        this.seatNumber = seatNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public LocalDateTime getReservationTime() {
        return reservationTime;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    @Override
    public String toString() {
        // Day 4: DateTimeFormatter 활용
        String formattedTime = reservationTime.format(DateTimeFormatter.ofPattern("HH:mm:ss.SSS"));
        return String.format("고객명: %s | 좌석 번호: %2d번 | 예매 시간: %s", 
                customerName, seatNumber, formattedTime);
    }
}

// Day 2: 티켓 예매 부스 (공유 자원)
class TicketBooth {
    private int remainingTickets;
    private List<TicketReservation> successList = new ArrayList<>();
    private Random random = new Random(); // Day 5: Random 유틸리티

    public TicketBooth(int totalTickets) {
        this.remainingTickets = totalTickets;
    }

    // Day 2: 여러 스레드가 동시 접근할 때 데이터 정합성을 위한 synchronized 키워드 사용
    public synchronized boolean reserve(String customerName) {
        if (remainingTickets > 0) {
            // 스레드 경합 상황을 시뮬레이션하기 위한 임의의 짧은 딜레이
            try {
                Thread.sleep(50); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            remainingTickets--;
            
            // Day 5: 1~50 사이의 랜덤 좌석 지정
            int seatNumber = random.nextInt(50) + 1;
            
            // Day 4: 예매 성공 시점 구하기
            LocalDateTime now = LocalDateTime.now();

            TicketReservation reservation = new TicketReservation(customerName, now, seatNumber);
            successList.add(reservation);
            
            return true;
        }
        return false;
    }

    public List<TicketReservation> getSuccessList() {
        return successList;
    }
}

// Day 1: Runnable 인터페이스 구현을 통한 예매 작업 스레드화
class ReservationTask implements Runnable {
    private String name;
    private TicketBooth booth;

    public ReservationTask(String name, TicketBooth booth) {
        this.name = name;
        this.booth = booth;
    }

    @Override
    public void run() {
        // 티켓 부스에 예매 시도
        boolean success = booth.reserve(name);
        if (success) {
            System.out.println("   [★성공] " + name + " 님이 티켓 예매에 성공했습니다!");
        } else {
            System.out.println("   [x실패] " + name + " 님 예매 실패 - 티켓이 매진되었습니다.");
        }
    }
}
