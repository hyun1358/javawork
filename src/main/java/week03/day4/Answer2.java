package week03.day4;

public class Answer2 {
    // 메인 메서드: 두 개의 배열(이름과 점수)을 병렬로 순회하며 매칭 출력하는 로직 실행
    public static void main(String[] args) {
        // 학생들의 이름을 저장하는 문자열 배열 생성
        String[] names = {"Kim", "Lee", "Park"};
        // 학생들의 점수를 저장하는 정수형 배열 생성 (names 배열과 인덱스가 일치한다고 가정)
        int[] scores = {80, 95, 70};
        
        // 배열의 길이만큼 반복 (두 배열의 길이가 같으므로 하나의 length 사용)
        for (int i = 0; i < names.length; i++) {
            // 서식 지정자(%s: 문자열, %d: 정수)를 사용하여 각 인덱스에 해당하는 이름과 점수 출력
            System.out.printf("%s의 점수는 %d점입니다.\n", names[i], scores[i]);
        }
    }
}
