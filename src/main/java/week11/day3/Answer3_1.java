package week11.day3;

// [보충 문제 3_1 정답] Coffee 데코레이터 패턴 예시 답안
public class Answer3_1 {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        System.out.println(coffee.getDescription() + " / 가격: " + coffee.getCost() + "원");

        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.getDescription() + " / 가격: " + coffee.getCost() + "원");

        coffee = new SyrupDecorator(coffee);
        System.out.println(coffee.getDescription() + " / 가격: " + coffee.getCost() + "원");
    }

    interface Coffee {
        String getDescription();
        int getCost();
    }

    static class SimpleCoffee implements Coffee {
        @Override
        public String getDescription() {
            return "에스프레소";
        }

        @Override
        public int getCost() {
            return 3000;
        }
    }

    abstract static class CoffeeDecorator implements Coffee {
        protected Coffee coffee;

        public CoffeeDecorator(Coffee coffee) {
            this.coffee = coffee;
        }
    }

    static class MilkDecorator extends CoffeeDecorator {
        public MilkDecorator(Coffee coffee) {
            super(coffee);
        }

        @Override
        public String getDescription() {
            return coffee.getDescription() + " + 우유";
        }

        @Override
        public int getCost() {
            return coffee.getCost() + 500;
        }
    }

    static class SyrupDecorator extends CoffeeDecorator {
        public SyrupDecorator(Coffee coffee) {
            super(coffee);
        }

        @Override
        public String getDescription() {
            return coffee.getDescription() + " + 시럽";
        }

        @Override
        public int getCost() {
            return coffee.getCost() + 300;
        }
    }
}
