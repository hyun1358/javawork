package week11.day2;

import java.util.ArrayList;
import java.util.List;

/**
 * [학습 예제] Week 11 Day 2 — 옵저버 패턴 (Observer Pattern)
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Lab: 유튜브 구독 알림 시스템 ===");
        YoutubeChannel channel = new YoutubeChannel();

        channel.subscribe(new Subscriber("홍길동"));
        channel.subscribe(new Subscriber("이순신"));

        channel.uploadVideo("자바 디자인 패턴 완벽 가이드!");
        // 구독자들에게 일제히 알림이 갑니다.
    }
}

interface Observer {
    void notify(String msg);
}

class Subscriber implements Observer {
    String name;

    Subscriber(String n) {
        name = n;
    }

    public void notify(String msg) {
        System.out.println(name + "님 알림 도착: " + msg);
    }
}

class YoutubeChannel {
    List<Observer> subs = new ArrayList<>();

    void subscribe(Observer o) {
        subs.add(o);
    }

    void uploadVideo(String title) {
        System.out.println("채널: '" + title + "' 업로드 됨.");
        for (Observer o : subs) o.notify(title);
    }
}
