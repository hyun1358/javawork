package week10.day5;

import java.io.FileWriter;

// 객체의 데이터를 텍스트 파일(CSV 포맷)로 수동 저장하는 클래스입니다.
public class Answer5 {
    public static void main(String[] args) throws Exception {
        // 저장할 Stud 객체를 생성합니다.
        Stud s = new Stud("Kim", 10);
        
        // 텍스트 데이터를 쓰기 위해 FileWriter를 사용합니다.
        try (FileWriter fw = new FileWriter("stud.csv")) {
            // 객체의 속성을 쉼표(,)로 구분된 문자열로 만들어 파일에 씁니다.
            fw.write(s.name + "," + s.age + "\n");
            System.out.println("CSV 수동 저장 완료");
        }
    }
}
