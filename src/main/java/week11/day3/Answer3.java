package week11.day3;

public class Answer3 {
    public static void main(String[] args) {
        Pizza p = new BasicPizza();
        p = new Cheese(p);
        System.out.println(p.getDesc() + " : " + p.getCost());
    }

    interface Pizza {
        String getDesc();
        int getCost();
    }

    static class BasicPizza implements Pizza {
        public String getDesc() {
            return "피자 도우";
        }
        public int getCost() {
            return 5000;
        }
    }

    static class Cheese implements Pizza {
        Pizza p;
        Cheese(Pizza p) {
            this.p = p;
        }
        public String getDesc() {
            return p.getDesc() + " + 치즈";
        }
        public int getCost() {
            return p.getCost() + 1000;
        }
    }
}
