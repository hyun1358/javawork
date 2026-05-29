package week12.day3;

// 정규 표현식을 사용하여 간단한 JSON 문자열에서 숫자 값만 추출하는 예제입니다.
public class Answer4 {
    // 메인 메서드
    public static void main(String[] args) {
        // 숫자 데이터를 포함한 간단한 JSON 문자열
        String json = "{\"id\":5}";
        // 정규 표현식 "[^0-9]"를 사용하여 숫자가 아닌 모든 문자(중괄호, 따옴표, 콜론 등)를 빈 문자열로 치환(삭제)합니다.
        String strVal = json.replaceAll("[^0-9]", ""); // 숫자만 남기기
        // 추출된 숫자 형태의 문자열을 실제 int(정수) 타입으로 변환합니다.
        int id = Integer.parseInt(strVal);
        // 파싱된 정수 값을 출력합니다.
        System.out.println("추출된 숫자: " + id);
    }
}
