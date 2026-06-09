package week11.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * [보충 문제 4_1] 알림 순회 중 안전한 구독 취소 구현
 * 
 * 문제:
 * 주식 알림 서비스(StockTicker)에서 알림을 수신받은 투자자(Investor)가 즉시 구독을 해지하고자 합니다.
 * 현재 작성된 코드 상태로 프로그램을 실행하면, 알림 전파 루프(for) 도중 리스트가 수정되어
 * ConcurrentModificationException 예외가 던져지게 됩니다.
 * 
 * 이 예외가 발생하지 않고 모든 알림 및 탈퇴 처리가 안전하게 처리되도록
 * StockTicker의 알림 전파 코드를 수정하세요. (방어적 복사 또는 CopyOnWriteArrayList 사용법 중 하나를 적용해 보세요.)
 */
public class Problem4_1 {
    public static void main(String[] args)
    {
        StockTicker ticker = new StockTicker();
        
        Investor inv1 = new Investor("투자자 A", ticker);
        Investor inv2 = new Investor("투자자 B", ticker);
        Investor inv3 = new Investor("투자자 C", ticker);

        ticker.subscribe(inv1);
        ticker.subscribe(inv2);
        ticker.subscribe(inv3);

        System.out.println("=== 알림 발송 시작 ===");
        // 예외가 발생하지 않고 모든 투자자가 안전하게 수신하고 구독 해제되어야 합니다.
        ticker.notifyPriceUpdate("삼성전자 주식 10만 원 돌파!");

        System.out.println("\n알림 후 남은 구독자 수: " + ticker.getObserversCount());
    }

    interface StockObserver
    {
        void update(String news);
    }

    static class Investor implements StockObserver
    {
        private String name;
        private StockTicker ticker;

        public Investor(String name, StockTicker ticker)
        {
            this.name = name;
            this.ticker = ticker;
        }

        @Override
        public void update(String news)
        {
            System.out.println(name + " 수신: " + news + " -> 목표 도달! 주식을 전량 매도하고 구독을 취소합니다.");
            // 알림 수신 즉시 리스트에서 자기 자신을 지워 달라고 요청
            ticker.unsubscribe(this);
        }
    }

    static class StockTicker {
        // TODO: 필요하다면 자료구조를 변경하거나, 아래 notifyPriceUpdate 메서드의 순회 방식을 고쳐 예외를 해결하세요.
        private List<StockObserver> observers = new CopyOnWriteArrayList<>();

        public void subscribe(StockObserver o) {
            observers.add(o);
        }

        public void unsubscribe(StockObserver o) {
            observers.remove(o);
        }

        public int getObserversCount() {
            return observers.size();
        }

        public void notifyPriceUpdate(String news) {
            // TODO: 아래의 루프 도중 unsubscribe가 호출되어도 ConcurrentModificationException이 터지지 않도록 코드를 안전하게 수정하세요.
            for (StockObserver o : observers)
            {
                o.update(news);
            }
        }
    }
}
