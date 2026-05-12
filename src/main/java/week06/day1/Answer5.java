package week06.day1;

public class Answer5 {
    public static void main(String[] args) {
        ClassC c = new ClassC();
        c.methodA();
        c.methodB();
        c.methodC();
    }
}

class ClassA {
    void methodA() {
        System.out.println("A");
    }
}

class ClassB extends ClassA {
    void methodB() {
        System.out.println("B");
    }
}

class ClassC extends ClassB {
    void methodC() {
        System.out.println("C");
    }
}
