package week11.day2;

/**
 * [예습 파일] Week 11 Day 2 — 전략 패턴 (Strategy Pattern)
 * 
 * [핵심 개념: 알고리즘의 유연한 교체 - OCP 정수]
 * 1. 전략 패턴 (Strategy Pattern):
 *    - 객체의 유사한 행동 양식들을 각각 독립적인 전략 인터페이스 구현 클래스들(Strategy A, B, C)로 완전히 캡슐화해 둡니다.
 *    - 해당 행동을 수행하는 주체 객체(Context)는 구체적인 전략 클래스를 하드코딩으로 품지 않고 인터페이스 참조 타입만 필드로 갖고 있다가, 필요시 런타임에 동적으로 알맞은 전략 구현체를 끼워 넣어 동작을 바꾸는 상향식 다형성 패턴입니다.
 *    - "기존 코드는 수정하지 않고 기능만 유연하게 확장한다"는 객체지향 5대 원칙인 OCP(Open-Closed Principle)를 가장 충실히 실천하는 실무 핵심 디자인 패턴입니다.
 */
public class Preview {
    public static void main(String[] args) {
        // 행위(전략)를 인터페이스로 빼고 조립하는 방식
        Player p = new Player();
        p.setWeapon(new Sword()); // 칼 장착
        p.attack();

        p.setWeapon(new Bow()); // 활 장착 (전략 교체)
        p.attack();
    }
}

interface Weapon {
    void use();
}

class Sword implements Weapon {
    public void use() {
        System.out.println("칼로 벱니다!");
    }
}

class Bow implements Weapon {
    public void use() {
        System.out.println("활을 쏩니다!");
    }
}

class Player {
    Weapon w;

    void setWeapon(Weapon w) {
        this.w = w;
    }

    void attack() {
        if (w != null) w.use();
        else System.out.println("맨손 공격!");
    }
}
