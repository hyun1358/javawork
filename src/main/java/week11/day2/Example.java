package week11.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [학습 예제] Week 11 Day 2 — 전략 패턴 & 옵저버 패턴 완전 정복
 *
 * ★ 이 파일은 오늘 풀어야 할 연습 문제 5개의 핵심 기술을 모두 담고 있습니다.
 *
 * [문제별 학습 목표]
 * - 문제 1: 전략 패턴 — Sorter 에 오름차순/내림차순 전략 주입
 * - 문제 2: 전략 패턴 — 카카오페이/네이버페이 결제 전략 교체
 * - 문제 3: 옵저버 패턴 — Product 품절 시 구독 User 알림
 * - 문제 4: 옵저버 패턴 — unsubscribe(구독 취소) 기능 추가
 * - 문제 5: 람다로 전략 주입 — 별도 클래스 없이 람다식으로 전략 구현
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 1 & 2 & 5] 전략 패턴 (Strategy Pattern)
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - 알고리즘(행동)을 인터페이스로 추상화하여, 런타임에 교체 가능하게 설계
 *  - Context 클래스는 Strategy 인터페이스만 알고, 구체 구현은 모름
 *  - 람다식으로도 주입 가능 (함수형 인터페이스면 OK)
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 3 & 4] 옵저버 패턴 (Observer Pattern)
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - Subject(발행자)의 상태 변화 → 구독한 Observer 전체에 알림(notify)
 *  - subscribe(구독 등록): 옵저버 리스트에 추가
 *  - unsubscribe(구독 취소): 옵저버 리스트에서 제거
 */
public class Example {
    public static void main(String[] args) {

        // ─────────────────────────────────────────────
        // Lab 1: 전략 패턴 — 정렬 전략 (→ 문제 1 참고)
        // ─────────────────────────────────────────────
        System.out.println("=== Lab 1: 전략 패턴 — Sorter ===");
        int[] data = {5, 2, 8, 1, 9, 3};

        Sorter sorter = new Sorter();

        // 오름차순 전략 주입
        sorter.setStrategy(new AscendingSort());
        sorter.sort(data);
        System.out.println("오름차순: " + Arrays.toString(data));

        // 내림차순 전략으로 교체
        sorter.setStrategy(new DescendingSort());
        sorter.sort(data);
        System.out.println("내림차순: " + Arrays.toString(data));

        // ─────────────────────────────────────────────
        // Lab 2: 전략 패턴 — 결제 전략 (→ 문제 2 참고)
        // ─────────────────────────────────────────────
        System.out.println("\n=== Lab 2: 전략 패턴 — 결제 ===");
        PaymentContext payment = new PaymentContext();

        payment.setStrategy(new KakaoPay()); // 카카오페이로 설정
        payment.pay(15000);

        payment.setStrategy(new NaverPay()); // 네이버페이로 교체
        payment.pay(30000);

        // ─────────────────────────────────────────────
        // Lab 3: 옵저버 패턴 — 품절 알림 (→ 문제 3 참고)
        // ─────────────────────────────────────────────
        System.out.println("\n=== Lab 3: 옵저버 패턴 — 품절 알림 ===");
        Product product = new Product("MacBook Pro");

        product.subscribe(new User("김철수"));
        product.subscribe(new User("이영희"));
        product.subscribe(new User("박민준"));

        product.setSoldOut(); // 품절 → 구독자 전체에 알림

        // ─────────────────────────────────────────────
        // Lab 4: 옵저버 — unsubscribe 기능 (→ 문제 4 참고)
        // ─────────────────────────────────────────────
        System.out.println("\n=== Lab 4: 옵저버 패턴 — 구독 취소 ===");
        YoutubeChannel channel = new YoutubeChannel("자바 강의 채널");
        Subscriber s1 = new Subscriber("홍길동");
        Subscriber s2 = new Subscriber("이순신");
        Subscriber s3 = new Subscriber("강감찬");

        channel.subscribe(s1);
        channel.subscribe(s2);
        channel.subscribe(s3);

        channel.uploadVideo("전략 패턴 완전 정복!");
        System.out.println("--- 이순신 구독 취소 ---");
        channel.unsubscribe(s2); // 구독 취소
        channel.uploadVideo("옵저버 패턴 심화!");
        // 이순신은 두 번째 영상 알림을 받지 않음

        // ─────────────────────────────────────────────
        // Lab 5: 람다로 전략 주입 (→ 문제 5 참고)
        // ─────────────────────────────────────────────
        System.out.println("\n=== Lab 5: 람다로 전략 주입 ===");
        PaymentContext lambdaPayment = new PaymentContext();

        // 별도 클래스 없이 람다식으로 전략 주입
        lambdaPayment.setStrategy(amount -> System.out.println("삼성페이로 " + amount + "원 결제"));
        lambdaPayment.pay(50000);

        lambdaPayment.setStrategy(amount -> System.out.println("애플페이로 " + amount + "원 결제"));
        lambdaPayment.pay(12000);
    }
}

// ─── 전략 패턴: 정렬 ───────────────────────────────────
interface SortStrategy {
    void sort(int[] arr);
}

class AscendingSort implements SortStrategy {
    public void sort(int[] arr) { Arrays.sort(arr); }
}

class DescendingSort implements SortStrategy {
    public void sort(int[] arr) {
        Arrays.sort(arr);
        // 배열 뒤집기
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            int tmp = arr[i]; arr[i] = arr[j]; arr[j] = tmp;
        }
    }
}

class Sorter {
    private SortStrategy strategy;

    public void setStrategy(SortStrategy s) { this.strategy = s; }

    public void sort(int[] arr) { strategy.sort(arr); }
}

// ─── 전략 패턴: 결제 ───────────────────────────────────
interface PaymentStrategy {
    void pay(int amount);
}

class KakaoPay implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("카카오페이로 " + amount + "원 결제");
    }
}

class NaverPay implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("네이버페이로 " + amount + "원 결제");
    }
}

class PaymentContext {
    private PaymentStrategy strategy;

    public void setStrategy(PaymentStrategy s) { this.strategy = s; }

    public void pay(int amount) { strategy.pay(amount); }
}

// ─── 옵저버 패턴: 품절 알림 ────────────────────────────
interface Observer {
    void update(String message);
}

class User implements Observer {
    private String name;
    User(String name) { this.name = name; }

    public void update(String message) {
        System.out.println(name + "님께 알림: " + message);
    }
}

class Product {
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

// ─── 옵저버 패턴: 유튜브 채널 + unsubscribe ────────────
interface ChannelObserver {
    void notify(String title);
}

class Subscriber implements ChannelObserver {
    String name;
    Subscriber(String name) { this.name = name; }

    public void notify(String title) {
        System.out.println(name + "님: '" + title + "' 새 영상 알림!");
    }
}

class YoutubeChannel {
    private String channelName;
    private List<ChannelObserver> subs = new ArrayList<>();

    YoutubeChannel(String name) { this.channelName = name; }

    public void subscribe(ChannelObserver o) { subs.add(o); }

    // unsubscribe: 옵저버 리스트에서 제거 (→ 문제 4 핵심)
    public void unsubscribe(ChannelObserver o) { subs.remove(o); }

    public void uploadVideo(String title) {
        System.out.println("[" + channelName + "] '" + title + "' 업로드됨");
        for (ChannelObserver o : subs) o.notify(title);
    }
}
