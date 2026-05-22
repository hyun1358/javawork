package week11.day3;

/**
 * [학습 예제] Week 11 Day 3 — 데코레이터 패턴 및 StringBuilder 빌더 패턴
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Lab 1: 커피에 옵션 계속 추가하기 ===");

        Coffee c = new BasicCoffee(); // 기본 아메리카노 (3000원)
        System.out.println(c.getDesc() + " : " + c.getCost());

        c = new MilkDecorator(c); // 우유 추가 (+500원)
        System.out.println(c.getDesc() + " : " + c.getCost());

        c = new SyrupDecorator(c); // 시럽 추가 (+300원)
        System.out.println(c.getDesc() + " : " + c.getCost());

        System.out.println("\n=== Lab 2: StringBuilder를 활용한 Fluid 빌더 구현 ===");
        SqlBuilder builder = new SqlBuilder();
        String query = builder.select("id, name")
                              .from("users")
                              .build();
        System.out.println("생성된 SQL 쿼리: " + query);
    }

    // 빌더 패턴과 StringBuilder 예제
    static class SqlBuilder {
        private StringBuilder sb = new StringBuilder();
        
        public SqlBuilder select(String columns) {
            sb.append("SELECT ").append(columns).append(" ");
            return this;
        }
        
        public SqlBuilder from(String table) {
            sb.append("FROM ").append(table).append(" ");
            return this;
        }
        
        public String build() {
            return sb.toString().trim();
        }
    }
}

interface Coffee {
    String getDesc();

    int getCost();
}

class BasicCoffee implements Coffee {
    public String getDesc() {
        return "아메리카노";
    }

    public int getCost() {
        return 3000;
    }
}

abstract class CoffeeDecorator implements Coffee {
    Coffee coffee; // 래핑할 대상

    CoffeeDecorator(Coffee c) {
        coffee = c;
    }
}

class MilkDecorator extends CoffeeDecorator {
    MilkDecorator(Coffee c) {
        super(c);
    }

    public String getDesc() {
        return coffee.getDesc() + " + 우유";
    }

    public int getCost() {
        return coffee.getCost() + 500;
    }
}

class SyrupDecorator extends CoffeeDecorator {
    SyrupDecorator(Coffee c) {
        super(c);
    }

    public String getDesc() {
        return coffee.getDesc() + " + 시럽";
    }

    public int getCost() {
        return coffee.getCost() + 300;
    }
}
