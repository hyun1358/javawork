package week06.day4;

/**
 * [연습 문제 5] 템플릿 메서드 패턴
 * 문제: 요리 순서(세척-손질-조리-담기)에서 '조리'만 추상 메서드로 하여 오버라이딩하게 하세요.
 */
public class Problem5 {
    public static void main(String[] args)
    {
        // TODO
        Tteokbokki t = new Tteokbokki();
        t.order();
    }

    static abstract class Food
    {
        void clean() {
            System.out.println("재로를 세척한다.");
        }

        void trim()
        {
            System.out.println("재료를 손질한다.");
        }

        abstract void cook();

        void plate()
        {
            System.out.println("음식을 담다.");
        }

        final void order()
        {
            clean();
            trim();
            cook();
            plate();
        }
    }

    static class Tteokbokki extends Food
    {
        @Override
        void cook()
        {
            System.out.println("떡을 양념에 버무리고 끓인다.");
        }
    }
}
