package week11.day3;

/**
 * [보충 문제 3_1] Coffee 데코레이터
 * 문제: 기본 에스프레소(SimpleCoffee)에 우유(MilkDecorator)와 시럽(SyrupDecorator)을 
 *      겹겹이 감싸서 메뉴 이름과 최종 가격을 계산하는 데코레이터 패턴을 완성하세요.
 * 
 * - 기본 에스프레소(SimpleCoffee): 가격 3000원, 설명 "에스프레소"
 * - 우유 추가(MilkDecorator): 가격 +500원, 설명에 " + 우유" 추가
 * - 시럽 추가(SyrupDecorator): 가격 +300원, 설명에 " + 시럽" 추가
 */
public class Problem3_1 {
    public static void main(String[] args)
    {
        // TODO: 아래 코드가 주석 해제되었을 때 정상 작동하도록 구조를 완성하세요.

        Coffee coffee = new SimpleCoffee();
        System.out.println(coffee.getDescription() + " / 가격: " + coffee.getCost() + "원");

        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.getDescription() + " / 가격: " + coffee.getCost() + "원");

        coffee = new SyrupDecorator(coffee);
        System.out.println(coffee.getDescription() + " / 가격: " + coffee.getCost() + "원");

    }

    interface Coffee
    {
        String getDescription();
        int getCost();
    }

    // 기본 커피 클래스 구현
    // TODO: SimpleCoffee 구현 (getDescription: "에스프레소", getCost: 3000)
    static class SimpleCoffee implements Coffee
    {
        @Override
        public String getDescription()
        {
            return "에스프레소";
        }

        @Override
        public int getCost()
        {
            return 3000;
        }
    }
    // 추상 데코레이터 클래스 구현
    // TODO: CoffeeDecorator 구현
    abstract static class CoffeeDecorator implements Coffee
    {
        Coffee coffee;
        CoffeeDecorator(Coffee c) {this.coffee=c;}
    }
    // 우유 장식자 클래스 구현
    // TODO: MilkDecorator 구현 (가격 +500, 설명 " + 우유" 추가)
    static class MilkDecorator extends CoffeeDecorator
    {
        MilkDecorator(Coffee c) {super(c);}

        @Override
        public String getDescription()
        {
            return coffee.getDescription() + " + 우유";
        }

        @Override
        public int getCost()
        {
            return coffee.getCost() + 500;
        }
    }
    // 시럽 장식자 클래스 구현
    // TODO: SyrupDecorator 구현 (가격 +300, 설명 " + 시럽" 추가)
    static class SyrupDecorator extends CoffeeDecorator

    {
        SyrupDecorator(Coffee c) {super(c);}

        @Override
        public String getDescription()
        {
            return coffee.getDescription() + " + 시럽";
        }

        @Override
        public int getCost()
        {
            return coffee.getCost() + 300;
        }
    }
}
