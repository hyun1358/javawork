package week04.day2;

import java.util.Arrays;

/**
 * [학습 예제] Week 04 Day 2 — 메서드 매개변수 심화 (참조형 조작, 가변 인자, 프라임 배열 반환, 메서드 오버로딩)
 * 
 * [학습 핵심 이론: Call by Value 매커니즘 및 다형적 호출]
 * 1. 자바의 값 전달 원칙:
 *    - 자바는 무조건 'Call by Value(값에 의한 호출)' 방식으로만 매개변수를 전달합니다.
 * 
 * 2. 참조형 매개변수 (Reference Type Parameter):
 *    - 객체의 주소(참조값)가 복사되어 전달됩니다. 복사된 주소를 통해 동일한 힙(Heap) 영역의 객체를 가리키므로, 메서드 내부에서 배열의 요소를 수정하면 호출 측의 원본 배열도 변경을 겪습니다. (Problem 1 연계)
 * 
 * 3. 가변인자 (Varargs, `Type... name`):
 *    - 인자 개수를 동적으로 결정할 수 있게 해 주며, 메서드 내에서는 배열처럼 사용됩니다. (Problem 2, 3 연계)
 * 
 * 4. 배열 반환 알고리즘:
 *    - 조건에 부합하는 요소를 판별한 후, 동적으로 새 배열을 할당하여 채워 넣고 그 참조 주소를 호출 측에 반환합니다. (Problem 4 연계)
 * 
 * 5. 메서드 오버로딩 (Method Overloading):
 *    - 같은 이름의 메서드를 매개변수의 개수나 타입을 다르게 하여 여러 개 정의하는 기법입니다.
 *    - 인자 개수가 적은 오버로딩 메서드가 기본값(Default value)을 넘겨주며 인자가 많은 오버로딩 메서드를 호출하는 연쇄 호출 패턴은 실무에서 매우 자주 쓰입니다. (Problem 5 연계)
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Week 04 Day 2 학습 예제 ===\n");

        System.out.println("--- Lab1: 기본형 매개변수 (값 복사의 한계) ---");
        Lab1.run();

        System.out.println("\n--- Lab2: 참조형 매개변수 조작 - 배열 요소 2배로 변경 (Problem 1 연계) ---");
        Lab2.run();

        System.out.println("\n--- Lab3: 가변 인자(Varargs)를 활용한 합계 반환 (Problem 2, 3 연계) ---");
        Lab3.run();

        System.out.println("\n--- Lab4: N까지의 소수(Prime) 배열 생성 및 반환 (Problem 4 연계) ---");
        Lab4.run();

        System.out.println("\n--- Lab5: 메서드 오버로딩과 기본값 지정 연쇄 호출 (Problem 5 연계) ---");
        Lab5.run();
    }

    static class Lab1 {
        static void run() {
            int n = 100;
            update(n);
            System.out.println("update 호출 후 main의 n: " + n); // 100 출력 (기본형 복사)
        }

        static void update(int n) {
            n = 200;
        }
    }

    static class Lab2 {
        static void run() {
            // Problem 1: int[]를 받아 모든 원소를 2배로 만드는 doubleAll 구현
            int[] data = {1, 3, 5, 7, 9};
            System.out.println("원래 배열: " + Arrays.toString(data));
            
            doubleAll(data);
            System.out.println("doubleAll 호출 후 원본 배열: " + Arrays.toString(data));
        }

        static void doubleAll(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = arr[i] * 2; // 참조 주소를 따라가 Heap의 원본 값을 직접 2배로 갱신
            }
        }
    }

    static class Lab3 {
        static void run() {
            // Problem 2, 3: 가변 인자를 받아 합계를 구한 뒤 반환하는 sumAll 구현
            int sum1 = sumAll(1, 2, 3);
            int sum2 = sumAll(10, 20, 30, 40, 50);

            System.out.println("sumAll(1, 2, 3) 결과: " + sum1);
            System.out.println("sumAll(10, 20, 30, 40, 50) 결과: " + sum2);
        }

        static int sumAll(int... numbers) {
            int total = 0;
            // numbers는 메서드 안에서 일반 배열과 완전히 동일하게 취급됩니다.
            for (int num : numbers) {
                total += num;
            }
            return total;
        }
    }

    static class Lab4 {
        static void run() {
            // Problem 4: 1~N 범위의 소수(Prime) 배열 반환받기
            int limit = 20;
            int[] primes = getPrimes(limit);
            System.out.println("1부터 " + limit + "까지의 소수 목록: " + Arrays.toString(primes));
        }

        static int[] getPrimes(int n) {
            // 1. 먼저 소수가 총 몇 개인지 임시 카운트
            int count = 0;
            for (int i = 2; i <= n; i++) {
                if (isPrime(i)) {
                    count++;
                }
            }

            // 2. 소수 개수만큼의 크기로 알맞은 정적 배열 할당
            int[] result = new int[count];
            int index = 0;
            for (int i = 2; i <= n; i++) {
                if (isPrime(i)) {
                    result[index++] = i;
                }
            }
            return result; // 생성된 소수 배열의 참조 주소 반환
        }

        // 소수 판별 도우미 메서드
        private static boolean isPrime(int num) {
            if (num < 2) return false;
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) return false;
            }
            return true;
        }
    }

    static class Lab5 {
        static void run() {
            // Problem 5: 메서드 오버로딩 (기본값 설정 패턴) 호출
            greet(); // 매개변수 없음 -> 손님 출력
            greet("홍길동"); // 매개변수 있음 -> 이름 출력
        }

        // 이름이 들어오는 오버로딩 메서드
        static void greet(String name) {
            System.out.println("안녕하세요, " + name + "님!");
        }

        // 인자가 생략되었을 때 호출되는 오버로딩 메서드
        static void greet() {
            // 중복 코드를 작성하는 대신, 기본값인 "손님"을 주어 위의 greet(String)을 호출합니다.
            greet("손님"); 
        }
    }
}
