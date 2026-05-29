package week11.day3;

// 데코레이터(Decorator) 패턴을 사용하여 런타임에 동적으로 객체의 기능을 확장하는 예제입니다.
public class Answer3 {
    // 메인 메서드
    public static void main(String[] args) {
        // 기본 피자(도우) 객체를 생성합니다.
        Pizza p = new BasicPizza();
        // 기본 피자를 치즈 데코레이터로 감싸서(Decorate) 기능을 확장합니다.
        p = new Cheese(p);
        // 치즈가 추가된 피자의 설명과 가격을 출력합니다.
        System.out.println(p.getDesc() + " : " + p.getCost());
    }

    // 피자의 기본 기능을 정의하는 인터페이스
    interface Pizza {
        String getDesc(); // 설명을 반환하는 메서드
        int getCost();    // 가격을 반환하는 메서드
    }

    // 장식이 되지 않은 기본 피자 클래스
    static class BasicPizza implements Pizza {
        @Override
        public String getDesc() {
            return "피자 도우";
        }
        @Override
        public int getCost() {
            return 5000;
        }
    }

    // 기존 피자에 치즈 토핑을 추가하는 데코레이터 클래스
    static class Cheese implements Pizza {
        Pizza p; // 자신이 감싸고 있는 원래의 피자 객체

        // 생성자를 통해 꾸며줄(장식할) 피자 객체를 주입받습니다.
        Cheese(Pizza p) {
            this.p = p;
        }
        
        // 기존 피자의 설명에 " + 치즈"를 덧붙여 반환합니다.
        @Override
        public String getDesc() {
            return p.getDesc() + " + 치즈";
        }
        
        // 기존 피자의 가격에 치즈 가격(1000)을 더해서 반환합니다.
        @Override
        public int getCost() {
            return p.getCost() + 1000;
        }
    }
}
