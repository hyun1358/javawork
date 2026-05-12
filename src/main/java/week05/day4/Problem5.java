package week05.day4;

/**
 * [문제 5 재도전] 싱글톤(Singleton) 패턴 구현하기
 * <p>
 * [가이드]:
 * 싱글톤 패턴은 "객체를 딱 하나만 생성하여 어디서든 공유"하는 패턴입니다.
 * <p>
 * [재도전 힌트]:
 * 1. 생성자 앞에 'private'을 붙여서 외부에서 'new'를 못하게 막으세요.
 * 2. 자기 자신 타입의 static 변수를 하나 만드세요 (예: private static Singleton instance).
 * 3. 외부에서 이 변수를 가져갈 수 있는 public static 메서드를 만드세요 (예: getInstance()).
 */
public class Problem5 {
    public static void main(String[] args) {
        // 중첩 클래스로 정의된 Singleton을 사용합니다.
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        System.out.println("s1: " + s1);
        System.out.println("s2: " + s2);

        if (s1 != null && s1 == s2) {
            System.out.println("성공: s1과 s2는 동일한 싱글톤 인스턴스입니다.");
        } else {
            System.out.println("실패: 인스턴스가 다르거나 null입니다.");
        }
    }

    // Singleton 클래스를 Problem5 내부로 옮겨 충돌을 방지합니다.
    static class Singleton {
        // 싱글톤 클래스 객체를 담을 인스턴스 변수
        private static final Singleton INSTANCE = new Singleton();

        // 생성자를 private로 선언 (외부에서 new 사용 X)
        private Singleton() {
        }

        public static Singleton getInstance() {
            return INSTANCE;
        }
    }
}
