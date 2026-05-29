package week05.day4;

public class Answer5 {
    public static void main(String[] args) {
        // 싱글톤 패턴으로 구현된 클래스에서 getInstance()를 호출해 객체를 가져옵니다.
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        
        // 두 참조 변수가 가리키는 객체의 메모리 주소가 동일한지(즉, 같은 객체인지) 비교하여 true를 출력합니다.
        System.out.println(s1 == s2); // true
    }
}

// [클래스 설명] 프로그램 내에서 오직 하나의 객체 인스턴스만 생성하여 공유하는 싱글톤(Singleton) 패턴 예제입니다.
class Singleton {
    // [필드 설명] 클래스가 로드될 때 자기 자신의 유일한 객체를 미리 생성해 private static 변수에 저장합니다.
    private static Singleton instance = new Singleton();

    // [생성자 설명] 기본 생성자를 private으로 선언하여 외부에서 new 키워드를 사용해 객체를 생성하지 못하게 막습니다.
    private Singleton() {
    } // 밖에서 new 못하게 막음

    // [메서드 설명] 외부에서 이 클래스의 유일한 객체를 얻을 수 있도록 제공되는 public static 메서드입니다.
    public static Singleton getInstance() {
        return instance; // 항상 동일한 instance를 반환합니다.
    }
}
