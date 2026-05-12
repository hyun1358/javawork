package week06.day2;

public class Answer4 {
    public static void main(String[] args) {
        SmartPhone p = new SmartPhone();
        p.call();
    }
}

class Phone {
    void call() {
        System.out.println("전화 걸기");
    }
}

class SmartPhone extends Phone {
    @Override
    void call() {
        super.call();
        System.out.println("인터넷 검색도 가능");
    }
}
