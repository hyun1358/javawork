package week08.day2;

import java.util.HashMap;

/**
 * HashMap에 사용자 정의 객체를 값(Value)으로 저장하고 검색하는 예제입니다.
 */
public class Answer3 {
    public static void main(String[] args) {
        // Integer 타입의 학번을 키로, StudentDto 객체를 값으로 갖는 HashMap을 생성합니다.
        HashMap<Integer, StudentDto> db = new HashMap<>();
        // 키 101에 "홍길동" 학생 객체를 저장합니다.
        db.put(101, new StudentDto("홍길동"));

        // 학번 101로 학생 객체를 조회합니다.
        StudentDto s = db.get(101);
        // 조회된 객체가 null이 아닐 경우 학생의 이름을 출력합니다.
        if (s != null) System.out.println("학번 101: " + s.name);
    }
}

// 학생 데이터를 담는 간단한 데이터 전송 객체(DTO) 클래스입니다.
class StudentDto {
    String name;

    StudentDto(String n) {
        name = n;
    }
}
