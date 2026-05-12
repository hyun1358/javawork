package week11.day2;

/**
 * [예습 파일] Week 11 Day 2 — 전략 패턴 (Strategy Pattern)
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
