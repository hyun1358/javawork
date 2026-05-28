package week07.day5;

import java.util.Arrays;

/**
 * [학습 예제] Week 07 Day 5 — String 클래스와 효율적 가공 (회문 판별, 문자열 빈도 계수, split 토큰 분리, StringBuilder 문자열 조립, String.format 격자 출력)
 * 
 * [학습 핵심 이론: 실무형 문자열 제어와 성능 최적화]
 * 1. String의 불변성 (Immutability):
 *    - String 객체는 메모리상에서 내부 값이 변경되지 않는 불변성을 가집니다.
 *    - 루프 내에서 `str += "a"`와 같이 문자열 더하기 연산을 반복하면 매번 새로운 String 객체가 힙 메모리에 생겨나 성능이 심각히 손상됩니다.
 * 
 * 2. StringBuilder의 가치:
 *    - 내부 가변 문자배열 버퍼를 제공하므로, 루프 내부의 동적 결합 시 메모리 낭비 없이 고속으로 글자를 조립할 수 있습니다. (Problem 4 연계)
 * 
 * 3. String.split()과 토큰화:
 *    - 특정 구분자(Delimiter)를 기준으로 삼아 문자열을 조각내어 `String[]` 배열로 획득합니다. (Problem 3 연계)
 * 
 * 4. String.format()의 정렬/패딩 옵션:
 *    - `%s`, `%d` 등의 지시어와 자리수 지정(`%-10s`: 10글자 좌측 정렬)을 결합하여 가독성 높은 표(Grid) 형태 출력을 손쉽게 완성할 수 있습니다. (Problem 5 연계)
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Week 07 Day 5 학습 예제 ===\n");

        System.out.println("--- Lab1: 문자열 역순 변환 및 회문(Palindrome) 판별 (Problem 1 연계) ---");
        Lab1.run();

        System.out.println("\n--- Lab2: 특정 문자열의 등장 횟수 빈도 측정 (Problem 2 연계) ---");
        Lab2.run();

        System.out.println("\n--- Lab3: split(\"/\")을 이용한 슬래시 구분 데이터 토큰화 (Problem 3 연계) ---");
        Lab3.run();

        System.out.println("\n--- Lab4: 문자열 반복 연산 시 String vs StringBuilder 성능 비교 (Problem 4 연계) ---");
        Lab4.run();

        System.out.println("\n--- Lab5: String.format을 활용한 정렬 규격 표 출력 (Problem 5 연계) ---");
        Lab5.run();
    }

    static class Lab1 {
        static void run() {
            // Problem 1: 뒤집어서 원본과 똑같은지 회문 판별
            String[] testWords = {"abcba", "hello", "토마토"};
            for (String word : testWords) {
                String reversed = "";
                // 뒤에서부터 글자씩 획득해 뒤집기
                for (int i = word.length() - 1; i >= 0; i--) {
                    reversed += word.charAt(i);
                }
                boolean isPalindrome = word.equals(reversed);
                System.out.printf("원본: \"%s\" | 뒤집힘: \"%s\" -> 회문 여부: %b\n", word, reversed, isPalindrome);
            }
        }
    }

    static class Lab2 {
        static void run() {
            // Problem 2: 문자열 안의 특정 문자 개수 카운트
            String str = "asdcdacdascdvasdxccsxcvfa";
            String target = "c";
            int count = 0;

            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                // 문자를 문자열로 변환하여 equals 비교
                if (String.valueOf(ch).equals(target)) {
                    count++;
                }
            }
            System.out.printf("대상 문자열: \"%s\"\n찾을 문자: '%s' | 총 개수: %d개\n", str, target, count);
        }
    }

    static class Lab3 {
        static void run() {
            // Problem 3: "홍길동/20/남" split 분리
            String data = "홍길동/20/남";
            String[] tokens = data.split("/");
            System.out.println("원시 문자열: " + data);
            System.out.println("split 분리 결과 배열: " + Arrays.toString(tokens));
            
            // 일괄 출력
            for (int i = 0; i < tokens.length; i++) {
                System.out.printf("토큰[%d]: %s\n", i, tokens[i]);
            }
        }
    }

    static class Lab4 {
        static void run() {
            // Problem 4: StringBuilder 활용법 및 성능 강점 설명
            String piece = "a";
            
            // 1. StringBuilder를 이용한 효율적인 조립
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 10; i++) {
                sb.append(piece); // 객체 재성성 없이 가변 버퍼에 추가
            }
            String result = sb.toString();
            System.out.println("StringBuilder 10회 조립 결과: " + result);

            System.out.println("[이론 가이드] 반복문 내 문자열 연산 시, 일반 String 더하기(+=)는 힙에 10개의 가비지 객체를 만듭니다.");
            System.out.println("반면, StringBuilder는 단 하나의 내부 버퍼만 유지하여 수천 배 이상 빠르고 가볍게 처리됩니다.");
        }
    }

    static class Lab5 {
        static void run() {
            // Problem 5: String.format 정렬 표 출력
            String[][] userTable = {
                {"홍길동", "85"},
                {"김철수", "100"},
                {"김영희", "92"}
            };

            System.out.println("\n===== [String.format 정밀 정렬 표] =====");
            System.out.printf("%-6s\t%-5s\n", "이름", "점수");
            System.out.println("----------------------------------------");
            for (String[] row : userTable) {
                // %-6s: 6글자 폭 할당 후 좌측 정렬 패딩
                System.out.print(String.format("%-6s\t%-5s\n", row[0], row[1]));
            }
            
            // 보너스: 1,000,000 단위 콤마 쉼표 포맷팅
            System.out.println("----------------------------------------");
            System.out.println(String.format("보너스 천단위 콤마 서식: %,d원", 1000000));
        }
    }
}
