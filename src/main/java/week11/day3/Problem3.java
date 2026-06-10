package week11.day3;

/**
 * [연습 문제 3] 피자 데코레이터
 * 문제: BasicPizza 에 치즈(Cheese)와 페퍼로니(Pepperoni)를 얹어 가격을 올리는 데코레이터를 구현하세요.
 */
public class Problem3 {
    public static void main(String[] args)
    {
        // TODO
        Pizza pizza = new BasePizza();
        System.out.println(pizza.Description() + " / " + "가겨: " + pizza.getPrice());

        pizza = new CheeseDecorator(pizza);
        System.out.println(pizza.Description() + " / " + "가겨: " + pizza.getPrice());

        pizza = new PepperoniDecorator(pizza);
        System.out.println(pizza.Description() + " / " + "가겨: " + pizza.getPrice());
    }

    interface Pizza
    {
        String Description();
        int getPrice();
    }

    static class BasePizza implements Pizza
    {
        @Override
        public String Description()
        {
            return "기본 피자";
        }
        @Override
        public int getPrice()
        {
            return 8000;
        }
    }

    abstract static class PizzaDecorator implements Pizza
    {
        Pizza pizza;
        PizzaDecorator(Pizza p) { this.pizza=p; }
    }

    static class CheeseDecorator extends PizzaDecorator
    {
        CheeseDecorator(Pizza p) { super(p); }

        @Override
        public String Description()
        {
            return pizza.Description()+" + 치즈";
        }
        @Override
        public int getPrice()
        {
            return pizza.getPrice()+1500;
        }
    }

    static class PepperoniDecorator extends PizzaDecorator
    {
        PepperoniDecorator(Pizza p) {super(p);}
        @Override
        public String Description()
        {
            return pizza.Description() + " + 페퍼로니";
        }

        @Override
        public int getPrice()
        {
            return pizza.getPrice() + 1500;
        }
    }
}
