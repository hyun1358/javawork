package week03.day4;

public class Answer4 {
    public static void main(String[] args) {
        String[] products = {"마우스", "키보드", "모니터"};
        int[] prices = {15000, 35000, 150000};
        int maxIdx = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[maxIdx]) maxIdx = i;
        }
        System.out.println("최고가 상품: " + products[maxIdx]);
    }
}
