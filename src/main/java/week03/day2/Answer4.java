package week03.day2;

public class Answer4 {
    public static void main(String[] args) {
        int[] nums = {10, 20, 30, 20, 40, 10};
        System.out.print("중복된 값: ");
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    System.out.print(nums[i] + " ");
                }
            }
        }
    }
}
