package week03.day5;

public class Answer3 {
    // 메인 메서드: 두 점 사이의 거리를 계산하는 로직 실행 (피타고라스의 정리 응용)
    public static void main(String[] args) {
        // 첫 번째 점의 좌표 (x1, y1)와 두 번째 점의 좌표 (x2, y2) 초기화
        int x1 = 0, y1 = 0, x2 = 3, y2 = 4;
        
        // Math.pow(a, b)는 a의 b제곱을 반환
        // Math.sqrt(n)는 n의 제곱근(루트)을 반환
        // 거리 공식: 루트((x2 - x1)^2 + (y2 - y1)^2)
        double dist = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        
        // 계산된 두 점 사이의 거리 출력
        System.out.println("거리: " + dist);
    }
}
