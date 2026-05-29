package week08.day1;

import java.util.ArrayList;

/**
 * 사용자 정의 객체를 ArrayList에 저장하고 특정 조건의 객체를 검색하는 예제입니다.
 */
public class Answer3 {
    public static void main(String[] args) {
        // StudentAns 객체를 담을 ArrayList를 생성합니다.
        ArrayList<StudentAns> list = new ArrayList<>();
        list.add(new StudentAns("홍길동"));
        list.add(new StudentAns("이순신"));
        
        // 반복문을 통해 이름이 "이순신"인 객체를 찾아서 출력합니다.
        for (StudentAns s : list) {
            if (s.name.equals("이순신")) System.out.println("찾았다: " + s.name);
        }
    }
}

// 이름을 저장하는 간단한 학생 클래스입니다.
class StudentAns {
    String name;

    StudentAns(String n) {
        name = n;
    }
}
