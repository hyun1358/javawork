package week03.day4;

public class Answer4 {
    // 메인 메서드: 두 배열(상품명, 가격)을 이용해 가장 비싼 상품을 찾는 로직 실행
    public static void main(String[] args) {
        // 상품 이름을 저장하는 문자열 배열
        String[] products = {"마우스", "키보드", "모니터"};
        // 각 상품의 가격을 저장하는 정수형 배열
        int[] prices = {15000, 35000, 150000};
        
        // 최고가를 기록할 인덱스를 0(첫 번째 요소)으로 초기 가정
        int maxIdx = 0;
        
        // 두 번째 요소(인덱스 1)부터 끝까지 반복하면서 최고가 찾기
        for (int i = 1; i < prices.length; i++) {
            // 현재 요소의 가격이 지금까지 찾은 최고가보다 크다면
            if (prices[i] > prices[maxIdx]) {
                // 최고가 인덱스를 현재 인덱스로 갱신
                maxIdx = i;
            }
        }
        // 찾은 최고가 인덱스를 이용해 해당하는 상품명 출력
        System.out.println("최고가 상품: " + products[maxIdx]);
    }
}
