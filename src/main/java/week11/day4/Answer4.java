package week11.day4;

// 자바 내장 어노테이션인 @Deprecated의 사용 예제입니다.
public class Answer4 {
    // 메인 메서드
    public static void main(String[] args) {
        // @Deprecated로 표시된 메서드를 호출하면 IDE에서 취소선이 그어지며 경고를 발생시킵니다.
        oldMethod(); 
    }

    // 더 이상 사용을 권장하지 않거나 향후 삭제될 예정인 메서드임을 표시하는 어노테이션
    @Deprecated
    public static void oldMethod() {
        System.out.println("구버전");
    }
}
