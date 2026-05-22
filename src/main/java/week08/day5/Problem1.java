package week08.day5;

/**
 * [연습 문제 1] 제네릭 클래스 Box
 * 문제: Box<T> 클래스를 만들고 Integer, String을 담아 출력하세요.
 */
public class Problem1 {
    public static void main(String[] args)
    {
        // TODO
        Box<Integer> intBox = new Box<>(30);
        Box<String> strBox = new Box<>("숫자 30");

        System.out.println("Integer : " + intBox.getBox());
        System.out.println("String : " + strBox.getBox());
    }

    static class Box<T>
    {
        T box;

        Box(T box)
        {
            this.box = box;
        }

        T getBox() {return box;}
    }
}
