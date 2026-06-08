package week11.day2;

import java.util.ArrayList;
import java.util.List;

/**
 * [학습 예제 4] Week 11 Day 2 — 전략 패턴 & 옵저버 패턴 완전 정복
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 4] 옵저버 패턴 (Observer Pattern)
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - Subject(발행자)의 상태 변화 → 구독한 Observer 전체에 알림(notify)
 *  - unsubscribe(구독 취소): 옵저버 리스트에서 제거
 *
 * [문제별 학습 목표]
 * - 문제 4: 옵저버 패턴 — unsubscribe(구독 취소) 기능 추가
 */
public class Example4 {
    public static void main(String[] args) {
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
    }

    // ─── 옵저버 패턴: 유튜브 채널 + unsubscribe ────────────
    interface ChannelObserver {
        void notify(String title);
    }

    static class Subscriber implements ChannelObserver {
        String name;
        Subscriber(String name) { this.name = name; }

        public void notify(String title) {
            System.out.println(name + "님: '" + title + "' 새 영상 알림!");
        }
    }

    static class YoutubeChannel {
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
}
