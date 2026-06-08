package week02.day6;

import java.util.Scanner;

/**
 * [종합 미니 프로젝트 정답 - 신규] Week 02 Day 6
 * 「 카페 키오스크 및 매출 관리 시스템 」
 */
public class MiniProjectAnswer_New {
    // Day 5: static final 상수
    public static final String STORE_NAME = "자바 자바 카페";
    
    // Day 5: 모든 주문이 공유하는 static 변수
    private static int totalSales = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Day 3: 객체 생성
        Product[] menu = new Product[3];
        
        // Day 2: 가변인자 메서드를 이용한 상품 일괄 등록
        addProducts(menu, 
            new Product("아메리카노", 3000),
            new Product("카페라떼", 3500),
            new Product("바닐라라떼", 4000)
        );

        boolean running = true;
        while (running) {
            System.out.printf("\n=== [%s] 키오스크 ===\n", STORE_NAME);
            
            // Day 1: 별도 메서드 분리를 통한 메뉴 출력
            displayMenu(menu);
            
            System.out.println("4. 영업 종료 및 총 매출 확인");
            System.out.print("주문할 메뉴 번호 선택: ");
            int menuChoice = sc.nextInt();
            
            if (menuChoice == 4) {
                System.out.println("\n영업을 종료합니다.");
                // Day 5: static 변수 출력 및 static 메서드 호출
                System.out.printf("오늘의 총 누적 매출액: %d원\n", getTotalSales());
                running = false;
                continue;
            }
            
            if (menuChoice < 1 || menuChoice > 3) {
                System.out.println("잘못된 메뉴 번호입니다. 다시 선택해 주세요.");
                continue;
            }
            
            System.out.print("수량 입력: ");
            int quantity = sc.nextInt();
            if (quantity <= 0) {
                System.out.println("수량은 1개 이상이어야 합니다.");
                continue;
            }
            
            // 선택된 상품 정보 가져오기
            Product selectedProduct = menu[menuChoice - 1];
            int orderTotal = selectedProduct.getPrice() * quantity;
            System.out.printf("\n주문 상품: %s, 수량: %d개\n", selectedProduct.getName(), quantity);
            System.out.printf("할인 전 금액: %d원\n", orderTotal);
            
            // 할인 적용
            System.out.println("할인 방식을 선택하세요 (1: 10% 멤버십 할인, 2: 1000원 쿠폰 할인, 3: 할인 없음)");
            System.out.print("선택> ");
            int discountChoice = sc.nextInt();
            
            int finalPayment = orderTotal;
            if (discountChoice == 1) {
                // Day 2: 오버로딩 메서드 호출 (비율 할인)
                int discountAmount = (int) calculateDiscount(orderTotal, 0.1);
                finalPayment -= discountAmount;
                System.out.printf("멤버십 10%% 적용 (-%d원)\n", discountAmount);
            } else if (discountChoice == 2) {
                // Day 2: 오버로딩 메서드 호출 (고정 금액 할인)
                int discountAmount = calculateDiscount(orderTotal, 1000);
                finalPayment -= discountAmount;
                System.out.printf("쿠폰 1000원 적용 (-%d원)\n", discountAmount);
            } else {
                System.out.println("할인이 적용되지 않았습니다.");
            }
            
            System.out.printf("최종 결제 금액: %d원\n", finalPayment);
            
            // 누적 매출에 더하기
            totalSales += finalPayment;
            System.out.println("결제가 완료되었습니다!");
        }
        
        sc.close();
    }
    
    // Day 1: 메뉴판 출력 메서드
    private static void displayMenu(Product[] menu) {
        System.out.println("-------------------------");
        for (int i = 0; i < menu.length; i++) {
            if (menu[i] != null) {
                System.out.printf("%d. %s - %d원\n", i + 1, menu[i].getName(), menu[i].getPrice());
            }
        }
        System.out.println("-------------------------");
    }

    // Day 2: 가변 인자(varargs) 사용 메서드
    public static void addProducts(Product[] menuList, Product... products) {
        for (int i = 0; i < menuList.length && i < products.length; i++) {
            menuList[i] = products[i];
        }
    }

    // Day 2: 메서드 오버로딩 1 (비율 할인)
    public static double calculateDiscount(int total, double rate) {
        return total * rate;
    }

    // Day 2: 메서드 오버로딩 2 (정액 할인)
    public static int calculateDiscount(int total, int amount) {
        if (total < amount) {
            return total; // 총액보다 할인액이 크면 총액만큼만 할인
        }
        return amount;
    }
    
    // Day 5: static 메서드
    public static int getTotalSales() {
        return totalSales;
    }
}

// Day 3: 클래스 및 객체 설계
class Product {
    // Day 4: 접근제어자와 캡슐화
    private String name;
    private int price;

    public Product(String name, int price) {
        this.name = name;
        setPrice(price); // Setter를 사용해 검증 로직 적용
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    // Day 4: Setter 유효성 검사 로직 (음수 입력 방지)
    public void setPrice(int price) {
        if (price < 0) {
            this.price = 0;
        } else {
            this.price = price;
        }
    }
}
