package week08.day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [학습 예제] Week 08 Day 1 — 자료구조 컬렉션 ArrayList 기초 (이름 관리, 점수 합계/평균, 객체 리스트 탐색, 순회 중 안전한 삭제 기법, 배열-리스트 양방향 변환)
 * 
 * [학습 핵심 이론: 동적 배열 자료구조 ArrayList]
 * 1. ArrayList의 특징:
 *    - 내부적으로는 일반 1차원 배열을 사용하지만, 배열이 가득 차면 자동으로 더 큰 크기의 새 배열을 생성하고 데이터를 복사하여 크기가 가상으로 무한히 늘어나는 동적 배열 컬렉션입니다.
 *    - 제네릭(`<T>`) 설계로 인해 int, double 같은 기본형은 담을 수 없으므로 래퍼 클래스인 `Integer`, `Double` 등을 지정해 오토박싱(Autoboxing)을 이용해 사용합니다.
 * 
 * 2. 리스트 순회 중 요소 삭제의 함정 (Index Shifting Bug):
 *    - 앞에서부터 순차 순회(`0`에서 `size`-1로 증가)하는 일반 `for`문 내부에서 `remove(i)`를 실행하면, 삭제된 인덱스 뒤에 있던 데이터들이 한 칸씩 앞으로 당겨집니다.
 *    - 이로 인해 바로 다음 요소의 인덱스가 현재 인덱스 `i`로 당겨지는데, 다음 루프에서 `i++`가 되면서 당겨진 다음 요소의 검사를 통째로 건너뛰어 버리는 심각한 버그(Index skipping)가 납니다. (Problem 4 연계)
 *    - [해결책 1]: 인덱스를 뒤에서부터 시작해 0으로 줄여나가는 **역순 순회**를 진행합니다.
 *    - [해결책 2]: Java 8에 도입된 람다 기반의 `removeIf()` 메서드를 적용합니다.
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Week 08 Day 1 학습 예제 ===\n");

        System.out.println("--- Lab1: ArrayList 기본 조작 (추가, 삭제, 전체 순회) (Problem 1 연계) ---");
        Lab1.run();

        System.out.println("\n--- Lab2: Integer 리스트의 합계 및 실수 평균 계산 (Problem 2 연계) ---");
        Lab2.run();

        System.out.println("\n--- Lab3: Student 객체 리스트 특정 이름 검색 필터 (Problem 3 연계) ---");
        Lab3.run();

        System.out.println("\n--- Lab4: 리스트 순회 중 요소 삭제 시 인덱스 밀림 현상과 안전한 삭제 (Problem 4 연계) ---");
        Lab4.run();

        System.out.println("\n--- Lab5: 일반 배열과 ArrayList 간의 완벽한 양방향 변환 (Problem 5 연계) ---");
        Lab5.run();
    }

    // Problem 3 연계 Student 클래스 정의
    static class Student {
        private String name;

        public Student(String name) {
            this.name = name;
        }

        public String getName() { return name; }
    }

    static class Lab1 {
        static void run() {
            // Problem 1: 이름 리스트 관리
            ArrayList<String> names = new ArrayList<>();
            names.add("홍길동");
            names.add("김철수");
            names.add("이유리");

            System.out.println("초기 리스트: " + names);

            names.remove(0); // 0번째 "홍길동" 삭제 -> 김철수, 이유리가 됨
            System.out.println("0번 인덱스 삭제 후:");
            for (String name : names) {
                System.out.println(" - " + name);
            }
        }
    }

    static class Lab2 {
        static void run() {
            // Problem 2: 점수 리스트 통계
            ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(88, 92, 79, 95, 80));
            int sum = 0;
            
            for (int i = 0; i < scores.size(); i++) {
                sum += scores.get(i); // 오토언박싱(Integer -> int) 자동 수행
            }
            double avg = (double) sum / scores.size();

            System.out.println("점수 목록: " + scores);
            System.out.printf("점수 합계: %d | 점수 평균: %.1f\n", sum, avg);
        }
    }

    static class Lab3 {
        static void run() {
            // Problem 3: 객체 검색
            ArrayList<Student> students = new ArrayList<>();
            students.add(new Student("김철수"));
            students.add(new Student("안철수"));
            students.add(new Student("이순신"));
            students.add(new Student("홍길동"));

            String targetName = "이순신";
            boolean found = false;

            for (Student s : students) {
                if (s.getName().equals(targetName)) {
                    System.out.println("학생 검색 성공: \"" + s.getName() + "\" 학생이 리스트에 존재합니다.");
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("검색 실패: \"" + targetName + "\" 학생이 없습니다.");
            }
        }
    }

    static class Lab4 {
        static void run() {
            // Problem 4: 짝수만 남기고 홀수는 삭제하는 리스트 필터링
            // 1. 순방향 삭제 시 버그가 발생하는 원인 시뮬레이션
            ArrayList<Integer> numsBug = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 6, 7, 8));
            System.out.println("원본 데이터: " + numsBug);
            
            for (int i = 0; i < numsBug.size(); i++) {
                if (numsBug.get(i) % 2 != 0) { // 홀수이면 삭제
                    numsBug.remove(i);
                    // 삭제된 순간 뒤의 요소가 앞으로 당겨지는데, 루프 변수 i는 그대로 증가하므로
                    // 연속된 홀수(예: 3 뒤에 바로 붙은 5)의 검사를 뛰어넘는 치명적 버그가 납니다.
                }
            }
            System.out.println("[버그 발생] 순방향 일반 루프로 삭제한 결과: " + numsBug + " (홀수 5가 유실/남아있음)");

            // 2. 안전한 해결책 1: 역순(Backward) 삭제
            ArrayList<Integer> numsCorrect1 = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 6, 7, 8));
            for (int i = numsCorrect1.size() - 1; i >= 0; i--) {
                if (numsCorrect1.get(i) % 2 != 0) {
                    numsCorrect1.remove(i); // 뒤에서부터 자르므로 앞 인덱스 변동에 영향을 주지 않음
                }
            }
            System.out.println("[해결책 1] 역순 루프로 안전하게 삭제한 결과: " + numsCorrect1);

            // 3. 안전한 해결책 2: removeIf (람다 활용)
            ArrayList<Integer> numsCorrect2 = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 6, 7, 8));
            numsCorrect2.removeIf(n -> n % 2 != 0); // 홀수 조건에 맞으면 자동 필터 삭제
            System.out.println("[해결책 2] removeIf()로 안전하게 삭제한 결과: " + numsCorrect2);
        }
    }

    static class Lab5 {
        static void run() {
            // Problem 5: 배열 ↔ 리스트 양방향 변환
            String[] languages = {"Java", "Python", "C++"};
            System.out.println("1. 원시 배열: " + Arrays.toString(languages));

            // [방향 1] 배열 -> 리스트 변환 (Arrays.asList는 고정크기이므로 ArrayList로 감싸야 요소를 추가할 수 있습니다.)
            List<String> list = new ArrayList<>(Arrays.asList(languages));
            list.add("Kotlin");
            System.out.println("2. 변환된 리스트 (Kotlin 추가): " + list);

            // [방향 2] 리스트 -> 배열 변환 (toArray 활용)
            // new String[0]은 빈 배열을 전달하되, JVM이 리스트 크기에 맞춰 알아서 적절한 크기의 새 배열을 할당해 줍니다.
            String[] newArr = list.toArray(new String[0]);
            System.out.println("3. 최종 복원된 배열: " + Arrays.toString(newArr));
        }
    }
}
