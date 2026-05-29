package week03.day4;

public class Answer3 {
    // 메인 메서드: 문자열 배열에서 특정 문자열의 위치(인덱스)를 찾는 로직 실행
    public static void main(String[] args) {
        // 탐색 대상이 될 문자열 배열 생성
        String[] names = {"Kim", "Lee", "Park", "Choi"};
        // 찾으려는 값의 인덱스를 저장할 변수, 찾지 못했을 때를 대비해 -1로 초기화
        int index = -1;
        
        // 배열의 모든 요소를 순차 탐색
        for (int i = 0; i < names.length; i++) {
            // 현재 요소가 "Park"과 문자열 내용이 같은지 equals() 메서드로 비교
            if (names[i].equals("Park")) {
                // 일치하는 값을 찾으면 해당 인덱스를 저장
                index = i;
                // 값을 찾았으므로 더 이상의 반복을 중단하고 탈출
                break;
            }
        }
        // 삼항 연산자를 사용하여 index가 -1이면 "없음", 아니면 찾은 인덱스를 출력
        System.out.println("인덱스: " + (index == -1 ? "없음" : index));
    }
}
