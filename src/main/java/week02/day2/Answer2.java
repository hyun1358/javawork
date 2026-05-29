package week02.day2;

import java.util.Scanner;

/*
 * [정답 + 해설 2] Week 02 Day 2
 * 문제: 월 입력 -> 계절 출력
 */
public class Answer2 {
    public static void main(String[] args) {
        // 여러 개의 case에 대해 동일한 작업을 수행해야 할 경우, 의도적으로 break를 생략(Fall-through)할 수 있습니다.
        // 이를 통해 코드를 훨씬 짧게 작성할 수 있습니다. (예: 3, 4, 5월 모두 "봄" 출력)
        Scanner sc = new Scanner(System.in);
        System.out.print("월을 입력하세요(1~12): ");
        int month = sc.nextInt();

        switch (month) {
            case 3:
            case 4:
            case 5:
                System.out.println("봄");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("여름");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("가을");
                break;
            case 12:
            case 1:
            case 2:
                System.out.println("겨울");
                break;
            default:
                System.out.println("잘못된 입력");
        }

        sc.close();
    }
}
/*
 * [해설]
 * - 여러 case를 한 줄에 나열하거나 세로로 나열하여 break를 한 번만 쓰면,
 *   그 중 어떤 값이라도 해당될 때 같은 코드가 실행됩니다. (OR 조건과 유사)
 */
