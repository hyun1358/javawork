package week07.day5;

/**
 * split 메서드를 활용하여 특정 단어의 등장 횟수를 세는 예제입니다.
 */
public class Answer2 {
    public static void main(String[] args) {
        String s = "apple banana apple orange apple";
        String target = "apple";
        // target 단어를 기준으로 문자열을 분리합니다. -1을 주어 빈 문자열도 포함시킵니다.
        // 분리된 배열의 길이에서 1을 빼면 구분자로 사용된 target 단어의 개수를 구할 수 있습니다.
        int count = s.split(target, -1).length - 1;
        System.out.println("apple 개수: " + count);
    }
}
