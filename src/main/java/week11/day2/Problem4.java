package week11.day2;

import java.util.ArrayList;
import java.util.List;

/**
 * [연습 문제 4] 옵저버 등록 해제
 * 문제: Example의 유튜브 채널에 unsubscribe(구독 취소) 메서드를 추가하고 테스트하세요.
 */
public class Problem4 {
    public static void main(String[] args)
    {
        // TODO
        YoubeChannel y = new YoubeChannel("자바의 정석","김작가");
        Subscribe s1 = new Subscribe("홍길동");
        Subscribe s2 = new Subscribe("이길동");
        Subscribe s3 = new Subscribe("삼길동");
        Subscribe s4 = new Subscribe("사길동");

        y.addSubscribe(s1);
        y.addSubscribe(s2);
        y.addSubscribe(s3);
        y.addSubscribe(s4);

        y.notification();

        y.removeSubscribe(s2);

        y.setTitle("자바스크립트의 정석");
        y.notification();

    }

    interface ChannelObserver
    {
        void notify(String message);
    }

    static class Subscribe implements ChannelObserver
    {
        String name;

        Subscribe(String name) { this.name = name;}

        @Override
        public void notify(String message)
        {
            System.out.println(name + "님 : " + message);
        }
    }

    static class YoubeChannel
    {
        ChannelObserver channelObserver;
        List<Subscribe> subscribes = new ArrayList<>();
        String title;
        String name;

        YoubeChannel(String title, String name) {this.title = title; this.name = name;}

        void setTitle(String title) { this.title = title;}

        void setChannelObserver(ChannelObserver c) { this.channelObserver=c;}

        void addSubscribe(Subscribe s) { subscribes.add(s); }

        void removeSubscribe( Subscribe s) { subscribes.remove(s); System.out.println(s.name+"님이 구독을 취소 하였습니다.");}

        public void notification()
        {
            String message = name+"님의 채널에서 ["+ title+"]방송을 시작합니다.";
            for(Subscribe s : subscribes)
            {
                s.notify(message);
            }
        }
    }
}
