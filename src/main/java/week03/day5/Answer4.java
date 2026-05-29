package week03.day5;

public class Answer4 {
    // 메인 메서드: 배열에 저장된 단어 중 하나를 무작위로 선택하는 로직 실행
    public static void main(String[] args) {
        // 단어 목록이 담긴 문자열 배열 생성
        String[] words = {"Apple", "Book", "Car", "Java", "Python"};
        
        // Math.random()을 사용하여 0.0 이상 1.0 미만의 실수 생성 후 배열 길이를 곱함
        // 형변환(int)을 통해 0부터 (words.length - 1) 사이의 랜덤한 유효 인덱스 값을 얻음
        int idx = (int) (Math.random() * words.length);
        
        // 생성된 랜덤 인덱스를 사용하여 배열에서 해당 단어를 추출하고 출력
        System.out.println("랜덤 단어: " + words[idx]);
    }
}
