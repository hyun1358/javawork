package week04.day2;

import java.util.Arrays;

public class Answer4 {
    // 메인 메서드: 소수를 구하는 메서드를 호출하고 반환된 배열을 출력
    public static void main(String[] args) {
        // 20까지의 소수를 구하는 메서드 호출
        int[] primes = getPrimes(20);
        // 결과 배열을 문자열로 변환하여 출력
        System.out.println("20까지의 소수: " + Arrays.toString(primes));
    }

    // getPrimes 메서드: 2부터 주어진 숫자 n까지의 소수를 찾아 배열로 반환
    public static int[] getPrimes(int n) {
        // 소수를 임시로 담아둘 배열 생성. 최대 n개일 수 있으므로 크기를 n으로 지정
        int[] temp = new int[n];
        // 찾은 소수의 개수를 기록할 카운터 변수
        int count = 0;
        
        // 2부터 n까지 순회하면서 소수 여부 판별
        for (int i = 2; i <= n; i++) {
            // 현재 수(i)를 소수라고 가정
            boolean isPrime = true;
            // 2부터 i의 제곱근(j * j <= i)까지만 나누어보면 소수 판별 가능 (효율성)
            for (int j = 2; j * j <= i; j++) {
                // 한 번이라도 나누어 떨어지면 소수가 아님
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            // 소수라면 temp 배열에 저장하고 카운터(count) 증가
            if (isPrime) temp[count++] = i;
        }
        // temp 배열에는 뒤에 사용하지 않은 빈 공간(0)이 있으므로,
        // 실제 찾은 개수(count)만큼만 잘라내어 새로운 배열로 반환
        return Arrays.copyOf(temp, count);
    }
}
