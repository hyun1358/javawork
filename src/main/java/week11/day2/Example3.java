package week11.day2;

import java.util.ArrayList;
import java.util.List;

/**
 * [학습 예제 3] Week 11 Day 2 — 전략 패턴 & 옵저버 패턴 완전 정복
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 3] 옵저버 패턴 (Observer Pattern)
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - Subject(발행자)의 상태 변화 → 구독한 Observer 전체에 알림(notify)
 *  - subscribe(구독 등록): 옵저버 리스트에 추가
 *
 * [문제별 학습 목표]
 * - 문제 3: 옵저버 패턴 — Product 품절 시 구독 User 알림
 */
public class Example3 {
    public static void main(String[] args) {
        // ─────────────────────────────────────────────
        // Lab 3: 옵저버 패턴 — 품절 알림 (→ 문제 3 참고)
        // ─────────────────────────────────────────────
        System.out.println("\n=== Lab 3: 옵저버 패턴 — 품절 알림 ===");
        Product product = new Product("MacBook Pro");

        product.subscribe(new User("김철수"));
        product.subscribe(new User("이영희"));
        product.subscribe(new User("박민준"));

        product.setSoldOut(); // 품절 → 구독자 전체에 알림
    }

    // ─── 옵저버 패턴: 품절 알림 ────────────────────────────
    interface Observer {
        void update(String message);
    }

    static class User implements Observer {
        private String name;
        User(String name) { this.name = name; }

        public void update(String message) {
            System.out.println(name + "님께 알림: " + message);
        }
    }

    static class Product {
        private String name;
        private List<Observer> observers = new ArrayList<>();

        Product(String name) { this.name = name; }

        public void subscribe(Observer o) { observers.add(o); }
        public void unsubscribe(Observer o) { observers.remove(o); }

        public void setSoldOut() {
            System.out.println("[" + name + "] 품절 처리됨!");
            for (Observer o : observers) {
                o.update("[" + name + "] 이(가) 품절되었습니다.");
            }
        }
    }
}
