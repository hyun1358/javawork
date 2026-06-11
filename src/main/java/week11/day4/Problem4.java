package week11.day4;

/**
 * [연습 문제 4] @Deprecated 활용
 * 문제: 오래된 메서드 oldMethod()에 @Deprecated를 붙이고 호출해 경고가 뜨는지 확인하세요.
 */
public class Problem4 {
    public static void main(String[] args)
    {
        // TODO
        LegacyMethod legacy = new LegacyMethod();
        System.out.println(legacy.oldMethod());
        legacy.newMethod();
    }

    static class LegacyMethod
    {
        @Deprecated public String oldMethod() {return "legacy 메소드"; };
        public void newMethod() { System.out.println("최신 기능 메소드"); }
    }
}
