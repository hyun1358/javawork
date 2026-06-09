package week11.day2;

import java.util.ArrayList;
import java.util.List;

// 보충 문제 4_1의 모범 정답 파일입니다.
public class Answer4_1 {
    public static void main(String[] args) {
        StockTicker ticker = new StockTicker();
        
        Investor inv1 = new Investor("투자자 A", ticker);
        Investor inv2 = new Investor("투자자 B", ticker);
        Investor inv3 = new Investor("투자자 C", ticker);

        ticker.subscribe(inv1);
        ticker.subscribe(inv2);
        ticker.subscribe(inv3);

        System.out.println("=== 알림 발송 시작 ===");
        ticker.notifyPriceUpdate("삼성전자 주식 10만 원 돌파!");

        System.out.println("\n알림 후 남은 구독자 수: " + ticker.getObserversCount());
    }

    interface StockObserver {
        void update(String news);
    }

    static class Investor implements StockObserver {
        private String name;
        private StockTicker ticker;

        public Investor(String name, StockTicker ticker) {
            this.name = name;
            this.ticker = ticker;
        }

        @Override
        public void update(String news) {
            System.out.println(name + " 수신: " + news + " -> 목표 도달! 주식을 전량 매도하고 구독을 취소합니다.");
            ticker.unsubscribe(this);
        }
    }

    static class StockTicker {
        private List<StockObserver> observers = new ArrayList<>();

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
            // 해결책: 알림을 전송할 때 원본 리스트의 '방어적 복사본'을 만들어 순회합니다.
            // 이렇게 하면 순회 중에 observers.remove(o)가 호출되어 원본이 수정되도, 루프를 돌고 있는 targets 리스트에는 영향이 없어 예외가 나지 않습니다.
            List<StockObserver> targets = new ArrayList<>(this.observers);
            for (StockObserver o : targets) {
                o.update(news);
            }
        }
    }
}
