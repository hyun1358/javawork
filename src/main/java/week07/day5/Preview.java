package week07.day5;

/**
 * [예습 파일] Week 07 Day 5 — String 심화
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
