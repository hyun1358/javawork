package week14.day6;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * [14주차 미니 프로젝트] 데이터 처리 파이프라인 (Data Processing Pipeline)
 * 
 * 문제:
 * 1. 이름, 과목, 점수를 가지는 Student 클래스를 작성하세요.
 * 2. 텍스트 형태의 데이터(예: "김철수,수학,85")를 파싱하여 Student 객체 리스트로 만드세요.
 * 3. Stream API를 사용하여 다음 데이터 분석을 수행하세요:
 *    - 80점 이상인 학생 필터링
 *    - 과목별로 학생 그룹화 (groupingBy)
 *    - 과목별 평균 점수 계산 (averagingInt)
 * 4. 분석된 결과를 포맷에 맞춰 콘솔에 출력(Export)하세요.
 *
 * 아래는 위 문제를 해결한 정답 예시(Answer)입니다.
 */
public class FinalProjectAnswer {
    public static void main(String[] args) {
        // 1. Raw 데이터 (파일에서 읽어왔다고 가정)
        List<String> rawData = Arrays.asList(
            "김철수,수학,85", "이영희,영어,92", "박지성,수학,78",
            "최유리,영어,88", "홍길동,수학,95", "강감찬,역사,100"
        );

        System.out.println("=== 데이터 파싱 시작 ===");
        // 2. 파싱 (String -> Student)
        List<Student> students = rawData.stream()
            .map(line -> {
                String[] parts = line.split(",");
                return new Student(parts[0], parts[1], Integer.parseInt(parts[2]));
            })
            .collect(Collectors.toList());
        students.forEach(System.out::println);

        System.out.println("\n=== 분석 1: 85점 이상 우수 학생 ===");
        students.stream()
            .filter(s -> s.getScore() >= 85)
            .forEach(s -> System.out.println(s.getName() + " (" + s.getScore() + "점)"));

        System.out.println("\n=== 분석 2: 과목별 평균 점수 ===");
        Map<String, Double> avgBySubject = students.stream()
            .collect(Collectors.groupingBy(
                Student::getSubject,
                Collectors.averagingInt(Student::getScore)
            ));
        
        avgBySubject.forEach((subject, avg) -> 
            System.out.printf("%s 과목 평균: %.1f점\n", subject, avg)
        );
    }
}

class Student {
    private String name;
    private String subject;
    private int score;

    public Student(String name, String subject, int score) {
        this.name = name;
        this.subject = subject;
        this.score = score;
    }

    public String getName() { return name; }
    public String getSubject() { return subject; }
    public int getScore() { return score; }

    @Override
    public String toString() {
        return "Student{이름='" + name + "', 과목='" + subject + "', 점수=" + score + "}";
    }
}
