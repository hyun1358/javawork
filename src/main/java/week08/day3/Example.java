package week08.day3;

import java.util.*;

/**
 * [학습 예제] Week 08 Day 3 — 객체의 정렬과 비교 Comparable/Comparator (정수 정렬/역정렬, Comparable 객체 정렬, Comparator 이름 정렬, 다중 속성 정렬, 랭킹 및 상위 추출)
 * 
 * [학습 핵심 이론: 자바의 정렬 메커니즘]
 * 1. Comparable 인터페이스 (자연스러운 정렬 - Natural Ordering):
 *    - 클래스의 주 정렬 기준을 클래스 내부에 확정하고자 할 때 구현합니다 (`implements Comparable<T>`).
 *    - `compareTo(T o)`를 오버라이딩합니다:
 *      - 오름차순: `this.value - o.value` (나 - 상대방)
 *      - 내림차순: `o.value - this.value` (상대방 - 나) (Problem 2, 5 연계)
 * 
 * 2. Comparator 인터페이스 (대체 정렬 기준 - Custom Ordering):
 *    - 클래스 자체를 변경하지 않고 임시 정렬 기준(예: 이름 사전순, 보조 정렬 등)을 외부에서 동적으로 부여할 때 사용합니다.
 *    - `compare(T o1, T o2)`를 오버라이딩합니다. (Problem 3, 4 연계)
 * 
 * 3. 다중 정렬 조건 (Multi-criteria Sorting):
 *    - 1차 정렬 기준이 동일할 때, 2차 정렬 조건(예: 이름이 같으면 나이순)을 적용하여 정밀하게 배열/리스트를 배치합니다. (Problem 4 연계)
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Week 08 Day 3 학습 예제 ===\n");

        System.out.println("--- Lab1: Collections.sort()를 통한 정수 리스트 정렬 & 역정렬 (Problem 1 연계) ---");
        Lab1.run();

        System.out.println("\n--- Lab2: Comparable을 구현한 Student 객체의 점수 정렬 (Problem 2 연계) ---");
        Lab2.run();

        System.out.println("\n--- Lab3: Comparator를 활용한 Student 이름 사전순 정렬 (Problem 3 연계) ---");
        Lab3.run();

        System.out.println("\n--- Lab4: 이름이 같을 때 나이순으로 정렬하는 다중 조건 정렬 (Problem 4 연계) ---");
        Lab4.run();

        System.out.println("\n--- Lab5: 정렬 결과로부터 중복 등수를 고려한 Top 3 랭킹 추출 (Problem 5 연계) ---");
        Lab5.run();
    }

    // Problem 2, 5: Comparable을 구현하여 점수 내림차순 정렬이 가능한 Student 클래스
    static class Student implements Comparable<Student> {
        String name;
        int score;

        Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public int compareTo(Student o) {
            // 점수 내림차순(높은 순) 정렬: 상대방 - 나
            return o.score - this.score;
        }
    }

    // Problem 3, 4: 다중 조건을 위한 Student클래스
    static class StudentDetail {
        String name;
        int age;
        int score;

        StudentDetail(String name, int age, int score) {
            this.name = name;
            this.age = age;
            this.score = score;
        }
    }

    static class Lab1 {
        static void run() {
            // Problem 1: 숫자 리스트 정렬
            List<Integer> numbers = new ArrayList<>(Arrays.asList(45, 10, 30, 20, 50, 6, 324));
            System.out.println("정렬 전: " + numbers);

            // 오름차순 정렬
            Collections.sort(numbers);
            System.out.println("오름차순 정렬 결과: " + numbers);

            // 내림차순 정렬
            Collections.sort(numbers, Collections.reverseOrder());
            System.out.println("내림차순 정렬 결과: " + numbers);
        }
    }

    static class Lab2 {
        static void run() {
            // Problem 2: Comparable 구현
            List<Student> students = new ArrayList<>();
            students.add(new Student("일길동", 50));
            students.add(new Student("이길동", 80));
            students.add(new Student("삼길동", 60));
            students.add(new Student("사길동", 70));

            // Student 내부의 compareTo()에 의해 점수 내림차순 정렬됨
            Collections.sort(students);

            System.out.println("점수 내림차순(높은 순) 정렬 학생 목록:");
            for (Student s : students) {
                System.out.printf(" - 이름: %s | 점수: %d\n", s.name, s.score);
            }
        }
    }

    static class Lab3 {
        static void run() {
            // Problem 3: Comparator 구현 (이름순)
            List<StudentDetail> students = new ArrayList<>();
            students.add(new StudentDetail("이길동", 20, 50));
            students.add(new StudentDetail("일길동", 22, 40));
            students.add(new StudentDetail("사길동", 19, 70));
            students.add(new StudentDetail("삼길동", 21, 60));

            // StudentDetail은 Comparable이 없으나 외부 Comparator로 이름 사전순 정렬 부여
            Collections.sort(students, new Comparator<StudentDetail>() {
                @Override
                public int compare(StudentDetail o1, StudentDetail o2) {
                    return o1.name.compareTo(o2.name); // String 사전순 비교 활용
                }
            });

            System.out.println("이름 사전순 정렬 학생 목록:");
            for (StudentDetail s : students) {
                System.out.printf(" - 이름: %s | 나이: %d\n", s.name, s.age);
            }
        }
    }

    static class Lab4 {
        static void run() {
            // Problem 4: 다중 기준 정렬
            List<StudentDetail> students = new ArrayList<>();
            students.add(new StudentDetail("일길동", 40, 80));
            students.add(new StudentDetail("이길동", 50, 95));
            students.add(new StudentDetail("이길동", 30, 85)); // 이름 같음, 나이 다름
            students.add(new StudentDetail("사길동", 70, 70));

            // 정렬 조건: 이름이 같으면 나이순(오름차순), 다르면 이름 사전순
            Collections.sort(students, new Comparator<StudentDetail>() {
                @Override
                public int compare(StudentDetail o1, StudentDetail o2) {
                    if (o1.name.equals(o2.name)) {
                        return o1.age - o2.age; // 나이 오름차순
                    }
                    return o1.name.compareTo(o2.name); // 이름 사전순
                }
            });

            System.out.println("다중 조건(이름순 -> 나이순) 정렬 결과:");
            for (StudentDetail s : students) {
                System.out.printf(" - 이름: %s | 나이: %d\n", s.name, s.age);
            }
        }
    }

    static class Lab5 {
        static void run() {
            // Problem 5: Top 3 추출 (동점 등수 중복 처리)
            List<Student> students = new ArrayList<>();
            students.add(new Student("일길동", 50));
            students.add(new Student("이길동", 65));
            students.add(new Student("삼길동", 65)); // 65점 동점자
            students.add(new Student("사길동", 56));
            students.add(new Student("오길동", 64));
            students.add(new Student("육길동", 43));
            students.add(new Student("칠길동", 34));

            // 1. 점수 높은순 정렬
            Collections.sort(students);

            // 2. 동점 랭킹 순회 추출
            System.out.println("상위 3개 점수 대역 랭킹 추출 결과:");
            int rank = 0;
            int prevScore = -1;

            for (Student s : students) {
                // 이전 점수와 다를 때만 등수를 증가시킴으로써 공동 등수 처리 구현
                if (s.score != prevScore) {
                    rank++;
                }

                if (rank > 3) {
                    break; // 상위 3등 점수대까지만 출력
                }

                System.out.println(" - " + rank + "등: " + s.name + " (" + s.score + "점)");
                prevScore = s.score;
            }
        }
    }
}
