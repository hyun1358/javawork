package week11.day2;

import java.util.*;

// 옵저버(Observer) 패턴을 활용한 이벤트 알림 예제입니다.
public class Answer3 {
    // 메인 메서드
    public static void main(String[] args) {
        Product p = new Product();
        // 옵저버(구독자)를 등록합니다. 람다식을 사용하여 간단하게 구현했습니다.
        p.addObserver(msg -> System.out.println("고객님, " + msg));
        // 상품 상태 변경(품절)을 발생시켜 등록된 모든 옵저버에게 알립니다.
        p.setSoldOut();
    }

    // 옵저버(구독자)가 구현해야 할 인터페이스
    interface ProdObserver {
        void update(String m); // 이벤트 발생 시 호출될 콜백 메서드
    }

    // 이벤트를 발생시키는 발행자(Subject) 클래스
    static class Product {
        // 등록된 옵저버들을 관리하는 리스트
        List<ProdObserver> obs = new ArrayList<>();
        
        // 새로운 옵저버를 등록(구독)하는 메서드
        void addObserver(ProdObserver o) {
            obs.add(o);
        }
        
        // 상태 변경(품절) 시 등록된 모든 옵저버에게 변경 사실을 통보(알림)하는 메서드
        void setSoldOut() {
            for (ProdObserver o : obs) o.update("상품 품절 알림!");
        }
    }
}
