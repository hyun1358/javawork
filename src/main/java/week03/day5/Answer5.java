package week03.day5;

public class Answer5 {
    public static void main(String[] args) {
        int[] nums = {-10, 20, -30, 40};
        double sum = 0;
        for (int n : nums) sum += Math.abs(n);
        System.out.println("절대값 평균: " + (sum / nums.length));
    }
}
