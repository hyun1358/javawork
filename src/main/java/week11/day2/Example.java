package week11.day2;

import java.util.ArrayList;
import java.util.List;

/**
 * [학습 예제] Week 11 Day 2 — 옵저버 패턴 (Observer Pattern)
 * 
 * [학습 핵심 이론: 일대다 실시간 이벤트 알림 구독]
 * 1. 옵저버 패턴 (Observer Pattern):
 *    - 상태 변경을 감지하고 전파하는 주체인 Subject(발행자)와, 이 변화 소식을 즉시 수신 대기하는 다수의 Observer(구독자들) 간의 느슨한 관계를 설계하는 패턴입니다.
 *    - Subject의 중요한 데이터 상태가 런타임에 바뀌면, 구독자 리스트(ArrayList)를 순회하며 사전에 약속된 `.update()` 알림 메서드를 일괄 순차 호출하여 즉시 동기화해 줍니다.
 *    - 유튜브 채널 구독 알림, 트위터 팔로우 피드 전송, UI 컴포넌트 이벤트 리스너 등 현대 분산 아키텍처의 필수적인 기초 토대입니다.
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
