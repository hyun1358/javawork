package week11.day4;

// 필드를 가지는 Enum(열거형)을 정의하고 사용하는 예제입니다.
public class Answer1 {
    // 메인 메서드
    public static void main(String[] args) {
        // MONDAY 열거형 상수에 연결된 한글 문자열("월요일")을 가져와 출력합니다.
        System.out.println(Day.MONDAY.getKor());
    }

    // 요일을 나타내는 열거형
    enum Day {
        // 각 상수마다 생성자에 맞게 한글 문자열을 넘겨줍니다.
        MONDAY("월요일"), TUESDAY("화요일");
        
        // 상수가 가지는 추가적인 속성(필드)
        private String kor;
        
        // 열거형의 생성자는 기본적으로 private입니다. 외부에서 호출할 수 없습니다.
        Day(String k) {
            kor = k;
        }
        
        // 필드값을 외부에서 읽을 수 있도록 Getter 제공
        public String getKor() {
            return kor;
        }
    }
}
