package week07.day5;

/**
 * [예습 파일] Week 07 Day 5 — String 심화
 * 
 * [핵심 개념: 자바 String 객체의 메모리 매커니즘]
 * 1. String의 불변성 (Immutability):
 *    - 자바의 String 객체는 힙 메모리에 한 번 인스턴스로 생성되면 그 문자열 내용을 절대 변경할 수 없는 불변 상태입니다.
 *    - 문자열을 합치는 연산(`+`)을 수행하면, 기존 글자 뒤에 데이터가 이어 붙는 것이 아니라 힙의 새로운 번지에 새로운 글자를 품은 인스턴스가 계속해서 파생 생성되므로, 대량 연산 시 극심한 가비지 과적을 초래합니다.
 * 
 * 2. String Pool (스트링 풀):
 *    - 리터럴(쌍따옴표 `""`)로 생성된 문자열들은 힙 내의 특별 구역인 String Pool에 딱 하나의 유일한 인스턴스로 관리되며 재사용됩니다.
 *    - new 연산자로 직접 생성한 String 객체는 String Pool을 우회하여 힙의 독립된 영역에 매번 새 주소를 할당받으므로 비효율적입니다.
 */
public class Preview {
    public static void main(String[] args) {
        String s = "Hello Java World";
        System.out.println(s.length()); // 길이
        System.out.println(s.substring(6)); // 자르기
        System.out.println(s.replace("Java", "Spring")); // 교체

        // StringBuilder: 문자열 합칠 때 성능이 훨씬 좋습니다.
        StringBuilder sb = new StringBuilder();
        sb.append("A").append("B").append("C");
        System.out.println(sb.toString());
    }
}
