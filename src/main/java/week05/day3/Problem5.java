package week05.day3;

/**
 * [연습 문제 5] 캡슐화의 이유
 * 문제: 필드를 public으로 뒀을 때와 private으로 뒀을 때의 차이점을
 * 주석으로 적고, 왜 private이 데이터 보호에 유리한지 설명하세요.
 */
public class Problem5 {
    public static void main(String[] args) {
        // TODO: 주석으로 답변 작성

        // public은 메인또는 다른 클래스에서 그냥 해당 필드에 직접접으로 바로 수정 또는 값을 가져올수 있기 때문에 private을 쓴다
        // private은 해당 클래스내에서만 접근이 가능해서
        // getter/setter 를 사용한다.
    }
}
