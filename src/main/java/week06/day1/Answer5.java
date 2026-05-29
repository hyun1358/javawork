package week06.day1;

public class Answer5 {
    public static void main(String[] args) {
        // 다단계 상속의 최하위 자식인 ClassC 객체를 생성합니다.
        ClassC c = new ClassC();
        
        // 조부모 클래스인 ClassA의 메서드를 호출할 수 있습니다.
        c.methodA();
        // 부모 클래스인 ClassB의 메서드를 호출할 수 있습니다.
        c.methodB();
        // 자기 자신의 메서드를 호출합니다.
        c.methodC();
    }
}

// [클래스 설명] 최상위 부모 클래스로, methodA를 제공합니다.
class ClassA {
    void methodA() {
        System.out.println("A");
    }
}

// [클래스 설명] ClassA를 상속받는 중간 부모 클래스로, methodA를 물려받고 methodB를 추가합니다.
class ClassB extends ClassA {
    void methodB() {
        System.out.println("B");
    }
}

// [클래스 설명] ClassB를 상속받는 최하위 자식 클래스로, methodA, methodB를 모두 물려받고 methodC를 추가합니다.
class ClassC extends ClassB {
    void methodC() {
        System.out.println("C");
    }
}
