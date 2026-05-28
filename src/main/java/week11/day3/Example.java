package week11.day3;

/**
 * [학습 예제] Week 11 Day 3 — 데코레이터 패턴 및 StringBuilder 빌더
 * 
 * [학습 핵심 이론: 덧붙이는 동적 장식과 문자열 버퍼]
 * 1. 데코레이터 패턴 (Decorator Pattern):
 *    - 기존 클래스 원본 코드를 상속으로 뜯어고치거나 훼손하지 않으면서, 런타임에 추가적인 매력적인 기능 장식들(예: 커피 -> 우유 데코레이터 추가 -> 샷 추가)을 겉에 겹겹이 포장하듯 덧씌우는 유연한 패턴입니다.
 * 
 * 2. StringBuilder의 가공할 속도:
 *    - 불변 String의 잦은 힙 파생 연산 낭비를 해결하기 위해, 내부에 가변 char[] 버퍼를 두고 `.append()` 메서드로 문자열 메모리 낭비 없이 고속으로 가공한 뒤 마지막에만 `.toString()`으로 전환해 수확하는 고마운 유틸리티 클래스입니다.
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
