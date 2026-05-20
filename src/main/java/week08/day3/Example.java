package week08.day3;

import java.util.ArrayList;
import java.util.Collections;

/**
 * [학습 예제] Week 08 Day 3 — Comparable 인터페이스를 이용한 객체 정렬
 * 
 * 기본 데이터 타입(Integer, String 등)은 자바가 정렬 기준을 알고 있지만,
 * 우리가 직접 만든 클래스(Score, Student 등)는 무엇을 기준으로 정렬해야 할지 모릅니다.
 * 
 * 이때 사용하는 것이 바로 'Comparable' 인터페이스입니다.
 * 
 * 1. Comparable 인터페이스 구현:
 *    - 클래스 선언부에 'implements Comparable<클래스명>'을 추가합니다.
 *    - 'compareTo(T o)' 메서드를 오버라이딩하여 정렬 로직을 작성합니다.
 * 
 * 2. compareTo(T o)의 반환값 규칙:
 *    - 음수 반환: 현재 객체(this)가 대상 객체(o)보다 작음 (this가 앞에 옴)
 *    - 0 반환: 두 객체가 같음
 *    - 양수 반환: 현재 객체(this)가 대상 객체(o)보다 큼 (o가 앞에 옴)
 * 
 *    팁: (this.값 - o.값)을 반환하면 오름차순 정렬이 됩니다.
 */
public class Example {
    public static void main(String[] args) {
        ArrayList<Score> list = new ArrayList<>();
        list.add(new Score("홍길동", 80));
        list.add(new Score("이순신", 95));
        list.add(new Score("강감찬", 70));

        // Collections.sort()는 Score 클래스 내부의 compareTo()를 보고 정렬을 수행합니다.
        Collections.sort(list); 

        System.out.println("=== 점수 오름차순 정렬 결과 ===");
        for (Score s : list) {
            System.out.print(s.name + ": " + s.val + "점 ");
        }
    }
}

/**
 * Comparable을 구현하여 정렬 기준이 생긴 클래스
 */
class Score implements Comparable<Score> {
    String name;
    int val;

    Score(String n, int v) {
        this.name = n;
        this.val = v;
    }

    @Override
    public int compareTo(Score o) {
        // [오름차순 정렬 공식] : 나(this) - 상대방(o)
        // 결과가 음수면 '나'를 앞으로, 양수면 '나'를 뒤로 보냅니다.
        return this.val - o.val; 

        // 만약 내림차순(큰 점수가 앞)으로 하고 싶다면?
        // return o.val - this.val; (상대방 - 나)
    }
}
