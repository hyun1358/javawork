package week05.day1;

/*
 * [정답 + 해설 5] Week 05 Day 1
 * 문제: 객체 배열 활용
 */
public class Answer5 {
    public static void main(String[] args) {
        // 1. 배열 생성 (Student 객체 3개를 참조할 수 있는 배열 공간을 메모리에 마련합니다)
        Student[] students = new Student[3];

        // 2. 각 배열의 요소(방)에 실제 Student 객체를 생성하여 대입하고 초기화합니다.
        students[0] = new Student();
        students[0].name = "김자바";
        students[0].score = 90;

        students[1] = new Student();
        students[1].name = "이객체";
        students[1].score = 85;

        students[2] = new Student();
        students[2].name = "박클래스";
        students[2].score = 95;

        // 3. for 반복문을 사용하여 배열에 저장된 모든 학생 객체의 정보에 순차적으로 접근하여 출력합니다.
        System.out.println("--- 학생 명단 ---");
        for (int i = 0; i < students.length; i++) {
            System.out.println("이름: " + students[i].name + ", 점수: " + students[i].score);
        }
    }
}

// [클래스 설명] Student 클래스는 학생의 이름과 점수 데이터를 묶어 단일 단위로 다루기 위한 틀입니다.
class Student {
    String name;
    int score;
}
